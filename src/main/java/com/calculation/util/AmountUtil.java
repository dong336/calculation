package com.calculation.util;

public class AmountUtil {

	public static String separate(String amount) throws Exception {
		String separated = amount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		return separated;		
	}
	
	public static void main(String[] args) throws Exception {
		String str = separate("5111115555.22");
		System.out.println(str);
	}
}
