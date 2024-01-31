package com.example.demo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sales.mapper.OrdMapper;
import com.example.demo.sales.service.OrdService;
import com.example.demo.sales.vo.order.OrderVO;

@Service
public class OrdServiceImpl implements OrdService{

	@Autowired OrdMapper ordMapper;
	
	@Override
	public OrderVO getOrder(String ocd) {
		// TODO Auto-generated method stub
		return ordMapper.getOrder(ocd);
	}
	
}
