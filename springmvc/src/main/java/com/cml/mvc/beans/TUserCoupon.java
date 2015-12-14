package com.cml.mvc.beans;

import org.joda.time.DateTime;

@SuppressWarnings("serial")
public class TUserCoupon extends BaseBeans {

	private Integer id;
	private Integer couponId;
	private Integer userId;
	private Integer useFlg;
	private DateTime bindDate;
	private String bindDateStr;
	private String version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUseFlg() {
		return useFlg;
	}

	public void setUseFlg(Integer useFlg) {
		this.useFlg = useFlg;
	}

	public DateTime getBindDate() {
		return bindDate;
	}

	public void setBindDate(DateTime bindDate) {
		this.bindDate = bindDate;
	}

	public String getBindDateStr() {
		return bindDateStr;
	}

	public void setBindDateStr(String bindDateStr) {
		this.bindDateStr = bindDateStr;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "TUserCoupon [id=" + id + ", couponId=" + couponId + ", userId="
				+ userId + ", useFlg=" + useFlg + ", bindDate=" + bindDate
				+ ", bindDateStr=" + bindDateStr + ", version=" + version + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TUserCoupon other = (TUserCoupon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
