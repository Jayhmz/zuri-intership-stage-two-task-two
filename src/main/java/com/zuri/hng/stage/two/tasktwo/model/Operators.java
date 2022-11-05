package com.zuri.hng.stage.two.tasktwo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Operators {

	@NotNull
	@Pattern(regexp = "[0-9]")
	private Integer x;
	@NotNull
	@Pattern(regexp = "[0-9]")
	private Integer y;
	@NotNull
	private String operation_type;
}
