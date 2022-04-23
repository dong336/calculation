package com.calculation.adapter;

import org.springframework.stereotype.Component;

import com.calculation.dto.CurrencylayerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencylayerAdapter {

	private final OkHttpClient okHttpClient;
	private final ObjectMapper objectMapper;
	
	private static final String URI = "http://api.currencylayer.com/live?access_key=284a16223d4d20a3a90fc10c629c3d26";
	
	public CurrencylayerResponse getExchangeRate() throws Exception{
		RequestBody requestBody = RequestBody.create("", MediaType.parse("application/json; charset=utf-8"));
		
		Request request = new Request.Builder()
				.url(URI)
				.post(requestBody)
				.build();
		
		Response response = okHttpClient.newCall(request).execute();

		var responseBody = objectMapper.readValue(response.body().string(), CurrencylayerResponse.class);
		log.info("responseBody : {}", responseBody);
		log.info("환율 : {}", responseBody.getQuotes());
		return responseBody;
	}
}
