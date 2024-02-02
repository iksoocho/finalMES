package com.example.demo.material;

import java.util.Date;

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
}
