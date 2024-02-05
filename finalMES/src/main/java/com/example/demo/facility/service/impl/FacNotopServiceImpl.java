package com.example.demo.facility.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.facility.FacNotopVO;
import com.example.demo.facility.mapper.FacNotopMapper;
import com.example.demo.facility.service.FacNotopService;

@Service
public class FacNotopServiceImpl implements FacNotopService{

	@Autowired
	FacNotopMapper facNotopMapper;
	
	@Override
	public FacNotopVO getFacility(String facCode) {
		return facNotopMapper.getFacNotop(facCode);
	}

	@Override
	public List<FacNotopVO> FacList(FacNotopVO facNotopVO) {
		return facNotopMapper.getfacNotList(facNotopVO);
	}

	@Override
	public int insertFacNot(FacNotopVO facNotopVO) {
		int result = facNotopMapper.insertFacNot(facNotopVO);
		if(result == 1) {
			return 1;
		} else {
			return -1;
		}
	}

}
