package com.example.demo.material.service;

import java.util.List;

import com.example.demo.material.MaterialVO;

public interface MaterialService {
	public MaterialVO getMat(String matCode);
	public List<MaterialVO> getMaterialList(MaterialVO materialVO);
	
}
