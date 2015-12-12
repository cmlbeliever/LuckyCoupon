package com.cml.mvc.redis.service;

public interface LuckyCouponService {
	
	String KEY_USER_COUPON = "key_user_coupon";

	public Long setLuckyCoupon(Long userId);
}
