package com.calculation.service;

import org.springframework.stereotype.Service;

import com.calculation.adapter.CurrencylayerAdapter;
import com.calculation.dto.Currencies;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurrencylayerService {

	private final CurrencylayerAdapter currencylayerAdapter;
	
	public Currencies calculation(Integer won) {
		return null;
	}
}
