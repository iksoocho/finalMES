package com.example.demo.produce;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;







@Data
public class PlanVO {
	private String planCode;
	private String ordCode;
	private String planTitle;
	private String planPerson;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planDate;
	private String planNote;
	private String planState;
	
	
}
