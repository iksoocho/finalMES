package com.example.demo.produce;

import java.util.Date;

import lombok.Data;



@Data
public class PlanInsVO {
	private String insCode;
	private String insTitle;
	private String insPerson;
	private String insState;
	private Date insDate;
	private String insNote;
	private String planCode;
}
