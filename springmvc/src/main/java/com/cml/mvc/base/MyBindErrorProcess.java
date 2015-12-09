package com.cml.mvc.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.PropertyAccessException;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;

public class MyBindErrorProcess implements BindingErrorProcessor {

	private static Log log = LogFactory.getLog(MyBindErrorProcess.class);

	@Override
	public void processMissingFieldError(String missingField,
			BindingResult bindingResult) {
		log.error("绑定错误processMissingFieldError：" + missingField);
	}

	@Override
	public void processPropertyAccessException(PropertyAccessException ex,
			BindingResult bindingResult) {

		log.error("绑定错误processPropertyAccessException：" + ex.getMessage());
		log.info("转换失败：" + ex.getPropertyName());
		log.info("转换失败：" + ex.getValue());
		log.info("转换失败：" + ex.getPropertyChangeEvent());
		bindingResult.reject(ex.getPropertyName() + "转换失败");
	}

}
