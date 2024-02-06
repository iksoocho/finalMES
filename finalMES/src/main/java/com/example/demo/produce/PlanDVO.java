package com.example.demo.produce;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanDVO {
	private String dplanCode;
	private String planCode;
	private String prodCode;
	private int dplanCount;
	private int ordCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dPlanStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dPlanEndDate;
	private int dPlanPriority;
	private String dPlanNote;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dlvyDate;
	
	private int prodCount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dplanStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dplanEndDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;
}
