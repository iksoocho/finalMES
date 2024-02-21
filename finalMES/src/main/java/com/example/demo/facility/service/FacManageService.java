package com.example.demo.facility.service;

import java.util.List;

import com.example.demo.facility.FacBusinessVO;
import com.example.demo.facility.FacCompositeVO;
import com.example.demo.facility.FacInsDVO;
import com.example.demo.facility.FacInsVO;
import com.example.demo.facility.FacManageVO;
import com.example.demo.facility.FacNotopVO;
import com.example.demo.facility.FacRepVO;

public interface FacManageService {
	// 설비관리
	public FacManageVO getFacility(String facCode);
	// 리스트
	public List<FacManageVO> FacList(FacManageVO facManageVO);
	// 등록
	public int insertFac(FacManageVO facManageVO);
	// 거래처모달 리스트
	public List<FacBusinessVO> FacBusList(FacBusinessVO facBusinessVO);


	
	
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
	public void updateFacIns(FacInsVO facInsVO);
	public int insertFacIns(FacInsDVO facInsDVO);
	public int insertFacInsNot(FacNotopVO facNotopVO);

	// 수리관리
	public List<FacRepVO> FacRepList();
	public int insertFacRep(FacRepVO facRepVO);
	public int insertFacRepNot(FacNotopVO facNotopVO);
	public void updateFacRep(FacRepVO facRepVO);
	
}
