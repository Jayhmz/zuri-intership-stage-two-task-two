package com.zuri.hng.stage.two.tasktwo.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zuri.hng.stage.two.tasktwo.validators.ResponseValidator;

import lombok.Data;

@Data
public class ResponseModel {
	
	private String slackUsername;
	
	@JsonProperty(required = true)
	@ResponseValidator(enumClass = ArithmeticEnums.class, message = "")
	private String operation_type;
	
	@NotNull(message = "please provide an operation type")
	@JsonProperty(required = true)
	private int result;
}
