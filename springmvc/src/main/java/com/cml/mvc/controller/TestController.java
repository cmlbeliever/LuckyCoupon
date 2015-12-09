package com.cml.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {

	private static Log log = LogFactory.getLog(HelloWorld.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		log.debug("-====>come into controller:TestController"
				+ request.getParameter("time"));
		ModelAndView model = new ModelAndView();
		model.setViewName("time");
		model.addObject("time", request.getParameter("time"));
		return model;
	}

}
