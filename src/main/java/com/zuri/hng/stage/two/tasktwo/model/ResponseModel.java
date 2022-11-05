package com.zuri.hng.stage.two.tasktwo.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseModel {
	
	private String slackUsername;
	@NotNull(message = "please provide an operation type")
	@JsonProperty(required = true)
	private String operation_type;
	
	@NotNull
	@JsonProperty(required = true)
	private int result;
}
