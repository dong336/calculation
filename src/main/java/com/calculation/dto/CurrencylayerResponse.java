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
public class CurrencylayerResponse {

	private Boolean success;
	private String terms;
	private String privacy;
	private Long timestamp;
	private String source;

	@JsonProperty("quotes")
	private Quotes quotes;
}
