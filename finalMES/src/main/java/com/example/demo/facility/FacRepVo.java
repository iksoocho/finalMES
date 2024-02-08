package com.example.demo.facility;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FacRepVo {
	private String facRepCode;
	private String facNotCode;
	private String facCode;
	private String facRepRepaies;
	private String facRepPerson;
	private String facRepContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date facRepDate;
}
