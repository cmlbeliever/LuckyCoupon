package com.cml.mvc.redis.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

import com.cml.mvc.beans.TCoupon;
import com.cml.mvc.beans.TUserCoupon;
import com.cml.mvc.constant.Const;
import com.cml.mvc.redis.service.LuckyCouponService;
import com.cml.mvc.redis.service.RedisCacheService;

@Service("redisCacheServiceImpl")
public class RedisCacheServiceImpl implements RedisCacheService,
		InitializingBean {

	private static final Logger LOG = Logger
			.getLogger(RedisCacheServiceImpl.class);

	@Resource(name = "luckyCouponService")
	private LuckyCouponService luckyCouponService;

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, TUserCoupon> userCouponTemplate;

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, TCoupon> couponTemplate;

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Integer> integerTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {

		long startTime = System.currentTimeMillis();

		// 插入初始化数据 优惠券数据
		userCouponTemplate.execute(new SessionCallback<List<Object>>() {

			@Override
			public <K, V> List<Object> execute(RedisOperations<K, V> operations)
					throws DataAccessException {

				userCouponTemplate.multi();

				// 加载coupon数据

				List<TCoupon> luckyCoupons = luckyCouponService
						.getLuckyCoupons();
				for (TCoupon coupon : luckyCoupons) {
					// 将数据以pref+couponID的形式存储
					couponTemplate.boundValueOps(
							KEY_COUPON_PREFIX + coupon.getCouponId()).set(
							coupon);

					// 加载userCoupon数据
					BoundSetOperations<String, TUserCoupon> setOpera = userCouponTemplate
							.boundSetOps(KEY_USER_COUPON_PREFIX
									+ coupon.getCouponId());

					initUserCoupons(setOpera, coupon.getCouponId());
				}

				return userCouponTemplate.exec();
			}

		});

		LOG.info("=======>数据初始化完成，耗时："
				+ (System.currentTimeMillis() - startTime) + "ms");
	}

	private void initUserCoupons(
			BoundSetOperations<String, TUserCoupon> setOpera, int couponId) {

		int batchSize = 3000;
		int batchCount = 10;

		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Const.DbParams.LIMIT, batchSize);
		params.put("couponId", couponId);

		for (int i = 0; i < batchCount; i++) {
			params.put(Const.DbParams.OFFSET, i * batchSize);

			List<TUserCoupon> userCoupons = luckyCouponService
					.getUserCoupons(params);

			setOpera.add(userCoupons.toArray(new TUserCoupon[] {}));

			if (userCoupons.size() < batchSize) {
				break;
			}

		}

	}

	@Override
	public boolean isAllowAssign(Long userId, int couponId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<TCoupon> getLuckyCoupons(Long userId) {
		Set<String> couponKeys = couponTemplate.keys(KEY_COUPON_PREFIX + "*");

		Set<TCoupon> allowCoupons = new HashSet<TCoupon>();

		if (null != couponKeys && couponKeys.size() > 0) {
			for (String key : couponKeys) {

				// 获取优惠券对象
				TCoupon coupon = couponTemplate.boundValueOps(
						KEY_COUPON_PREFIX + key).get();
				if (null == coupon) {
					continue;
				}

				// 判断用户分配的数量
				int maxCount = coupon.getMaxAssignCount();

				// prefix:couponId:userId
				Integer assignValue = integerTemplate.boundValueOps(
						KEY_ASSIGN_USER_COUPON_PREFIX + KEY_SPERATOR
								+ coupon.getCouponId() + KEY_SPERATOR + userId)
						.get();

				// 分配优惠券数量小于最大可分配数量
				if (assignValue == null || assignValue.intValue() < maxCount) {
					allowCoupons.add(coupon);
				}

			}
		}

		return allowCoupons;
	}
}
