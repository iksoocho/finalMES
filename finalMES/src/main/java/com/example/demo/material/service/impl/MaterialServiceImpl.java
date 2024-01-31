package com.example.demo.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.material.MatOrderVO;
import com.example.demo.material.mapper.MaterialMapper;
import com.example.demo.material.service.MaterialService;

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
	public List<MatOrderVO> getMaterialList(MatOrderVO matOrderVO) {
		return materialMapper.getMatList(matOrderVO);
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
