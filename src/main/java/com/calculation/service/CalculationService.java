package com.calculation.service;

import org.springframework.stereotype.Service;

import com.calculation.adapter.CurrencylayerAdapter;
import com.calculation.common.AppResponse;
import com.calculation.common.enums.CommonCode;
import com.calculation.dto.Quotes;
import com.calculation.dto.ReceivedAmountRequest;
import com.calculation.util.AmountUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationService {

	private final CurrencylayerAdapter currencylayerAdapter;
	
	public AppResponse getRate() throws Exception {
		
		Quotes rates = currencylayerAdapter.getExchangeRate().getQuotes();
		
		return AppResponse.builder()
				.code(CommonCode.SUCCESS.getCode())
				.message(CommonCode.SUCCESS.getMessage())
				.body(rates)
				.build();
	}
	
	public AppResponse getAmount(ReceivedAmountRequest request) throws Exception {
		try {
			log.info("{}", request);
			Double amount = Double.parseDouble(request.getAmount());
			
			if(amount.compareTo(0.0) == -1 ||
					amount.compareTo(10000.0) == 1) throw new Exception();
				
			Double changed = amount * request.getRate();
			String cutting = String.format("%.2f", changed);
			String separated = AmountUtil.separate(cutting);
			String message = "수취금액은 " + separated + " " + request.getState() + " 입니다.";
			
			return AppResponse.builder()
					.code(CommonCode.SUCCESS.getCode())
					.message(CommonCode.SUCCESS.getMessage())
					.body(message)
					.build();
		} catch (Exception e) {
			return AppResponse.builder()
					.code(CommonCode.TRANSFER_FAIL.getCode())
					.message(CommonCode.TRANSFER_FAIL.getMessage())
					.body(CommonCode.TRANSFER_FAIL.getMessage())
					.build();
		}
	}
}
