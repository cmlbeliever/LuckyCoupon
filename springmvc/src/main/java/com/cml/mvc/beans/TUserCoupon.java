package com.cml.mvc.beans;

import java.io.Serializable;

public class TUserCoupon implements Serializable {

	private int id;
	private int couponId;
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TUserCoupon [id=" + id + ", couponId=" + couponId + ", userId="
				+ userId + "]";
	}

}
