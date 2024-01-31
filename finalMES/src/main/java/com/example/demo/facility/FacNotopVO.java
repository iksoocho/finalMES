package com.example.demo.facility;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FacNotopVO {
	private String facNotCode;
	private String facCode;
	private String notopCode;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date facNotSdate;
	private Date facNotLdate;
	private String facNotPerson;
	private Number facNotSituation;
	private String facNotReason;
}
