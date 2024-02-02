package com.example.demo.material.mapper;

import java.util.List;

import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;

public interface MaterialMapper {
	// 단건 
	public MatOrderVO getMat(String matCode);
	
	//발주 전체
	public List<MatOrderVO> getMatOrderList();
	public List<MatOrderInfoVO> getMaterialOrdInfoList(String matordCode);
	
	//등록 join 등록 말고 그냥 
	public int insertMatOrder(MatOrderVO materialVO);
//	public int insertMatOrder1(MatOrderVO materialVO);
//	public int insertMatOrder2(MatOrderVO materialVO);
}
