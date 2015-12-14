package com.cml.mvc.redis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.cml.mvc.beans.TUserCoupon;
import com.cml.mvc.redis.service.LuckyCouponService;

@Service("luckyCouponService")
public class LuckyCouponServiceImpl implements LuckyCouponService,
		ApplicationContextAware, InitializingBean {

	private static final Logger LOG = Logger
			.getLogger(LuckyCouponServiceImpl.class);

	@Resource(name = "redisTemplate")
	private SetOperations<String, TUserCoupon> userCouponOperation;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, TUserCoupon> template;

	@Override
	@Cacheable(value = "va", key = "sd")
	public Long setLuckyCoupon(Long userId) {

		LOG.info("--setLuckyCoupon---->" + userId);

		// redis并不保证事务在同一个连接上执行
		userCouponOperation.getOperations().multi();
		for (int i = 10; i < 20; i++) {
			TUserCoupon tuc = new TUserCoupon();
			tuc.setCouponId(i);
			tuc.setId(i);
			userCouponOperation.add(KEY_USER_COUPON, tuc);
		}

		if (1 == 1) {
			throw new RuntimeException("ddddddd");
		}

		template.set("add11", new TUserCoupon());

		userCouponOperation.getOperations().exec();

		return System.currentTimeMillis();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		LOG.info("==setApplicationContext===>" + applicationContext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.info("==afterPropertiesSet===>");

	}

}
