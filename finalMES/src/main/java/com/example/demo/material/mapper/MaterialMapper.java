package com.example.demo.material.mapper;

import java.util.List;

import com.example.demo.material.MatOrderVO;

public interface MaterialMapper {
	// 단건 
	public MatOrderVO getMat(String matCode);
	
	//전체
	public List<MatOrderVO> getMatList(MatOrderVO materialVO);
	
	//등록
	public int insertMatOrder(MatOrderVO materialVO);
}
