package com.example.demo.produce;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanOrdDVO {
	private String ordDCode;
	private String prodCode;
	private String ordCode;
	private int ordCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dlvyDate;
	private int ttlPrice;
	
}
