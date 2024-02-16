package com.example.demo.sales.vo.delivery;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdDlvyDVO {
	String outCode;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date outDate;
	private String outManager;
	private String outState;
	private String ordCode;
	private String businessCode;
	private String businessName;
}
