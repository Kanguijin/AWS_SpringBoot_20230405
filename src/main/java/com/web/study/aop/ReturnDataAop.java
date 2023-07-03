package com.web.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ReturnDataAop {
	
	@Pointcut("@annotation(com.web.study.aop.annotation.ReturnDataAspect)")
	private void pointCut() {}
	
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object logic = joinPoint.proceed();
		
		log.info("[ ReturnData ] >>> {}.{}: {}",
				joinPoint.getSignature().getDeclaringType().getSimpleName(),
				joinPoint.getSignature().getName(),
				logic);
		
		return logic;
	}
}
