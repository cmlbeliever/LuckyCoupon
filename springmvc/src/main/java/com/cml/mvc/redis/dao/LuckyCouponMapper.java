package com.cml.mvc.redis.dao;

import java.util.List;
import java.util.Map;

import com.cml.mvc.beans.TCoupon;
import com.cml.mvc.beans.TUserCoupon;

public interface LuckyCouponMapper {
	List<TUserCoupon> getUserCoupons(Map<String, Object> params);
	List<TCoupon> getLuckyCoupons();
}
