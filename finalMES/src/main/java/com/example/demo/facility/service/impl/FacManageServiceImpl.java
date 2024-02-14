package com.example.demo.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.facility.FacCompositeVO;
import com.example.demo.facility.FacInsDVO;
import com.example.demo.facility.FacInsVO;
import com.example.demo.facility.FacManageVO;
import com.example.demo.facility.FacNotopVO;
import com.example.demo.facility.FacRepVO;
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
	public List<FacManageVO> FacList(FacManageVO facManageVO) {
		return facManageMapper.getfacList(facManageVO);
	}

	@Override
	public int insertFac(FacManageVO facManageVO) {
		int result = facManageMapper.insertFac(facManageVO);
		if(result == 1) {
			return 1;
		} else {
			return -1;
		}
		
	}

	@Override
	public FacNotopVO getFacilityNotop(String facCode) {
		// TODO Auto-generated method stub
		return  facManageMapper.getFacNotop(facCode);
	}

	@Override
	public List<FacNotopVO> FacNotopList() {
		return facManageMapper.getfacNotList();
	}



	
	
	
	
	//설비 등록
	@Override
	public void insertFacWithNotop(FacCompositeVO facCompositeVO) {
		// 설비기본정보 등록
		facManageMapper.insertFac(facCompositeVO.getFacManageVO());
		System.out.println("facCode : "+ facCompositeVO.getFacManageVO().getFacCode());
		
		// 비가동 등록
		facCompositeVO.getFacNotopVO().setFacCode(facCompositeVO.getFacManageVO().getFacCode());
		facManageMapper.insertFacNot(facCompositeVO.getFacNotopVO());
	}

	// 비가동 업데이트
	@Override
	public void updateFacNot(FacNotopVO facNotopVO) {
		facManageMapper.updateFacNot(facNotopVO);
	}
	
	@Override
	public int insertFacNot(FacNotopVO facNotopVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	// 점검관리
	@Override
	public List<FacInsVO> FacInsList() {
		return facManageMapper.getfacInsList();
	}
	
	@Transactional
	public void updateFacIns(FacInsVO facInsVO) {
		String facInsJud = facInsVO.getFacInsJud();
		String facNotCode = facInsVO.getFacNotCode();
		if ("적합".equals(facInsJud)) {
		    facManageMapper.updateFacInsSi(facNotCode);
		}
		facManageMapper.updateFacIns(facInsVO);
	}
	
	// 점검관리등록
	@Override
	public int insertFacIns(FacInsDVO facInsDVO) {
		// 점검등록
		int result = facManageMapper.insertFacIns(facInsDVO);
		if(result == 1) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int insertFacInsNot(FacNotopVO facNotopVO) {
		int result = facManageMapper.insertFacInsNot(facNotopVO);
		if(result == 1) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
	// 설비관리
	@Override
	public List<FacRepVO> FacRepList() {
		return facManageMapper.getfacRepList();
	}

	@Override
	public int insertFacRep(FacRepVO facRepVO) {
		int result = facManageMapper.insertFacRep(facRepVO);
		if(result == 1) {
			return 1;
		} else {
			return -1;
		}
		
	}

	@Override
	public int insertFacRepNot(FacNotopVO facNotopVO) {
		int result = facManageMapper.insertFacRepNot(facNotopVO);
		if(result == 1) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	@Transactional
	public void updateFacRep(FacRepVO facRepVO) {
		String facRepRepairs = facRepVO.getFacRepRepairs();
		String facNotCode = facRepVO.getFacNotCode();
		if ("수리완료".equals(facRepRepairs)) {
		    System.out.println("적합합니다");
		    facManageMapper.updateFacRepNot(facNotCode);
		}
		facManageMapper.updateFacRep(facRepVO);
		
	}
	
}
