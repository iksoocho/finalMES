package com.example.demo.material.service;

import java.util.List;

import com.example.demo.material.MatOrderVO;

public interface MaterialService {
	// 단건
	public MatOrderVO getMat(String matCode);
	
	//전체
	public List<MatOrderVO> getMaterialList(MatOrderVO materialVO);
	
	// 등록
	public int insertMaterialOrder(MatOrderVO matOrderVO);
}
