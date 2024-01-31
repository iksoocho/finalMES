package com.example.demo.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.material.MaterialVO;
import com.example.demo.material.mapper.MaterialMapper;
import com.example.demo.material.service.MaterialService;

public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialMapper materialMapper;

	@Override
	public MaterialVO getMat(String matCode) {
		return materialMapper.getMat(matCode);
		// 발주 상세
	}
	
	@Override
	public List<MaterialVO> getMaterialList(MaterialVO materialVO) {
		return materialMapper.getMatList(materialVO);
		// 발주 리스트 정보
	}
	
	
}
