package com.example.demo.facility;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FacRepVO {
	private String facRepCode;
	private String facNotCode;
	private String facCode;
	private String facName;
	private String facRepRepairs;
	private String facRepPerson;
	private String facRepContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date facRepDate;

}
