package com.zuri.hng.stage.two.tasktwo.service;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticService {

	public int addition(int x, int y) {
		
		return x + y;
	}
	public int subtraction(int x, int y) {
		
		return x - y;
	}
	public int division(int x, int y) {
		
		return x / y;
	}
	public int multiplication(int x, int y) {
		
		return x * y;
	}
	
	
	
	
}
