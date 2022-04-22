package com.calculation.adapter;

import org.springframework.stereotype.Component;

import com.calculation.dto.CurrencylayerResponse;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;

@Component
@RequiredArgsConstructor
public class CurrencylayerAdapter {

	private final OkHttpClient okHttpClient;
	
	private static final String URI = "http://api.currencylayer.com/live?access_key=284a16223d4d20a3a90fc10c629c3d26";
	
	public CurrencylayerResponse getExchangeRate() throws Exception{
		return null;
	}
}
