package com.cml.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		System.out.println("====preHandle:"
				+ request.getRequestURI().toString() + ",,," + handler);

//		String token = request.getParameter("token");
		

//		if (null == token) {
//			response.getWriter().write("XXXXXXXXXXXXXXXXXXXXXXX");
////			return false;
//		}
		// if (null == token) {
		// System.out.println("token is null");
		// response.setCharacterEncoding("UTF-8");
		// Writer wirter=response.getWriter();
		// wirter.write("哈哈哈哈");
		// return true;
		// }

		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (null != ex) {
//			ex.printStackTrace();
		}
		System.out.println("====afterCompletion:" + handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (null != modelAndView) {
			System.out.println("ddddddddddddddddddddddddddd");
		}

		System.out.println("====postHandle:" + handler);
	}

}
