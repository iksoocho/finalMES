package com.example.demo.facility.service;

import java.util.List;

import com.example.demo.facility.FacCompositeVO;
import com.example.demo.facility.FacInsVO;
import com.example.demo.facility.FacManageVO;
import com.example.demo.facility.FacNotopVO;

public interface FacManageService {
	// 설비관리
	public FacManageVO getFacility(String facCode);
	// 리스트
	public List<FacManageVO> FacList(FacManageVO facManageVO);
	// 등록
	public int insertFac(FacManageVO facManageVO);


	
	
	// 비가동
	public FacNotopVO getFacilityNotop(String facCode);
	// 리스트
	public List<FacNotopVO> FacNotopList();
	// 등록
	public int insertFacNot(FacNotopVO facNotopVO);
	
	
	
	// 설비 + 비가동 동시 insert
	public void insertFacWithNotop(FacCompositeVO facCompositeVO);
	// 수정
	public void updateFacNot(FacNotopVO facNotopVO);
	// 삭제

	
	
	// 점검관리
	// 리스트
	public List<FacInsVO> FacInsList();
	
}
