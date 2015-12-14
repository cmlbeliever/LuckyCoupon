package com.cml.mvc.redis.service;

import java.util.List;

import com.cml.mvc.beans.TUserCoupon;

public interface RedisCacheService {

	String KEY_USER_COUPON = "key_cache_user_coupon";

	Integer storeUserCoupons(List<TUserCoupon> coupons);

	TUserCoupon loadUserCoupons();

}
