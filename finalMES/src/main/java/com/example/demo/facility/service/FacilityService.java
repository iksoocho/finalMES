package com.example.demo.facility.service;

import java.util.List;

import com.example.demo.facility.FacilityVO;

public interface FacilityService {
	public FacilityVO getFacility(String facCode);
	public List<FacilityVO> getFacilityList(FacilityVO facilityVO);

}
