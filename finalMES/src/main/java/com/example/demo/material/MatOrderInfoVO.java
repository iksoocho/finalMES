package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOrderInfoVO {
	private String matOrInfoCode;
	private String matOrCode;
	private String matCode;
	private int matOriCount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date matOrDueDate;
	
	//
	private String matOrName;
	private String matOrManager;
	private int matOrCount;
	private String businessName;
	
	
}
