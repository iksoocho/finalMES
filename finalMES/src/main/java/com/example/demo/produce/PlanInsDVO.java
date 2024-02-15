package com.example.demo.produce;

import java.util.Date;

import lombok.Data;

@Data
public class PlanInsDVO {
	private String dinsCode;
	private String insCode;
	private String prodCode;
	private int dinsCount;
	private Date dinsSdate;
	private Date dinsEdate;
	private String dinsNote;
	private String dplanCount;
	
	
}
