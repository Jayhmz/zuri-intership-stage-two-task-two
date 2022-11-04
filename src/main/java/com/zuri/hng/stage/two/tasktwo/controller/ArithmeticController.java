package com.zuri.hng.stage.two.tasktwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zuri.hng.stage.two.tasktwo.model.Operators;
import com.zuri.hng.stage.two.tasktwo.model.ResponseModel;
import com.zuri.hng.stage.two.tasktwo.service.ArithmeticService;

@RestController
public class ArithmeticController {

	@Autowired
	private ArithmeticService service;
	
	@GetMapping("/")
	public String hello() {
		return "started";
	}
	
	@PostMapping("/add")
	public ResponseEntity<ResponseModel> addInputs(@RequestBody Operators operator){
		
		int addition = service.addition(operator.getX(), operator.getY());
		
		ResponseModel model = new ResponseModel();
		model.setOperation_type("Integer");
		model.setResult(addition);
		model.setSlackUsername("Jayhmz");
		
		return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
	}
}
