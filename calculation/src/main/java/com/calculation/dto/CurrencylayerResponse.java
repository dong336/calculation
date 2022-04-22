package com.calculation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencylayerResponse {

	private Boolean success;
	private String terms;
	private String privacy;
	private Long timestamp;
	private String source;

	private Quotes quotes;
}
