package com.example.demo.material.service;

import java.util.List;

import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.OriginMaterialVO;

public interface MaterialService {
	// 단건
	public MatOrderVO getMat(String matCode);
	
	// 발주 전체 모달
	public List<MatOrderVO> getMaterialOrderList();
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matordCode);
	public List<OriginMaterialVO> getOriginMaterialList();
	
	
	// 등록
	public int insertMaterialOrder(MatOrderVO matOrderVO);
	
}
