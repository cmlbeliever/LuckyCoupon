package com.cml.mvc.redis.service;

import java.util.List;
import java.util.Map;

import com.cml.mvc.beans.TCoupon;
import com.cml.mvc.beans.TUserCoupon;

public interface LuckyCouponService {

	String KEY_USER_COUPON = "key_user_coupon";

	public Long setLuckyCoupon(Long userId);

	public List<TUserCoupon> getUserCoupons(Map<String, Object> params);

	/**
	 * 获取所有抢的优惠券
	 * 
	 * @return
	 */
	List<TCoupon> getLuckyCoupons();

	/**
	 * 分配用户优惠券
	 * 
	 * @return
	 */
	Integer doAssignLuckCoupons();
}
