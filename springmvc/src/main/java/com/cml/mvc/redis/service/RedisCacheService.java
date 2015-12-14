package com.cml.mvc.redis.service;

import java.util.List;

import com.cml.mvc.beans.TUserCoupon;

public interface RedisCacheService {
	
	Integer storeUserCoupons(List<TUserCoupon> coupons);

	TUserCoupon loadUserCoupons();

	
}
