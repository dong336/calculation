package com.calculation.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonCode {

	SUCCESS("SUCCESS", "정상 처리되었습니다."),
	FAIL("FAIL", "시스템 오류입니다."),
	
	TRANSFER_FAIL("FAIL_TRANSFER_AMOUNT", "송금액이 바르지 않습니다"),
	;
	
	private final String code;
	private final String message;
}
