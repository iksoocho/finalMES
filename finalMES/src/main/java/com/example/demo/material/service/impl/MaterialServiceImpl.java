package com.example.demo.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.mapper.MaterialMapper;
import com.example.demo.material.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialMapper materialMapper;

	// 발주 상세
	@Override
	public MatOrderVO getMat(String matCode) {
		return materialMapper.getMat(matCode);
	}
	
	// 발주 리스트 정보
	@Override
	public List<MatOrderVO> getMaterialOrderList() {
		return materialMapper.getMatOrderList();
	}

	@Override
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matordCode) {
		// TODO Auto-generated method stub
		return materialMapper.getMaterialOrdInfoList(matordCode);
	}
	
	
	// 발주 등록
	@Override
	public int insertMaterialOrder(MatOrderVO matOrderVO) {
		int result = materialMapper.insertMatOrder(matOrderVO);
		
		if(result == 1) {
			return matOrderVO.getMatOrCount();
		} else {
			return -1;
		}
	}


	
	
}
