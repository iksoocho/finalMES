package com.example.demo.facility.mapper;

import java.util.List;

import com.example.demo.facility.FacilityVO;

public interface FacilityMapper {
	public FacilityVO getFacility(String facCode);
	public List<FacilityVO> getfacList(FacilityVO facilityVO);
}
