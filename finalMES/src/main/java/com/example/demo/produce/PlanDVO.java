package com.example.demo.produce;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanDVO {
	private String dPlanCode;
	private String planCode;
	private String prodCode;
	private int dPlanCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dPlanStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dPlanEndDate;
	private int dPlanPriority;
	private String dPlanNote;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dlvyDate;
}
