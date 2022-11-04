package com.zuri.hng.stage.two.tasktwo.model;

import lombok.Data;

@Data
public class ResponseModel {
	
	private String slackUsername, operation_type;
	private int result;
}
