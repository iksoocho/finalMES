package com.example.demo.sales.vo.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderDVO {
	private String ordCode;
	private String businessName; // 거래처 정보를 나타내는 VO
	private String businessCode;
	private String businessManager;
	private String businessManagerPhone;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date ordDate;
	private String ordManager;
	private String ordState;
	private String ordStateNm;
	private String ordNote;
	private int totalTtlPrice;
	private List<OrderDetailVO> orderDetails;
	public void addOrderDetail(OrderDetailVO orderDetail) {
		if (orderDetails == null) {
			orderDetails = new ArrayList<>();
		}
		orderDetails.add(orderDetail);
	}
	
}
