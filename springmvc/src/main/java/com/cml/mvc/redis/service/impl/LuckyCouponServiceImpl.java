package com.cml.mvc.redis.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.DefaultKeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cml.mvc.beans.TUserCoupon;
import com.cml.mvc.redis.service.LuckyCouponService;

@Service("luckyCouponService")
public class LuckyCouponServiceImpl implements LuckyCouponService,
		ApplicationContextAware, InitializingBean {

	private static final Logger LOG = Logger
			.getLogger(LuckyCouponServiceImpl.class);

	@Resource(name = "redisTemplate")
	private SetOperations<String, TUserCoupon> userCouponOperation;

	@Override
	@Cacheable(value="va",key="sd")
	public Long setLuckyCoupon(Long userId) {
		
		LOG.info("--setLuckyCoupon---->"+userId);

		userCouponOperation.getOperations().multi();
		for (int i = 10; i < 20; i++) {
			TUserCoupon tuc = new TUserCoupon();
			tuc.setCouponId(i);
			tuc.setId(i);
			userCouponOperation.add(KEY_USER_COUPON, tuc);
		}

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
