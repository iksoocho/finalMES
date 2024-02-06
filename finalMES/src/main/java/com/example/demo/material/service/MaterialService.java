package com.example.demo.material.service;

import java.util.List;

import com.example.demo.material.MatInputVO;
import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.MatOutputVO;
import com.example.demo.material.MatReturnVO;
import com.example.demo.material.OriginMaterialVO;

public interface MaterialService {
	// 단건
	public MatOrderVO getMat(String matCode);
	
	// 발주 전체 모달
	public List<MatOrderVO> getMaterialOrderList();
	public List<OriginMaterialVO> getOriginMaterialList();
	// 발주 전체 겸 상세
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matordCode);
	//발주 거래처 관리
	public List<OriginMaterialVO> getMatBusiness();
	
	// 자재 입고
	public List<MatInputVO> getInputList();
	
	// 자재관리 조회
	public List<OriginMaterialVO> getOriginMaterialList1();
	
	// 자재 출고
	public List<MatOutputVO> getOutputList();
	
	// 자재 반품
	public List<MatReturnVO> getReturnList();
	
	// 등록
	public int insertMaterialOrder(MatOrderVO matOrderVO);
	
}
