package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOrderVO {
	
	//발주
	private String matOrCode;
	private String matCode;
	private String businessCode;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date matOrDate;
	private String matOrManager;
	private int matOrCount;
	private String matOrName;
	private String matOrState;
	
	//발주상세
	private String matOrInfoCode;
	private int matOrICount;
	private Date matOrDueDate;
	
	
}
