package com.example.demo.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderVO;
import com.example.demo.sales.vo.product.ProductListVO;

@Mapper
public interface OrdMapper {
	public OrderVO getOrder(String ordCode);

	public OrderDetailVO getOrderDetail(String ordDCode);

	public void insertOrder(OrderVO orderVO);

	public void insertOrderDetail(OrderDetailVO orderDetailVO);

	public List<OrderVO> getOrderList(OrderVO orderVO);

	OrderVO getOrderCode(String businessCode); // 거래처에 대한 제일 최근 주문번호 조회

	public List<OrderDetailVO> getOrderDetailList(OrderDetailVO orderDetailVO);

	public List<BusinessListVO> getBusinessList(); // 거래처 목록 조회

	public List<ProductListVO> getProductList(); // 품목리스트 조회
}
