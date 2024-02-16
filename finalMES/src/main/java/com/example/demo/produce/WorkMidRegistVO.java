package com.example.demo.produce;

import lombok.Data;

@Data
public class WorkMidRegistVO {
	private String progCode;
	private String dInsCode;
	private Integer progSeq;
	private String procCode;
	private int progInsCount;
	private Integer progBadCount;
	private Integer progPassCount;
	private int progState;
	private String startTime;
	private String endTime;
	private String prodCode;
}	
