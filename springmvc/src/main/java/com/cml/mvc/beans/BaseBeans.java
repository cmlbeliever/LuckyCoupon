package com.cml.mvc.beans;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.redis.core.StringRedisTemplate;

public class BaseBeans implements Serializable {
	private DateTime createDate;
	private String createDateStr;
	private DateTime updateDate;
	private String updateDateStr;

	public DateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(DateTime createDate) {
		this.createDate = createDate;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public DateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateDateStr() {
		return updateDateStr;
	}

	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}

}
