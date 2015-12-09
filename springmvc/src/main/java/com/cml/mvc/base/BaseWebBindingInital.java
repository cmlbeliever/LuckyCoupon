package com.cml.mvc.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class BaseWebBindingInital extends ConfigurableWebBindingInitializer {
	private static final Log LOG = LogFactory
			.getLog(BaseWebBindingInital.class);

	private String timeFormatter;

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {

		LOG.info("validators===>"+binder.getValidators());
		super.initBinder(binder, request);
		// 没有找到propertyEditor，会自动使用属性转换数据
		// binder.registerCustomEditor(DateTime.class, new
		// JodaTimePropertyEditor(
		// timeFormatter));
		// 设置string自动trim
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

		LOG.debug("DefaultWebBindingInitializer->initBinder=====>timeFormatter:"
				+ timeFormatter);
	}

	public String getTimeFormatter() {
		return timeFormatter;
	}

	public void setTimeFormatter(String timeFormatter) {
		this.timeFormatter = timeFormatter;
	}

}
