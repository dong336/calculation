package com.calculation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculation.common.dto.AppResponse;
import com.calculation.dto.ReceivedAmountRequest;
import com.calculation.service.CalculationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RequestMapping("/amount")
@RestController
@RequiredArgsConstructor
public class AmountController {

	private final CalculationService calculationService;
	
	@RequestMapping("/receive")
	public AppResponse giveAmount(@RequestBody ReceivedAmountRequest request) throws Exception {
		
		return calculationService.getAmount(request);
//		throw new Exception();
	}
	
//	@ExceptionHandler
//	public AppResponse handleAmount(Exception e) {
//		e.printStackTrace();
//		
//		return AppResponse.builder()
//				.header(new Header(CommonCode.FAIL))
//				.build();
//	}
}
