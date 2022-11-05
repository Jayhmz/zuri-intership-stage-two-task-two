package com.zuri.hng.stage.two.tasktwo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Operators {

	@NotNull
	private Integer x;
	@NotNull
	private Integer y;
	@NotNull
	private String operation_type;
}
