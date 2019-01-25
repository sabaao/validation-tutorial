package com.ch.myr.validator.exception.handler;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ch.myr.commons.log.factories.MyrLogFactory;
import com.ch.myr.commons.response.JsonResponse;
import com.ch.myr.commons.utils.JsonResponseUtil;
import com.ch.myr.validator.util.ValidatorUtils;

/**
 * Handle @Valid and @validated exception
 * @author Charles
 *
 */
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandle {

private final Logger logger = MyrLogFactory.getLogger(ValidatorBaseExceptionHandler.class);
	
	@Value("${spring.application.short-name}")
	private String shortName;

	@SuppressWarnings("unchecked")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public JsonResponse<String> handle(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		FieldError f = fieldErrors.stream().findFirst().get();
		String errorCode = ValidatorUtils.getErrorCode(shortName, f.getField(), f.getCode());
		JsonResponse<String> response = JsonResponseUtil.getFail(errorCode, f.getDefaultMessage());
		return response;
	}
}
