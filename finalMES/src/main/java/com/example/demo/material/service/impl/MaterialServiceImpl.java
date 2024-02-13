package com.example.demo.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.material.MatInputVO;
import com.example.demo.material.MatOrderCompositeVO;
import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.MatOutputVO;
import com.example.demo.material.MatReturnVO;
import com.example.demo.material.OriginMaterialVO;
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
		return materialMapper.getMaterialOrderList();
	}
	// 발주 전체 겸 상세 디테일 거래처에 리스트 띄우는거
	@Override
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matCode) {
		// TODO Auto-generated method stub
		return materialMapper.getMaterialOrdInfoList(matCode);
	}
	
	
	// 발주 거래처 관리에서 발주 목록으로 리스트 띄우는거
	@Override
	public List<OriginMaterialVO> getMatBusiness1(String businessCode) {
		// TODO Auto-generated method stub
		return materialMapper.getMatBusiness1(businessCode);
	}
	
	@Override
	public List<OriginMaterialVO> getMatBusiness() {
		// TODO Auto-generated method stub
		return materialMapper.getMatBusiness();
	}
	
	// 발주 목록에 추가하기
	@Override
	public List<MatOrderVO> getMatOrderList() {
		// TODO Auto-generated method stub
		return materialMapper.getMatOrderList();
	}
	
	
	// 발주 자재 관리
	@Override
	public List<OriginMaterialVO> getOriginMaterialList() {
		// TODO Auto-generated method stub
		return materialMapper.getOriginMaterialList();
	}
	
	
	
	
	// 자재 관리 페이지
	@Override
	public List<OriginMaterialVO> getOriginMaterialList1() {
		// TODO Auto-generated method stub
		return materialMapper.getOriginMaterialList1();
	}
	
	
	// 자재 출고 페이지
	@Override
	public List<MatOutputVO> getOutputList() {
		// TODO Auto-generated method stub
		return materialMapper.getOutputList();
	}
	
	// 입고 관리 조회
	@Override
	public List<MatInputVO> getInputList() {
		// TODO Auto-generated method stub
		return materialMapper.getInputList();
	}
	
	// 반품 관리 조회
	@Override
	public List<MatReturnVO> getReturnList() {
		// TODO Auto-generated method stub
		return materialMapper.getReturnList();
	}

	@Override
	public MatOrderVO insertMatOrder(MatOrderVO matOrderVO) {
		materialMapper.insertMatOrder(matOrderVO);
		return matOrderVO;
	}

	@Override
	public MatOrderInfoVO insertMatOrderInfo(MatOrderInfoVO matorderInfoVO) {
		materialMapper.insertMatOrderInfo(matorderInfoVO);
		return matorderInfoVO;
	}

	@Override
	public void insertMaterialOrder(MatOrderCompositeVO matOrderCompositeVO) {
		
		materialMapper.insertMatOrder(matOrderCompositeVO.getMatOrderVO());
		
		for (int i = 0; i < matOrderCompositeVO.getMatOrderInfoList().size(); i++) {
			matOrderCompositeVO.getMatOrderInfoList().get(i).setMatOrCode(matOrderCompositeVO.getMatOrderVO().getMatOrCode());
			System.out.println("등록성공");
		}
	}

	@Override
	public List<MatOrderInfoVO> getMaterialOrdInfoList1(String matCode) {
		// TODO Auto-generated method stub
		return materialMapper.getMaterialOrdInfoList1(matCode);
	}


}
