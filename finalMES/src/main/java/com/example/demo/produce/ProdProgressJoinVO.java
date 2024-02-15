package com.example.demo.produce;

import lombok.Data;

@Data
public class ProdProgressJoinVO {
	private String procName;
	private Integer progState;
	private Integer progInsCount;
	private Integer progPassCount;
}
