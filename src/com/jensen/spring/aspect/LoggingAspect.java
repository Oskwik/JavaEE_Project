package com.jensen.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

	// add logging support, Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// pointcut declarations
	@Pointcut("execution(* com.jensen.spring.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.jensen.spring.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.jensen.spring.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>> in @Before: calling method: " + theMethod );
		
		// display the arguments to the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tmp : args) {
			myLogger.info("====>> argument: " + tmp);
		}
	}
	
	// @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	
		// display method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>> in @AfterReturning: from method: " + theMethod );
		
		// display data returned
		myLogger.info("====>> result: " + theResult);
	
	}
	
	
}
