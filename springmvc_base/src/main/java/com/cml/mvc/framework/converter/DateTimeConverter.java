package com.cml.mvc.framework.converter;

import com.cml.mvc.framework.converter.datetime.BaseJodaModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * DateTime json返回日期格式化
 * 
 * @author 陈孟琳
 *
 *         2015年4月30日
 */
public class DateTimeConverter extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public DateTimeConverter() {
		this.registerModule(new BaseJodaModule());
		this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
}
