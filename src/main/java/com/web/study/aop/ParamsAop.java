package com.web.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ParamsAop {
	
	@Pointcut("@annotation(com.web.study.aop.annotation.ParamsAspect)")
	private void pointCut() {}
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		StringBuilder builder = new StringBuilder();
		
		 CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		  String[] parameterNames = codeSignature.getParameterNames();
		  Object[] args = joinPoint.getArgs();
		
		for(int i = 0; i < parameterNames.length; i++) {
			if(i != 0) {
				builder.append(", ");
			}
			builder.append(parameterNames[i] + ": " + args[i]);
		}
		log.info("[ params ] >>> {}", builder.toString());
		
		return joinPoint.proceed();
		
	}
}
