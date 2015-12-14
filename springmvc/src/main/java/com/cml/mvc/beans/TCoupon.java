package com.cml.mvc.beans;

public class TCoupon extends BaseBeans {

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

	@Override
	public String toString() {
		return "TCoupon [couponId=" + couponId + ", name=" + name + ", type="
				+ type + ", maxAssignCount=" + maxAssignCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((couponId == null) ? 0 : couponId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TCoupon other = (TCoupon) obj;
		if (couponId == null) {
			if (other.couponId != null)
				return false;
		} else if (!couponId.equals(other.couponId))
			return false;
		return true;
	}

}
