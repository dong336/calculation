package com.calculation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calculation.service.CurrencylayerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CurrencylayerController {

	private final CurrencylayerService currencylayerService;
	
	@RequestMapping("")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("test")
	public String test() {
		
		currencylayerService.calculation(Double.parseDouble("100"));
		return "home";
	}
}
