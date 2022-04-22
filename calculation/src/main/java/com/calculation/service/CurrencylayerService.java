package com.calculation.service;

import org.springframework.stereotype.Service;

import com.calculation.adapter.CurrencylayerAdapter;
import com.calculation.dto.Currencies;
import com.calculation.dto.Quotes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencylayerService {

	private final CurrencylayerAdapter currencylayerAdapter;
	
	public Currencies calculation(Double won) {
		
		try {
			var rates = currencylayerAdapter.getExchangeRate().getQuotes();
			
			log.info("환율 : {}", rates);
			
			var currencies = Currencies.builder()
					.krw(won * rates.getUSDKRW())
					.jpy(won * rates.getUSDJPY())
					.php(won * rates.getUSDPHP())
					.build();
			
			log.info("달러에서 계산된 외화 : {}", currencies);
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
