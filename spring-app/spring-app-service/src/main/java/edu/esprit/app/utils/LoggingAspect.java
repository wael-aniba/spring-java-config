package edu.esprit.app.utils;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	Logger logger;

	@Before("execution(* edu.esprit.app.service.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		logger = Logger
				.getLogger(joinPoint.getSignature().getClass().getName());
		logger.info("===> Start execution of ["
				+ joinPoint.getSignature().getName() + "] ...");
	}

	@After("execution(* edu.esprit.app.service.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {

		logger = Logger
				.getLogger(joinPoint.getSignature().getClass().getName());
		logger.info("===> End execution of ["
				+ joinPoint.getSignature().getName() + "] ...\n");
	}

}
