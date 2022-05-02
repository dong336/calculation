package com.calculation.common.dto;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppResponse {
	
	@NotNull
	private Header header;
	
	@Nullable
	private Object body;
}
