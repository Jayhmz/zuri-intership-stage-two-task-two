package com.zuri.hng.stage.two.tasktwo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArithmeticControllerTest {

	@Test
	void test() {

		String str = "addition 35";

		String[] split = str.split(" ");
		String numbers = str.replaceAll("\\D+", " ");

		for (String s : split) {

			if (numbers != "") {
				// addition
				String trim = numbers.trim();
				String[] trimmedNumbers = trim.split(" ");
				
				if (!(trimmedNumbers.length == 2)) {
					System.out.println("please you are to enter two integers to run the code successfully");
				}else {
					
					if (s.contains("add")) {
						
						System.out.println(trimmedNumbers[0]);
						System.out.println(trimmedNumbers[1]);
					}
				}
			}
			System.out.println("is empty");

		}
	}

}
