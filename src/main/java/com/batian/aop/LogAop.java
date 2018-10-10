package com.batian.aop;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class LogAop {
	private static final Logger logger = Logger.getLogger(LogAop.class);

	@Pointcut("execution(public * com.batian.controller..*.*(..))")
	public void printLog(){
		
	}
	
	@Before("printLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable{
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		System.out.println(request.getRequestURL().toString());
		logger.info("您的请求开始执行!");
	}
	
	@AfterReturning(pointcut="printLog()",returning="obj")
	public void doAfterReturning(Object obj){
		logger.info("您的请求已经结束！");
	}

}
