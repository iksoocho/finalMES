package com.example.demo.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderVO;

@Service
public interface OrdService {

	OrderVO getOrder(String ordCode);

	OrderDetailVO getOrderDetail(String ordDCode);

	void insertOrder(OrderVO orderVO);

	void insertOrderDetail(OrderDetailVO orderDetailVO);

	List<OrderVO> getOrderList(OrderVO orderVO);

	List<OrderDetailVO> getOrderDetailList(OrderDetailVO orderDetailVO);
	
	List<BusinessListVO> getBusinessList();
}
