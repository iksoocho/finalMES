package com.example.demo.material.mapper;

import java.util.List;

import com.example.demo.material.MatInputVO;
import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.MatOutputVO;
import com.example.demo.material.MatReturnVO;
import com.example.demo.material.OriginMaterialVO;

public interface MaterialMapper {
	// 단건 
	public MatOrderVO getMat(String matCode);
	
	// 발주 전체
	public List<MatOrderVO> getMaterialOrderList();
	public List<OriginMaterialVO> getOriginMaterialList();
	// 발주 전체 겸 상세 디테일
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matCode);
	// 발주 전체 겸 목록
	public List<MatOrderInfoVO> getMaterialOrdInfoList1(String matCode);
	// 발주 거래처 관리
	public List<OriginMaterialVO> getMatBusiness1(String businessCode);
	// 발주 거래처 관리
	public List<OriginMaterialVO> getMatBusiness();
	// 발주 목록에 추가하기
	public List<MatOrderVO> getMatOrderList();
	
	
	
	
	
	// 자재 입고
	public List<MatInputVO> getInputList();
	
	// 자재관리 조회
	public List<OriginMaterialVO> getOriginMaterialList1();
	
	// 자재 출고
	public List<MatOutputVO> getOutputList();
	
	// 자재 반품
	public List<MatReturnVO> getReturnList();
	
	//등록 join 등록 말고 그냥 
	public int insertMatOrder(MatOrderVO materialVO);
	
	public int insertMatOrderInfo(MatOrderInfoVO matOrderInfoVO);
	
	//수정
	public void updateMatOrder(MatOrderInfoVO matOrderInfoVO);
	
	//삭제
	public void deleteMatOrder(String matOrCode);


}
