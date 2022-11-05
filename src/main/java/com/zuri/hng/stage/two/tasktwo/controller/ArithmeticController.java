package com.zuri.hng.stage.two.tasktwo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zuri.hng.stage.two.tasktwo.exception.IncompleteArguementException;
import com.zuri.hng.stage.two.tasktwo.model.ArithmeticEnums;
import com.zuri.hng.stage.two.tasktwo.model.Operators;
import com.zuri.hng.stage.two.tasktwo.model.ResponseModel;
import com.zuri.hng.stage.two.tasktwo.service.ArithmeticService;

@RestController
@CrossOrigin("*")
@Validated
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

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE, }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addInputs(@Valid @RequestBody Operators operator, BindingResult result)
			throws IncompleteArguementException {

		// check for all null values
		if (result.hasErrors()) {
			throw new NullPointerException("request body cannot be empty");
		}

		String[] stringSplit = operator.getOperation_type().split(" ");
		String numbers = operator.getOperation_type().replaceAll("\\D+", " ");
		String numString = numbers.trim();
		String[] numbersArray = numString.split(" ");

		// check if operator is null
		if (operator != null) {

			// check for null objects
			if (operator.getX() == null && operator.getY() == null && operator.getOperation_type() == null) {
				return ResponseEntity.badRequest()
						.body("Cannot process empty inputs, please ensure all required fields are filled");
			}

			// perform the calculation
			// check if x and y are null values
			if (operator.getX() != null && operator.getY() != null) {

				// check if operation type does not contain any number
				for (String n : numbersArray) {

					// check if operation_type is an enum type
					if (operator.getOperation_type() != null && !(operator.getOperation_type().contains(n))) {

						// addition enum
						if (operator.getOperation_type().equals(ArithmeticEnums.ADDITION.name().toLowerCase())) {
							ResponseModel model = new ResponseModel();
							model.setOperation_type(ArithmeticEnums.ADDITION.name());
							model.setResult(service.addition(operator.getX(), operator.getY()));
							model.setSlackUsername("Jayhmz");

							return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
						}
						// subtraction enum
						if (operator.getOperation_type().equals(ArithmeticEnums.SUBTRACTION.name().toLowerCase())) {
							ResponseModel model = new ResponseModel();
							model.setOperation_type(ArithmeticEnums.SUBTRACTION.name());
							model.setResult(service.subtraction(operator.getX(), operator.getY()));
							model.setSlackUsername("Jayhmz");

							return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
						}
						// division enum
						if (operator.getOperation_type().equals(ArithmeticEnums.DIVISION.name().toLowerCase())) {
							ResponseModel model = new ResponseModel();
							model.setOperation_type(ArithmeticEnums.DIVISION.name());
							model.setResult(service.division(operator.getX(), operator.getY()));
							model.setSlackUsername("Jayhmz");

							return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
						}
						// multiplication enum
						if (operator.getOperation_type().equals(ArithmeticEnums.MULTIPLICATION.name().toLowerCase())) {
							ResponseModel model = new ResponseModel();
							model.setOperation_type(ArithmeticEnums.MULTIPLICATION.name());
							model.setResult(service.multiplication(operator.getX(), operator.getY()));
							model.setSlackUsername("Jayhmz");

							return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
						}
						return ResponseEntity.badRequest()
								.body("OOPS! there is a wrong format of operation in the "
										+ "operator_type, please ensure it contains"
										+ " only commands like ('addition', 'subtraction', etc)");

					}

					for (String word : stringSplit) {
						if (word.contains("add")) {
							operator.setOperation_type(ArithmeticEnums.ADDITION.name().toLowerCase());
						}
						if (word.contains("subtract")) {
							operator.setOperation_type(ArithmeticEnums.SUBTRACTION.name().toLowerCase());
						}
						if (word.contains("multipl")) {
							operator.setOperation_type(ArithmeticEnums.MULTIPLICATION.name().toLowerCase());
						}
						if (word.contains("divid")) {
							operator.setOperation_type(ArithmeticEnums.DIVISION.name().toLowerCase());
						}
					}
					// addition enum
					if (operator.getOperation_type().equals(ArithmeticEnums.ADDITION.name().toLowerCase())) {
						ResponseModel model = new ResponseModel();
						model.setOperation_type(ArithmeticEnums.ADDITION.name());
						model.setResult(service.addition(operator.getX(), operator.getY()));
						model.setSlackUsername("Jayhmz");

						return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
					}
					// subtraction enum
					if (operator.getOperation_type().equals(ArithmeticEnums.SUBTRACTION.name().toLowerCase())) {
						ResponseModel model = new ResponseModel();
						model.setOperation_type(ArithmeticEnums.SUBTRACTION.name());
						model.setResult(service.subtraction(operator.getX(), operator.getY()));
						model.setSlackUsername("Jayhmz");

						return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
					}
					// division enum
					if (operator.getOperation_type().equals(ArithmeticEnums.DIVISION.name().toLowerCase())) {
						ResponseModel model = new ResponseModel();
						model.setOperation_type(ArithmeticEnums.DIVISION.name());
						model.setResult(service.division(operator.getX(), operator.getY()));
						model.setSlackUsername("Jayhmz");

						return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
					}
					// multiplication enum
					if (operator.getOperation_type().equals(ArithmeticEnums.MULTIPLICATION.name().toLowerCase())) {
						ResponseModel model = new ResponseModel();
						model.setOperation_type(ArithmeticEnums.MULTIPLICATION.name());
						model.setResult(service.multiplication(operator.getX(), operator.getY()));
						model.setSlackUsername("Jayhmz");

						return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
					}

				}

			}

		}
		return ResponseEntity.badRequest().body("INVALID INPUTS");
	}
}
