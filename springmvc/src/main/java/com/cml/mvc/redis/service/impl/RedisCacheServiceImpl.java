package com.cml.mvc.redis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

import com.cml.mvc.beans.TUserCoupon;
import com.cml.mvc.constant.Const;
import com.cml.mvc.framework.constant.Constant;
import com.cml.mvc.redis.service.LuckyCouponService;
import com.cml.mvc.redis.service.RedisCacheService;

@Service
public class RedisCacheServiceImpl implements RedisCacheService,
		InitializingBean {

	private static final Logger LOG = Logger
			.getLogger(RedisCacheServiceImpl.class);

	@Resource(name = "luckyCouponService")
	private LuckyCouponService luckyCouponService;

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, TUserCoupon> userCouponTemplate;

	@Override
	public Integer storeUserCoupons(List<TUserCoupon> coupons) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TUserCoupon loadUserCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO 完成初始化数据操作
		// TODO 加入init数据
		boolean existData = userCouponTemplate.hasKey(KEY_USER_COUPON);

		LOG.info(String.format("key:%s是否存在？%s=>", KEY_USER_COUPON, existData));

		if (!existData) {
			// 插入初始化数据
			List<Object> result = userCouponTemplate
					.execute(new SessionCallback<List<Object>>() {

						@Override
						public <K, V> List<Object> execute(
								RedisOperations<K, V> operations)
								throws DataAccessException {

							userCouponTemplate.multi();

							BoundSetOperations<String, TUserCoupon> setOpera = userCouponTemplate
									.boundSetOps(KEY_USER_COUPON);

							initUserCoupons(setOpera);

							return userCouponTemplate.exec();
						}

					});

			LOG.info("init data result====>"
					+ (result == null ? 0 : result.size()) + ",redis:"
					+ userCouponTemplate.boundSetOps(KEY_USER_COUPON).size());

		}
	}

	private void initUserCoupons(
			BoundSetOperations<String, TUserCoupon> setOpera) {

		int batchSize = 3000;
		int batchCount = 10;

		Map<String, Object> params = new HashMap<String, Object>();
		params.put(Const.DbParams.LIMIT, batchSize);

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

}
