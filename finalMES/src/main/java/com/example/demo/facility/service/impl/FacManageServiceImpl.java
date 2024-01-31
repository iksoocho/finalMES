package com.example.demo.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.facility.FacManageVO;
import com.example.demo.facility.mapper.FacManageMapper;
import com.example.demo.facility.service.FacManageService;

@Service
public class FacManageServiceImpl implements FacManageService {

	@Autowired
	FacManageMapper facManageMapper;
	
	@Override
	public FacManageVO getFacility(String facCode) {
		return facManageMapper.getFacManage(facCode);
	}

	@Override
	public List<FacManageVO> FacList(FacManageVO facilityVO) {
		return facManageMapper.getfacList(facilityVO);
	}

	

	}

