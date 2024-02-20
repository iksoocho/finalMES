package com.example.demo.sales.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.sales.mapper.OrdMapper;
import com.example.demo.sales.service.OrdService;
import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.employee.EmployeeVO;
import com.example.demo.sales.vo.order.OrderDVO;
import com.example.demo.sales.vo.order.OrderDetailDVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderStateDVO;
import com.example.demo.sales.vo.order.OrderVO;
import com.example.demo.sales.vo.product.ProductListVO;
import com.example.demo.sales.vo.product.ProductLotVO;

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
	@Transactional
	public void saveOrder(OrderVO orderVO) {
		// 주문서 저장
		ordMapper.saveOrder(orderVO);

		// 저장된 주문서의 주문번호 얻기
		String ordCode = orderVO.getOrdCode();

		// 상세주문 저장
		if (orderVO.getOrderDetails() != null) {
			for (OrderDetailVO orderDetail : orderVO.getOrderDetails()) {
				orderDetail.setOrdCode(ordCode);
				ordMapper.saveOrderDetail(orderDetail);
			}
		}
	}

	@Override
	public void saveOrderDetail(OrderDetailVO orderDetailVO) {
		ordMapper.saveOrderDetail(orderDetailVO);
	}

	@Override
	public List<OrderVO> getOrderList(OrderVO orderVO) {
		return ordMapper.getOrderList(orderVO);
	}

	@Override
	public List<OrderDetailDVO> getOrderDetailList(String ordCode) {
		return ordMapper.getOrderDetailList(ordCode);
	}

	@Override
	public List<BusinessListVO> getBusinessList() {
		// TODO Auto-generated method stub
		return ordMapper.getBusinessList();
	}

	@Override
	public OrderVO getOrderCode(String businessCode) {
		// TODO Auto-generated method stub
		return ordMapper.getOrderCode(businessCode);
	}

	@Override
	public List<ProductListVO> getProductList() {
		// TODO Auto-generated method stub
		return ordMapper.getProductList();
	}

	public void saveOrderWithDetails(OrderVO order) {
		// TODO Auto-generated method stub
		// 주문서 저장
		saveOrder(order);

		// 상세 주문서 저장
		List<OrderDetailVO> orderDetails = order.getOrderDetails();
		if (orderDetails != null) {
			for (OrderDetailVO orderDetail : orderDetails) {
				saveOrderDetail(orderDetail);
			}
		}
	}

	@Override
	public List<OrderVO> getOrderWithDetails(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductLotVO> getProductLotList(String prodCode) {
		// TODO Auto-generated method stub
		return ordMapper.getProductLotList(prodCode);
	}

	@Override
	public List<EmployeeVO> getEmployeeList() {
		// TODO Auto-generated method stub
		return ordMapper.getEmployeeList();
	}

	@Override
	public void updateOrderState(OrderStateDVO orderStateDVO) {
		// TODO Auto-generated method stub
		ordMapper.updateOrderState(orderStateDVO);
	}

	@Override
	public List<OrderVO> getOrderListByDateRange(OrderDVO orderDVO) {
		// TODO Auto-generated method stub
		return ordMapper.getOrderListByDateRange(orderDVO);
	}
}