package com.example.demo.facility;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FacManageVO {
	private String facCode;
	private String procCode;
	private String businessCode;
	private String businessName;
	private String facName;
	private String notopCode;
	private String notopContent;
	private String facNotSituation;
	private String facNotCode;
	private int facHig;
	private int facLow;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date facDate;
	private String facInscycle;
	private String facImage;
	private String facPerson;
	private String procName;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date procDate;
}
