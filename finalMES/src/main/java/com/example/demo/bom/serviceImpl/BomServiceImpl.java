package com.example.demo.bom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bom.mapper.BomMapper;
import com.example.demo.bom.service.BomService;
import com.example.demo.inform.ProdVO;

@Service
public class BomServiceImpl implements BomService{

	@Autowired
	BomMapper bomMapper;
	
	@Override
	public List<ProdVO> ProdList() {
		return bomMapper.getProdList();
	}

}
