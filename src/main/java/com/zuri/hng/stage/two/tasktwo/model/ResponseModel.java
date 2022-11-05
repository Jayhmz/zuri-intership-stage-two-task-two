package com.zuri.hng.stage.two.tasktwo.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ResponseModel {
	
	private String slackUsername;
	@NotNull
	private String operation_type;
	
	@NotNull
	private int result;
}
