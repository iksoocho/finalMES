package com.example.demo.material;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOutputVO {
	private String matOutCode; //출고코드
	private String matLotCode;	// LOT코드
	private String resultCode;	// 공정코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matOutDate;	//출고 날짜
	private int matOutCount;	// 출고 수량
	
	private String businessCode;
	private String matName;		// 자재명
	private String matManager;	// 담당자
	private int matCount;		// 재고량
	private String businessName;	// 거래처명
}
