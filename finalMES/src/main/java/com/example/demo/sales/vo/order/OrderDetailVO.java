package com.example.demo.sales.vo.order;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderDetailVO {
	private String ordDCode;
	private String prodCode; // 제품 정보를 나타내는 VO
	private String ordCode;
	private int ordCount;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dlvyDate;
	private int ttlPrice;
}
