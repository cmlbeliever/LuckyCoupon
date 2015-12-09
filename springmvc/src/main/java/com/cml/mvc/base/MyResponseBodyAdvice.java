package com.cml.mvc.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.cml.mvc.beans.Result;

public class MyResponseBodyAdvice implements ResponseBodyAdvice<Result> {

	private static Log log = LogFactory.getLog(MyResponseBodyAdvice.class);

	@Override
	public boolean supports(MethodParameter returnType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		log.debug("MyResponseBodyAdvice==>supports:" + converterType);
		log.debug("MyResponseBodyAdvice==>supports:" + returnType.getClass());
		
		// return MappingJackson2HttpMessageConverter.class
		// .isAssignableFrom(converterType);
		return returnType.getGenericParameterType() == Result.class;
		// return converterType.getClass() == Result.class;
	}

	@Override
	public Result beforeBodyWrite(Result body, MethodParameter returnType,
			MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {

		log.debug("MyResponseBodyAdvice==>beforeBodyWrite:" + returnType + ","
				+ body);

		body.setB("我是后面设置的");
		return body;
	}

}
