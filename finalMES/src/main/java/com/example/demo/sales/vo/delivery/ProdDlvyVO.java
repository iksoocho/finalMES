package com.example.demo.sales.vo.delivery;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdDlvyVO {
	private String outCode;
	private String ordCode;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date outDate;
	private String outManager;
	private String outState;
}
