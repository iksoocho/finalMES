package com.example.demo.facility.service;

import java.util.List;

import com.example.demo.facility.FacManageVO;

public interface FacManageService {
	public FacManageVO getFacility(String facCode);
	// 리스트
	public List<FacManageVO> FacList(FacManageVO facManageVO);
	// 등록
	public int insertFac(FacManageVO facManageVO);
	// 삭제
	public int deleteFac(String facCode);

}
