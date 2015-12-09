package com.cml.mvc.beans;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private Integer id;
	private String name;

	private DateTime updateDate;

	public DateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", updateDate="
				+ updateDate + "]";
	}

}
