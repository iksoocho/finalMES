package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BadMatVO {
	private String matBadCode;
	private String matInsCode;	// 자재검사코드
	private String badProductCode;	// 자재불량코드
	private String matNote;		// 비고
	
	// JOIN bad_material
	private String badMatCode;	//불량내역코드
	private String badMatName;
	private String badMatContent;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date badMatDate;
}
