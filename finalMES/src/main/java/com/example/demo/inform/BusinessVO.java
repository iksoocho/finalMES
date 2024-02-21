package com.example.demo.inform;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BusinessVO {
	private String businessCode;
	private String businessName;
	private String businessType;
	private String businessManager;
	private String businessManagerPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
}
