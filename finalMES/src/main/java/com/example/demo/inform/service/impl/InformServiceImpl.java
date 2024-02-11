package com.example.demo.inform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.inform.EmpVO;
import com.example.demo.inform.mapper.InformMapper;
import com.example.demo.inform.service.InformService;

@Service
public class InformServiceImpl implements InformService {
	
	@Autowired
	InformMapper informMapper;
	
	@Override
	public List<EmpVO> getEmpList() {
		return informMapper.selectEmpList();
	}

	@Override
	public EmpVO insertEmpInfo(EmpVO empVO) {
		informMapper.insertEmpInfo(empVO);
		return empVO;
	}

}
