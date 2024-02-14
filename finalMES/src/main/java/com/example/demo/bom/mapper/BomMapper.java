package com.example.demo.bom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.inform.ProdVO;

@Mapper
public interface BomMapper {
	
	public List<ProdVO> getProdList();
}
