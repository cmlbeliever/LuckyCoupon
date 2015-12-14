package com.cml.mvc.redis.dao;

import java.util.List;
import java.util.Map;

import com.cml.mvc.beans.TUserCoupon;

public interface LuckyCouponMapper {
	List<TUserCoupon> getUserCoupons(Map<String, String> params);
}
