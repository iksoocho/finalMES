package com.example.demo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sales.OrdVO;
import com.example.demo.sales.mapper.OrdMapper;
import com.example.demo.sales.service.OrdService;

@Service
public class OrdServiceImpl implements OrdService{

	@Autowired OrdMapper ordMapper;
	
	@Override
	public OrdVO getOrder(String ocd) {
		// TODO Auto-generated method stub
		return ordMapper.getOrder(ocd);
	}
	
}
