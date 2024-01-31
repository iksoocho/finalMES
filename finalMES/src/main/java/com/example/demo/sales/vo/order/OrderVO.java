package com.example.demo.sales.vo.order;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderVO {
	private String ordCode;
	private String businessCode; // 거래처 정보를 나타내는 VO
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date ordDate;
	private String ordManager;
	private int ordState;
	private String ordNote;
}
