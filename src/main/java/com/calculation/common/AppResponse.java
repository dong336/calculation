package com.calculation.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppResponse {

	private String code;
	
	private String message;
	
	private Object body;
}
