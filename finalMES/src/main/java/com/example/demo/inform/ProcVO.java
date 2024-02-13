package com.example.demo.inform;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProcVO {
	private String procCode;
	private String procName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date procDate;
	
}
