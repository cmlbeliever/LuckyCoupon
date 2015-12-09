package com.cml.mvc.framework.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ErrorsUtil {
	public static String getAllErrors(Errors errors) {
		StringBuilder builder = new StringBuilder();
		for (ObjectError error : errors.getAllErrors()) {
			builder.append(error.getDefaultMessage()).append("\n");
		}
		return builder.toString();
	}
}
