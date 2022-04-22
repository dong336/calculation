package com.calculation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;

@Configuration
public class OkHttpConfig {

	@Bean
	public OkHttpClient okHttpClient() {
		OkHttpClient ohc = new OkHttpClient();
		
		return ohc;
	}
}
