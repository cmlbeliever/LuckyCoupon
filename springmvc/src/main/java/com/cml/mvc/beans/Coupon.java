package com.cml.mvc.beans;

public class Coupon extends BaseBeans {
	private Integer couponId;
	private String name;
	private Integer type;
	private Integer maxAssignCount;

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMaxAssignCount() {
		return maxAssignCount;
	}

	public void setMaxAssignCount(Integer maxAssignCount) {
		this.maxAssignCount = maxAssignCount;
	}

}
