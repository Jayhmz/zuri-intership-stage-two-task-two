package com.zuri.hng.stage.two.tasktwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zuri.hng.stage.two.tasktwo.model.ArithmeticEnums;
import com.zuri.hng.stage.two.tasktwo.model.Operators;
import com.zuri.hng.stage.two.tasktwo.model.ResponseModel;
import com.zuri.hng.stage.two.tasktwo.service.ArithmeticService;

@RestController
public class ArithmeticController {

	@Autowired
	private ArithmeticService service;

	ResponseModel model = new ResponseModel();

	@GetMapping("/")
	public ResponseEntity<ResponseModel> hello() {
		String str = "hey, please addition these two numbers: 300000 and 3455";

		if (str != null) {
			String[] split = str.split(" ");
			String numbers = str.replaceAll("\\D+", " ");

			for (String s : split) {

				if (numbers != "") {
					String trim = numbers.trim();
					String[] trimmedNumbers = trim.split(" ");

					// ADDITION

					if (!(trimmedNumbers.length == 2)) {
						System.out.println("please you are to enter two integers to run the code successfully");
					} else {

						if (s.contains("add")) {
							model.setOperation_type(ArithmeticEnums.ADDITION.toString());
							model.setResult(service.addition(Integer.parseInt(trimmedNumbers[0]),
									Integer.parseInt(trimmedNumbers[1])));
							model.setSlackUsername("Jayhmz");
						}
					}
				}
				return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
			}
		}
		return new ResponseEntity<ResponseModel>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/")
	public ResponseEntity<?> addInputs(@RequestBody Operators operator) {

		String[] split = operator.getOperation_type().split(" ");
		String numbers = operator.getOperation_type().replaceAll("\\D+", " ");

		// check if operator is null
		if (operator != null) {

			// check for null objects
			if (operator.getX() == null && operator.getY() == null && operator.getOperation_type() == null) {
				return ResponseEntity.badRequest()
						.body("Cannot process empty inputs, please ensure all required fields are filled");
			}

			if (operator.getX() != null && operator.getY() != null) {

				// check if operation_type is the string to convert to code
				if (operator.getOperation_type() != null && !(operator.getOperation_type().contains(numbers))) {

					
					System.out.println(operator.getOperation_type());

				}
				
				System.out.println("it contains numbers");
			}

//			int addition = service.addition(operator.getX(), operator.getY());
//
//			ResponseModel model = new ResponseModel();
//			model.setOperation_type("Integer");
//			model.setResult(addition);
//			model.setSlackUsername("Jayhmz");
//
//			return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
			
		}
		return null;
	}
}
