package com.calculation.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.calculation.dto.CommonResponse;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler({CommonException.class})
	public CommonResponse commonException(CommonException e) {
		return null;
	}
}
