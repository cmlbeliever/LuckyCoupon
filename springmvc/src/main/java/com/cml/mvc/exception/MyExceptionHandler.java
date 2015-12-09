package com.cml.mvc.exception;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cml.mvc.beans.Result;
import com.google.gson.Gson;

public class MyExceptionHandler implements HandlerExceptionResolver {

	private static Log log = LogFactory.getLog(MyExceptionHandler.class);
	private ResourceBundleMessageSource messageSource;

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		log.info("异常捕获=======>" + ex);
		log.info("异常捕获=======>" + handler);
		Result result = new Result();

		// 返回错误信息不为空
		if (ex instanceof TypeMismatchException && null != ex.getMessage()) {
			result.setResult(messageSource.getMessage("test.message", null,
					ex.getMessage(), Locale.CHINA));
		} else {
			result.setResult("500 服务器异常！");
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			Writer writer = response.getWriter();
			writer.write(new Gson().toJson(result));
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
