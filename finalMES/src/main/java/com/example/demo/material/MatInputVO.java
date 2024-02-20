package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatInputVO {
	private String matLotCode;
	private String matCode;
	private String matInsCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matInputDate;
	private int matInputCount; // 이건 넘어 오기전 총 입고될 량
	private String matManager;
	private String matCount; // 총재고량
	// join
	
	private String matOrManager;
	private String matOutCount;
	private String matUnit;
	private String matStandard;
	private String businessName;
	private int matOrCount;
	private int matInsCount;
	private int matInsGoodCount;
	private String matName;
	private int matInsGood; //검수를 끝내고 들어온 합격량을 입고시킨다는 느낌
	
	
}
