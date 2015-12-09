package com.cml.mvc.base;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MyReturnValues implements HandlerMethodReturnValueHandler{

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		System.out.println("supportsReturnType==========:" + returnType);
		SimpleMappingExceptionResolver a;
		return true;
	}

	@Override
	public void handleReturnValue(Object returnValue,
			MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		System.out.println("handleReturnValue===============:" + returnValue);
	}

}
