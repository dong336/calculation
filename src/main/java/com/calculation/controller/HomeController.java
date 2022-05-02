package com.calculation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calculation.common.dto.AppResponse;
import com.calculation.common.dto.Header;
import com.calculation.common.enums.CommonCode;
import com.calculation.service.CalculationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

	private final CalculationService calculationService;	
	
	private static final String DATA = "data";
	
	@RequestMapping("")
	public String home(Model model) throws Exception {
		
		AppResponse data = calculationService.getRate();
		model.addAttribute(DATA, data);
		log.info(model.toString());
//		throw new Exception();
		return "home";
	}
	
	@ExceptionHandler
	public Object handleHome(Model model, Exception e) {
		e.printStackTrace();
		log.error("{}", model.getAttribute(DATA));
		
		var data = AppResponse.builder()
				.header(new Header(CommonCode.FAIL))
				.build();
		model.addAttribute(DATA, data);
		
		return "home";
	}	
}
