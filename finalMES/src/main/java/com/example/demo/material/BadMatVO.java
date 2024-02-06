package com.example.demo.material;

import java.util.Date;

import lombok.Data;

@Data
public class BadMatVO {
	private String badMatCode;	//불량내역코드
	private String matInsCode;	// 자재검사코드
	private String badProductCode;	// 자재불량코드
	private String matNote;		// 비고
	
	// JOIN bad_material
	private String badMatName;
	private String badMatContent;
	private Date badMatDate;
}
