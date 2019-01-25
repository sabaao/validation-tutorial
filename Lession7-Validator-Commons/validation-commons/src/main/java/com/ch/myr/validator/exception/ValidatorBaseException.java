package com.ch.myr.validator.exception;

import com.ch.myr.commons.constrants.ErrorCodeInterface;
import com.ch.myr.commons.exceptions.MyrBaseException;

public class ValidatorBaseException extends MyrBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555824764197178092L;

	public ValidatorBaseException(ErrorCodeInterface errorCode) {
		super(errorCode);
	}
	
	public ValidatorBaseException(ErrorCodeInterface errorCode,String message){
		super(errorCode.getErrorCode(),message);
		this.errorCode = errorCode.getErrorCode();
	}
	
	public ValidatorBaseException(String errorCode,String message){
		super(errorCode, message);
		this.errorCode = errorCode;
	}
}
