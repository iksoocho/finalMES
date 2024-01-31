package com.example.demo.facility.service;

import java.util.List;

import com.example.demo.facility.FacManageVO;

public interface FacManageService {
	public FacManageVO getFacility(String facCode);
	public List<FacManageVO> FacList(FacManageVO faManageVO);

}
