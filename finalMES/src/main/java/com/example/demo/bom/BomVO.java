package com.example.demo.bom;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BomVO {
	private String bomCode;
	private int bomNum;
	private String prodCode;
	private String procCode;
	
	private String matCode;
	private String bomMatCount;
	
	
	// 제품
	private String prodName;
	private String prodUnit;
	private String prodSpec;
	private int prodPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prodDate;
	
	//자재
	private String matName;
	
	// 공정
	private String procName;
}
