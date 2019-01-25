package com.ch.myr.validator.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ch.myr.commons.log.factories.MyrLogFactory;
import com.ch.myr.commons.response.JsonResponse;
import com.ch.myr.commons.utils.JsonResponseUtil;
import com.ch.myr.validator.exception.ValidatorBaseException;


@ControllerAdvice
public class ValidatorBaseExceptionHandler {
	private final Logger logger = MyrLogFactory.getLogger(ValidatorBaseExceptionHandler.class);
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(value = ValidatorBaseException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public JsonResponse<String> handlerError(HttpServletRequest req, ValidatorBaseException e) {
		logger.error(e.getErrorCode(),e);
		JsonResponse<String> response = JsonResponseUtil.getFail(e.getErrorCode(), e.getMessage());
        return response;
    }
}
