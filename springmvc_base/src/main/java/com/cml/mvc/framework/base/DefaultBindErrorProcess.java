package com.cml.mvc.framework.base;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.PropertyAccessException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;

/**
 * 绑定错误信息处理类<br/>
 * (1)字段miss错误信息：fieldName+".miss"<br/>
 * (2)转换错误信息：fieldName+".parse.invalid"<br/>
 * 
 * @author 陈孟琳
 *
 *         2015年4月28日
 */
public class DefaultBindErrorProcess implements BindingErrorProcessor {

	private static Log log = LogFactory.getLog(DefaultBindErrorProcess.class);

	public static final String CODE_FIELD_MISSING = "error.field.miss";
	public static final String CODE_PARSE_INVALID = "error.parse.invalid";

	private ResourceBundleMessageSource messageSource;

	private boolean rejectOnError;

	@Override
	public void processMissingFieldError(String missingField,
			BindingResult bindingResult) {
		if (rejectOnError) {
			String error = messageSource.getMessage(CODE_FIELD_MISSING,
					new String[] { missingField }, Locale.getDefault());
			bindingResult.reject(missingField, error);
		}
	}

	@Override
	public void processPropertyAccessException(PropertyAccessException ex,
			BindingResult bindingResult) {

		if (rejectOnError) {
			String error = messageSource.getMessage(CODE_PARSE_INVALID,
					new String[] { ex.getPropertyName() }, Locale.getDefault());
			bindingResult.reject(ex.getPropertyName(), error);
		}

		log.debug("processPropertyAccessException==>proName:["
				+ ex.getPropertyName() + "],value=[" + ex.getValue() + "]");

	}

	public void setRejectOnError(boolean rejectOnError) {
		this.rejectOnError = rejectOnError;
	}

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
