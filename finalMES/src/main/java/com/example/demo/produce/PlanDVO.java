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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dPlanStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dPlanEndDate;
	private int dPlanPriority;
	private String dPlanNote;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dlvyDate;
	
	private int prodCount;
}