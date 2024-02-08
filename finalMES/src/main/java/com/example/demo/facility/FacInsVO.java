package com.example.demo.facility;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FacInsVO {
	private String facInsCode;
	private String facNotCode;
	private String facCode;
	private String facName;
	private String facInsCheck;
	private String facInsPerson;
	private String facInsJud;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date facInsDate;
	private String facInsSel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date facInsNexd;
}
