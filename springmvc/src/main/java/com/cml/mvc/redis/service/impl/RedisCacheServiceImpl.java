package com.cml.mvc.redis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cml.mvc.beans.TUserCoupon;
import com.cml.mvc.redis.service.RedisCacheService;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

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

}
