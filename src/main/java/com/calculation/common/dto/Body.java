package com.calculation.common.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Body<T> {

	private List<T> datas;
}
