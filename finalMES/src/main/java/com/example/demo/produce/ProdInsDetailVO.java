package com.example.demo.produce;

import java.util.Date;

import lombok.Data;

@Data
public class ProdInsDetailVO {
	private String dInsCode;
	private String insCode;
	private String prodCode;
	private int dInsCount;
	private Date dInsSdate;
	private Date dInsEdate;
	private String dInsNote;
	private String dInsState;
	
}
