package com.example.demo.inform;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdVO {
	private String prodCode;
	private String prodName;
	private String prodUnit;
	private String prodSpec;
	private int prodPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prodDate;
}
