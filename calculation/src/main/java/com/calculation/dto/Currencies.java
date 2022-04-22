package com.calculation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Currencies {
	private Double krw;
	private Double jpy;
	private Double php;
}
