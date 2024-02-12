package com.example.demo.sales.vo.product;

import lombok.Data;

@Data
public class ProductLotVO {
	private String prodLotCode;
	private int prodCount;
	private int prodInputCount;
	private int prodOutputCount;
	private String prodCode;
	private String prodName;
}
