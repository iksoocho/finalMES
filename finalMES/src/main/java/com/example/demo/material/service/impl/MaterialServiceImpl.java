package com.example.demo.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.material.MatInputVO;
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

	@Override
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matordCode) {
		// TODO Auto-generated method stub
		return materialMapper.getMaterialOrdInfoList(matordCode);
	}

	// 발주 등록
	@Override
	public int insertMaterialOrder(MatOrderVO matOrderVO) {
		int result = materialMapper.insertMatOrder(matOrderVO);
//		result = materialMapper.insertMatOrder1(matOrderVO);
//		result = materialMapper.insertMatOrder2(matOrderVO);

		if (result == 1) {
			return 1;
		} else {
			return -1;
		}
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
	public List<OriginMaterialVO> getMatBusiness() {
		// TODO Auto-generated method stub
		return materialMapper.getMatBusiness();
	}
	
	
	
	
	
	
	
	
//	@Override
//	public int insertMaterialOrder1(MatOrderVO matOrderVO) {
//		int result = materialMapper.insertMatOrder1(matOrderVO);
//
//		if (result == 1) {
//			return matOrderVO.getMatOrCount();
//		} else {
//			return -1;
//		}
//	}
//
//	@Override
//	public int insertMaterialOrder2(MatOrderVO matOrderVO) {
//		int result = materialMapper.insertMatOrder2(matOrderVO);
//
//		if (result == 1) {
//			return 1;
//		} else {
//			return -1;
//		}
//	}

}
