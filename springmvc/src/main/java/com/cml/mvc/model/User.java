package com.cml.mvc.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@NotBlank(message = "{user.name.illegal}")
	private String username;
	private String name;
	private Integer age;
	
	@NotNull
	private Integer high;
	
	@DateTimeFormat(pattern="yyyyMMddHmmss")
	private DateTime birthday;

	public DateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", age=" + age
				+ ", high=" + high + ", birthday=" + birthday + "]";
	}

}
