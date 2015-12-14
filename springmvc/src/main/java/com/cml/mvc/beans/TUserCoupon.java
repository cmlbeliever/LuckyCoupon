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

}
