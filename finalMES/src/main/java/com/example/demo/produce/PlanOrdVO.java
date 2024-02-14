package com.example.demo.produce;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanOrdVO {
	private String ordCode;
	private String businessCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ordDate;
	private String ordManager;
	private String ordState;
	private String ordNote;
	
	
}
