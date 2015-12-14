package com.cml.mvc.redis.service;

public interface RedisCacheService {

	String KEY_USER_COUPON_PREFIX = "key_cache_user_coupon_";
	String KEY_COUPON_PREFIX = "key_cache_coupons_";
	/** 用户分配优惠券key前缀 */
	String KEY_ASSIGN_USER_COUPON_PREFIX = "key_coupon_assign_";

	String KEY_SPERATOR = ":";

	/**
	 * 判断用户是否可以分配优惠券
	 * 
	 * @param userId
	 * @return
	 */
	boolean isAllowAssign(Long userId, int couponId);

	Long getLuckyCoupons(Long userId);

}
