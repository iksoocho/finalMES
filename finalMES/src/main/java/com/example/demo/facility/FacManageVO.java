package com.example.demo.facility;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FacManageVO {
	private String facCode;
	private String businessCode;
	private String facName;
	private Number facHig;
	private Number facLow;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date facDate;
	private String facInscycle;
	private String facImage;
	private String facPerson;
}
