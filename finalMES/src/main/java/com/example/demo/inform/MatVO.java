package com.example.demo.inform;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatVO {
	private String matCode;
	private String matName;
	private String matUnit;
	private String matStandard;
	private int matSafeStock;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prodDate;
	
}
