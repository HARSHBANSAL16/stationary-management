package com.stationary.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.stationary.constant.AppConstants;

public class CorsInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(CorsInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("URL: " + request.getRequestURL().toString());
		logger.info("Method: " + request.getMethod());

		response.setHeader("Access-Control-Allow-Origin", AppConstants.ACCESS_CONTROL_URL); 
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
	//	response.setHeader("Access-Control-Allow-Headers", "contentType,X-Custom-Token,x-requested-with, Content-Type, accept,Set-Cookie");
	   // response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, Origin, authorization, accept, client-security-token");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		return super.preHandle(request, response, handler);
	}

}
