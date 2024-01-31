package com.example.demo.produce;

import java.util.Date;

import lombok.Data;

@Data
public class ProdInsVO {
	private String insCode;
	private String insTitle;
	private String insPerson;
	private Date insDate;
	private String insNote;
}
