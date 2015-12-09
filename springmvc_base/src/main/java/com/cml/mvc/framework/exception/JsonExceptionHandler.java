package com.cml.mvc.framework.exception;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/**
 * 异常捕获Handler，返回json格式错误信息
 * 
 * @author 陈孟琳
 *
 *         2015年4月28日
 */
public class JsonExceptionHandler implements HandlerExceptionResolver {

	private static Log log = LogFactory.getLog(JsonExceptionHandler.class);

	public static final String DEFAULT_CONTENT_TYPE = "application/json";
	public static final String DEFAULT_ENCODING = "UTF-8";

	/** 返回的错误信息 */
	private Object errorResult;
	private String contentType;
	private String charactorEncoding;

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		log.debug("JsonExceptionHandler==>resolveException:" + ex.getMessage());

		if (null == errorResult) {
			throw new IllegalArgumentException(
					"JsonExceptionHandler errorResult can not be null!");
		}

		response.setContentType(contentType);
		response.setCharacterEncoding(charactorEncoding);

		if (null == contentType) {
			response.setContentType(DEFAULT_CONTENT_TYPE);
		}
		if (null == charactorEncoding) {
			response.setCharacterEncoding(DEFAULT_ENCODING);
		}

		try {
			Writer writer = response.getWriter();
			writer.write(new Gson().toJson(errorResult));
			writer.close();
		} catch (IOException e) {
			log.error(this, e);
		}

		return null;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCharactorEncoding() {
		return charactorEncoding;
	}

	public void setCharactorEncoding(String charactorEncoding) {
		this.charactorEncoding = charactorEncoding;
	}

	public Object getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(Object errorResult) {
		this.errorResult = errorResult;
	}

}
