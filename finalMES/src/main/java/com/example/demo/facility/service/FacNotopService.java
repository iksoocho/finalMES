package com.example.demo.facility.service;

import java.util.List;

import com.example.demo.facility.FacNotopVO;

public interface FacNotopService {
	public FacNotopVO getFacility(String facCode);
	// 리스트
	public List<FacNotopVO> FacList(FacNotopVO facNotopVO);
}
