package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatReturnVO {
	private String matReCode;
	private String matLotCode;
	private String businessCode;
	private int matReCount;
	private String matReContent;
	private String matReManager;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matReStartDate;
	private char matReState;
	
	
	// join
	private String businessName;
	private String matCode;
	private String matName;
	private int matCount;
}
