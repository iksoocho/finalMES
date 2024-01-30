package com.example.demo.material.mapper;

import java.util.List;

import com.example.demo.material.MaterialVO;

public interface MaterialMapper {
	public MaterialVO getMat(MaterialVO materialVO);
	public List<MaterialVO> getMatList(MaterialVO materialVO);
	
}
