package com.ch.myr.validator.exception.handler;

import java.util.ArrayList;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ch.myr.commons.log.factories.MyrLogFactory;
import com.ch.myr.commons.response.JsonResponse;
import com.ch.myr.commons.utils.JsonResponseUtil;
import com.ch.myr.validator.util.ValidatorUtils;

@ControllerAdvice
public class ConstrainViolationExceptionHandle {

	private final Logger logger = MyrLogFactory.getLogger(ValidatorBaseExceptionHandler.class);
	
	@Value("${spring.application.short-name}")
	private String shortName;
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public JsonResponse<String> handle(ConstraintViolationException exception) {
		ArrayList<ConstraintViolation<?>> list = new ArrayList<>(exception.getConstraintViolations());
	    ConstraintViolation c = list.stream().findFirst().get();
	    String message = c.getMessage();
	    String property =c.getPropertyPath().toString();
	    String name = ValidatorUtils.getClassName(c.getConstraintDescriptor().getAnnotation().annotationType().getName());
	    String errorCode = ValidatorUtils.getErrorCode(shortName, property, name);
	    
	    JsonResponse<String> response = JsonResponseUtil.getFail(errorCode, message);
		return response;
	}
}
