package com.example.demo.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderVO;
import com.example.demo.sales.vo.product.ProductListVO;

@Service
public interface OrdService {

	OrderVO getOrder(String ordCode);

	OrderDetailVO getOrderDetail(String ordDCode);

	void insertOrder(OrderVO orderVO);

	void insertOrderDetail(OrderDetailVO orderDetailVO);

	List<OrderVO> getOrderList(OrderVO orderVO);

	List<OrderDetailVO> getOrderDetailList(OrderDetailVO orderDetailVO);
	
	List<BusinessListVO> getBusinessList(); // 거래처 목록
	
	OrderVO getOrderCode(String businessCode); // 거래처에 대한 가장 최근 주문서 불러오기
	
	List<ProductListVO> getProductList();
}
