package com.example.demo.produce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.produce.ProdInsVO;
import com.example.demo.produce.mapper.InsMapper;
import com.example.demo.produce.service.ProdInsService;

public class ProdInsServiceImpl implements ProdInsService{

	@Autowired
	InsMapper insMapper;
	
	@Override
	public List<ProdInsVO> getInsList(ProdInsVO prodInsVO) {
		return insMapper.getInsList(prodInsVO);
	}

}
