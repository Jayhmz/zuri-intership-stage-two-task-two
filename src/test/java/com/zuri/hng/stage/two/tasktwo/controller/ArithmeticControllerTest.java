package com.zuri.hng.stage.two.tasktwo.controller;

import org.junit.jupiter.api.Test;

import com.zuri.hng.stage.two.tasktwo.model.ArithmeticEnums;
import com.zuri.hng.stage.two.tasktwo.model.Operators;

class ArithmeticControllerTest {

	@Test
	void test() {

		String str = " hey please perform addition 23 and 4";

		String[] split = str.split(" ");
		
		String numbers = str.replaceAll("\\D+", " ");
		
		Operators o = new Operators();
		o.setOperation_type("addition 4");
		
		String[] n = numbers.split(" ");
		
		
		
		
		
		for (String string : n) {
			
			System.out.println(o.getOperation_type().contains(string));
		}
		
		System.out.println(o.getOperation_type());
		
		
		
		
		
		
		
//		for (String s : split) {
//
//			if (numbers != "") {
//				if(o.getOperation_type().contains(numbers.split(" ").toString())) {
//					System.out.println(">>>>>>>>> yes it does");
//					System.out.println(numbers.split(" ").toString());
//					System.out.println(split);
//				}
//				// addition
//				String trim = numbers.trim();
//				String[] trimmedNumbers = trim.split(" ");
//				
//				if (!(trimmedNumbers.length == 2)) {
//					System.out.println("please you are to enter two integers to run the code successfully");
//				}else {
//					
//					if (s.contains("add")) {
//						
//						System.out.println(trimmedNumbers[0]);
//						System.out.println(trimmedNumbers[1]);
//					}
//				}
//			}

//		}
	}

}
