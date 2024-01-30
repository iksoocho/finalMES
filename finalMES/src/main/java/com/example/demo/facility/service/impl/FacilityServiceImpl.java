package com.example.demo.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.facility.FacilityVO;
import com.example.demo.facility.mapper.FacilityMapper;
import com.example.demo.facility.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Autowired
	FacilityMapper mapperMapper;

	@Override
	public FacilityVO getFacility(String facCode) {
		return mapperMapper.getFacility(facCode);
	}

	@Override
	public List<FacilityVO> getFacilityList(FacilityVO facilityVO) {
		return mapperMapper.getfacList(facilityVO);
	}

	

}
