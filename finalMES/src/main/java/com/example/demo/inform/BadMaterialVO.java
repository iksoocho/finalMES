package com.example.demo.inform;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BadMaterialVO {
	private String badMatCode;
	private String badMatName;
	private String badMatContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date badMatDate;
}
