package com.calculation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Quotes {
	
	@JsonProperty("USDKRW")
	private Double USDKRW;	// 미국/한국
	
	@JsonProperty("USDJPY")
	private Double USDJPY;	// 미국/일본
	
	@JsonProperty("USDPHP")
	private Double USDPHP;	// 미국/필리핀
}
