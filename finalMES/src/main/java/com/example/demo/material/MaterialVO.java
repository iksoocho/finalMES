package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MaterialVO {
	private String matLotCode;
	private String matCode;
	private String matInspectionCode;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date matInputDate;
	private int matInputCount;
	private int matOutputCount;
	private int matCount;
	private String matManager;
	
	private String matOrCode;
	private String matOrName;
	private String busineesName;
	private String matOrCount;
	private String matOrManager;
	
	
	
}
