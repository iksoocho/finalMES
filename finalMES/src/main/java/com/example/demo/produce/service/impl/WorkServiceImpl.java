package com.example.demo.produce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.mapper.WorkMapper;
import com.example.demo.produce.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	WorkMapper workMapper;

	@Override
	public List<FacCateVO> getFacSelect(String procCode) {
		return workMapper.getFacSelect(procCode);
	}

}
