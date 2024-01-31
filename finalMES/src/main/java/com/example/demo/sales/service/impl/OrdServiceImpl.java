package com.example.demo.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sales.mapper.OrdMapper;
import com.example.demo.sales.service.OrdService;
import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderVO;

@Service
public class OrdServiceImpl implements OrdService {

	@Autowired
	private OrdMapper ordMapper;

	@Override
	public OrderVO getOrder(String ordCode) {
		return ordMapper.getOrder(ordCode);
	}

	@Override
	public OrderDetailVO getOrderDetail(String ordDCode) {
		return ordMapper.getOrderDetail(ordDCode);
	}

	@Override
	public void insertOrder(OrderVO orderVO) {
		ordMapper.insertOrder(orderVO);
	}

	@Override
	public void insertOrderDetail(OrderDetailVO orderDetailVO) {
		ordMapper.insertOrderDetail(orderDetailVO);
	}

	@Override
	public List<OrderVO> getOrderList(OrderVO orderVO) {
		return ordMapper.getOrderList(orderVO);
	}

	@Override
	public List<OrderDetailVO> getOrderDetailList(OrderDetailVO orderDetailVO) {
		return ordMapper.getOrderDetailList(orderDetailVO);
	}

	@Override
	public List<BusinessListVO> getBusinessList() {
		// TODO Auto-generated method stub
		return ordMapper.getBusinessList();
	}
	

}
