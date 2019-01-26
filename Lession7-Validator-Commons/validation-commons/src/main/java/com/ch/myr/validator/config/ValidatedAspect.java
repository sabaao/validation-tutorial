package com.ch.myr.validator.config;



import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ch.myr.validator.annotations.MyrValidated;
import com.ch.myr.validator.exception.ValidatorBaseException;
import com.ch.myr.validator.util.ValidatorUtils;


/**
 * Myrewards Validated aop aspect
 * @author Charles
 *
 */
@Aspect
@Component
public class ValidatedAspect {
	
	@Value("${spring.application.short-name}")
	private String shortName;
	
	private final String ERROR = "ERROR";
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Pointcut("@annotation(com.ch.myr.validator.annotations.MyrValidated) && execution(* com.ch.myr..*.*(..))")
	private void cutMyrValidated() {
	}
	
	@Around("cutMyrValidated()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable,ValidatorBaseException {
		//get annoation
		MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = pjp.getTarget()
           .getClass()
           .getMethod(signature.getMethod().getName(),     
                      signature.getMethod().getParameterTypes());
	    MyrValidated annotation = method.getAnnotation(MyrValidated.class);
	    
	    //valid all args
	    for(Object arg:pjp.getArgs()) {
	    	Set<ConstraintViolation<Object>> violations;
	    	if(annotation==null) {
	    		violations = validator.validate(arg);
	    	}else {
	    		violations = validator.validate(arg, annotation.value());
	    	}
	    	if(violations.size()>0) {
	    		//if violations more than zero, throw exception
	    		throw convert(violations.stream().findFirst().get());
	    	}
	    }
		
		return pjp.proceed();
	}
	
	private ValidatorBaseException convert(ConstraintViolation c) {
		//使用者定義的訊息
		String message = c.getMessage();
		
		//發生錯誤的屬性名稱
	    String property =c.getPropertyPath().toString().toUpperCase();
	    
	    //取得annotation
	    String annotationName = ValidatorUtils.getClassName(c.getConstraintDescriptor().getAnnotation().annotationType().getName()).toUpperCase(); 
	    
	    String errorCode = shortName + "_" + property + "_" + annotationName + "_" + ERROR;
	    ValidatorBaseException ex = new ValidatorBaseException(errorCode, message);
		
		return ex;
	}
	
	/**
	 * 取得annotation name
	 * @param c
	 * @return
	 */
	private String getAnnotationName(ConstraintViolation c) {
		String fullName = c.getConstraintDescriptor().getAnnotation().annotationType().getName();
		String[] names = fullName.split(".");
		return names[names.length-1];
	}

}
