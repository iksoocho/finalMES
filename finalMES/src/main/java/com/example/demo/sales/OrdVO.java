package com.example.demo.sales;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrdVO {
	private String ordCode;
	private String businessCode; // 거래처 정보를 나타내는 VO
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date ordDate;
	private String ordManager;
	private int ordState;
	private String ordNote;
	private List<OrdDVO> orderDetails;

	@Data
	public class OrdDVO {
		private String ordDCode;
		private String prodCode; // 제품 정보를 나타내는 VO
		private int ordCount;
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		private Date dlvyDate;
		private int ttlPrice;
	}
}
