package com.cml.mvc.exception;

import org.springframework.web.bind.annotation.ResponseBody;

public class ExceptionResolver {

	public @ResponseBody String handleBusinessException(Exception ex) {
		System.out.println("报错啦。。。");
		ex.printStackTrace();
		return "Handled BusinessException"+ex.getMessage();
	}

}
