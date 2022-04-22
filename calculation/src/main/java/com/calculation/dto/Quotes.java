package com.calculation.dto;

import lombok.Builder;
import lombok.Data;

/*
 * $ => (환율)
 */
@Data
@Builder
public class Quotes {
	
	private Double USDKRW;
	private Double USDJPY;
	
}
