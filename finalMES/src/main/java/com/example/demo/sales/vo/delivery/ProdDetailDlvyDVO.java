package com.example.demo.sales.vo.delivery;

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
	
	// out_list 테이블
	private int outCount;
	
	// ord_d_list 테이블
	private String ordCode;
	
	// JOIN
	private String ordDCode;
}
