package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OriginMaterialVO {
	
	// material 테이블
	private String matCode;
	private String matName;
	private String matUnit;
	private String matStandard;
	private int matSafeStock;
	private Date matStartDate;
	
	private String businessCode;
	private String businessName;
	private int deal;
	
	// LOT 테이블 꺼 
	private String matCount;
	private String matLotCode;
	private String matLotCount;
	private String matInsGood;
	
	private String matCount2;
	private String matInputCount;
	
	
	private int matOrCount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date matOrDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date matOrDueDate;
	private String matOrManager;
	private String matOrState;
	
	
//	원래 테이블
//	private String matCode;
//	private String matName;
//	private String matUnit;
//	private String matStandard;
//	private int matSafeStock;
//	private String matLotCode;
//	private String matCode;
//	private int matCount;
	
}
