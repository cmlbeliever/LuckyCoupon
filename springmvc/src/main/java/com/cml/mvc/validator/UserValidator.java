package com.cml.mvc.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cml.mvc.model.User;

public class UserValidator implements Validator {

	private static final Log LOG = LogFactory.getLog(UserValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		LOG.debug("=============valiator.supports===>" + (clazz == User.class));
		return clazz == User.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		LOG.debug("=============validate===>" + target);
//
//		User user = (User) target;
//		ValidationUtils.rejectIfEmpty(errors, "age", "user.age.notnull");
//		errors.reject("123", "我就是不让你过啊！哈哈");
	}

}
