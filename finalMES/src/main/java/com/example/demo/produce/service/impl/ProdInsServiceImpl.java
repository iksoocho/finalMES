package com.example.demo.produce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.produce.ProdInsDetailVO;
import com.example.demo.produce.ProdInsVO;
import com.example.demo.produce.mapper.InsMapper;
import com.example.demo.produce.service.ProdInsService;

@Service
public class ProdInsServiceImpl implements ProdInsService{

	@Autowired
	InsMapper insMapper;
	
	@Override
	public List<ProdInsVO> getInsList() {
		return insMapper.getInsList();
	}

	@Override
	public List<ProdInsDetailVO> getInsDetailList(String insCode) {
		return insMapper.getInsDetailList(insCode);
	}

	@Override
	public ProdInsDetailVO getCheckDetailList(String dInsCode) {
		return insMapper.getCheckDetailList(dInsCode);
	}

}
