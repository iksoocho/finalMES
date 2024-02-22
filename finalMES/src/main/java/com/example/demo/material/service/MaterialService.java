package com.example.demo.material.service;

import java.util.List;

import com.example.demo.material.BadMatVO;
import com.example.demo.material.MatInputVO;
import com.example.demo.material.MatInspectionVO;
import com.example.demo.material.MatOrderCompositeVO;
import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.MatOutputVO;
import com.example.demo.material.MatReturnVO;
import com.example.demo.material.MaterialVO;
import com.example.demo.material.OriginMaterialVO;
import com.example.demo.sales.vo.business.BusinessListVO;

public interface MaterialService {
	// 단건
	public MatOrderVO getMat(String matCode);
	
	// 발주 전체 모달
//	public List<MatOrderVO> getMaterialOrderList();
	
	public List<OriginMaterialVO> getOriginMaterialList();
	// 발주 전체 겸 상세 디테일
	public List<MatOrderInfoVO> getMaterialOrdInfoList();
	// 발주 전체 겸 목록
	public List<MatOrderInfoVO> getMaterialOrdInfoList1(String matCode);
	// 발주 거래처 관리
//	public List<OriginMaterialVO> getMatBusiness1(String businessCode);
	// 발주 거래처 관리
//	public List<OriginMaterialVO> getMatBusiness();
	// 발주 목록에 추가하기
//	public List<MatOrderVO> getMatOrderList();
	
	
	// 자재 입고
	public List<MatInputVO> getInputList();
	// 자재 검수
	public List<MatInspectionVO> getMatInsList();
	
	// 자재관리 조회
	public List<OriginMaterialVO> getOriginMaterialList1();
	
	// 자재 출고
	public List<MatOutputVO> getOutputList();
	
	// 자재 반품
	public List<MatReturnVO> getReturnList();
	
	// 등록
	public MatOrderVO insertMatOrder(MatOrderVO matOrderVO);
	
	public MatOrderInfoVO insertMatOrderInfo(MatOrderInfoVO matorderInfoVO);
	// 성오형꺼 
	public BusinessListVO insertBusiness(BusinessListVO businessListVO);
	
	public void insertMaterialOrder(MatOrderCompositeVO matOrderCompositeVO);
	
	//수정
	public void updateMatOrder(MatOrderCompositeVO matOrderCompositeVO);
	// 입고쪽
	public void updateMatLot(MaterialVO materialVO);
	// 검수쪽
	public void updateMatIns(MatInspectionVO matInspectionVO);
	
	//삭제
	public void deleteMatOrder(MatOrderCompositeVO matOrderCompositeVO);
	
	
	
	// 자재 입고 페이지 검수 인서트
	public MatInspectionVO insertMatIns(MatInspectionVO matInspectionVO);
	public List<BadMatVO> getBadMatList();
	
	
	// 자재 입고 입고페이지 입고 인서트
	public MatInputVO matInputInsert(MatInputVO matInputVO);
	
	public List<OriginMaterialVO> getMatOriginInfoList(String matCode);
	
	
	
	
	
	
}
