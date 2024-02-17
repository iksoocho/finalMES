package com.example.demo.sales.vo.delivery;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdDetailDlvyVO {
	private String outDCode;
	private String outCode;
	private String prodLotCode;
	private String ordDCode;
	private int outCount;
	private String outDState;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date outDDate;
}
