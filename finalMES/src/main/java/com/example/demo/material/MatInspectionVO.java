package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatInspectionVO {
	private String matInsCode; // 자재검사코드
	private String matOrCode;	// 자재발주코드 FK
	private int matInsCount;	// 검사량
	private int matInsGood;		// 합격량
	private int matInsBad;		// 불량
	private String matNote;		// 비고
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matInsDate;	// 자재검사일자
	
	private String matName;
	private String matUnit;
	private String matStandard;
	private String businessName;
	private String businessCode;
	private String badMatContent;
	private String matOrCount;
}
