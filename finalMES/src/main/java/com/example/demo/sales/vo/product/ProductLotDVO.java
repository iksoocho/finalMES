package com.example.demo.sales.vo.product;

import lombok.Data;

// 출고시 재고량 계산 DVO
@Data
public class ProductLotDVO {
	private String prodLotCode;
	private int prodCount;
	private int prodOutputCount;
	private String prodCode;
	private String prodName;
}
