package com.example.demo.produce;

import java.util.Date;

import lombok.Data;

@Data
public class WorkResultVO {
	private String resultCode;
	private String procCode;
	private String dInsCode;
	private String resultWorker;
	private Date resultSTime;
	private Date resultETime;
	private int resultWorkCount;
	private int resultBadCount;
	private int resultPassCount;
	private String resultNote;
	private int resultState;
}
