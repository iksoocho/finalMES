package com.example.demo.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderVO;

@Mapper
public interface OrdMapper {
	public OrderVO getOrder(String ordCode);

	public OrderDetailVO getOrderDetail(String ordDCode);

	public void insertOrder(OrderVO orderVO);

	public void insertOrderDetail(OrderDetailVO orderDetailVO);

	public List<OrderVO> getOrderList(OrderVO orderVO);

	public List<OrderDetailVO> getOrderDetailList(OrderDetailVO orderDetailVO);
	
	public List<BusinessListVO> getBusinessList(); // 거래처 목록 조회
}
