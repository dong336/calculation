package com.calculation.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.calculation.common.dto.AppResponse;
import com.calculation.common.dto.Header;
import com.calculation.common.enums.CommonCode;

@RestControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public AppResponse handleAmount(RuntimeException e) {
		e.printStackTrace();
		
		return AppResponse.builder()
				.header(new Header(CommonCode.FAIL))
				.build();
	}
}
