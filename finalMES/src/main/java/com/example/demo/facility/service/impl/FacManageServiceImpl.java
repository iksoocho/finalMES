package com.example.demo.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.facility.FacCompositeVO;
import com.example.demo.facility.FacManageVO;
import com.example.demo.facility.FacNotopVO;
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
		// TODO Auto-generated method stub
		return facManageMapper.getfacNotList();
	}



	
	
	
	
	//동시 insert
	@Override
	public void insertFacWithNotop(FacCompositeVO facCompositeVO) {
		facManageMapper.insertFac(facCompositeVO.getFacManageVO());
		System.out.println("facCode : "+ facCompositeVO.getFacManageVO().getFacCode());
		
		facCompositeVO.getFacNotopVO().setFacCode(facCompositeVO.getFacManageVO().getFacCode());
		facManageMapper.insertFacNot(facCompositeVO.getFacNotopVO());
	}

	@Override
	public void updateFacNot(FacNotopVO facNotopVO) {
		facManageMapper.updateFacNot(facNotopVO);
		
		
	}

	@Override
	public int insertFacNot(FacNotopVO facNotopVO) {
		// TODO Auto-generated method stub
		return 0;
	}


}
