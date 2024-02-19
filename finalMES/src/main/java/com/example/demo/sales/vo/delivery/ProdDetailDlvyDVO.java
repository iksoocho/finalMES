package com.example.demo.sales.vo.delivery;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdDetailDlvyDVO {
	// product 테이블
	private String prodCode;
	private String prodName;
	private String prodUnit;
	private int prodPrice;
	
	// prod_list 테이블
	private String prodLotCode;
	private String prodCount;
	
	// out_d_list 테이블
	private int outCount;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date outDDate;
	private String outDState;
	private String outCode;
	private String outDCode;
	
	// JOIN
	private String ordDCode;
	
	// 값 계산
	private int outTtlPrice;
}
