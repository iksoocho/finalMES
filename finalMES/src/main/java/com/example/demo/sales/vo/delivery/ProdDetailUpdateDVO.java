package com.example.demo.sales.vo.delivery;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdDetailUpdateDVO {
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date outDDate;
	private String outDCode;
	private String prodLotCode;
	private int outCount;
}
