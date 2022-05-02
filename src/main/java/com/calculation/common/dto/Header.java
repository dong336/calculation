package com.calculation.common.dto;

import com.calculation.common.enums.CommonCode;

import lombok.Data;

@Data
public class Header {

	private String code;
	private String message;
	
	public Header(CommonCode commonCode) {
		this.code = commonCode.getCode();
		this.message = commonCode.getMessage();
	}
}
