package com.example.demo.material.service;

import java.util.List;

import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.MatOutputVO;
import com.example.demo.material.OriginMaterialVO;

public interface MaterialService {
	// 단건
	public MatOrderVO getMat(String matCode);
	
	// 발주 전체 모달
	public List<MatOrderVO> getMaterialOrderList();
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matordCode);
	public List<OriginMaterialVO> getOriginMaterialList();
	
	
	// 자재관리 조회
	public List<OriginMaterialVO> getOriginMaterialList1();
	
	// 자재 출고
	public List<MatOutputVO> getOutputList();
	
	// 등록
	public int insertMaterialOrder(MatOrderVO matOrderVO);
	
}
