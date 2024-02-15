package com.example.demo.bom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bom.BomVO;
import com.example.demo.bom.mapper.BomMapper;
import com.example.demo.bom.service.BomService;
import com.example.demo.inform.ProdVO;
import com.example.demo.material.OriginMaterialVO;

@Service
public class BomServiceImpl implements BomService{

	@Autowired
	BomMapper bomMapper;
	
	@Override
	public List<ProdVO> ProdList() {
		return bomMapper.getProdList();
	}

	@Override
	public List<OriginMaterialVO> OriginMaterialList() {
		return bomMapper.getOriginMaterialList();
	}

	@Override
	public int bomSeq() {
		return bomMapper.getBomSeq();
	}

	@Override
	public void bomInsert(List<BomVO> bomList) {
		for(int i = 0; i < bomList.size(); i++) {
			bomMapper.bomInsert(bomList.get(i));
		}
	}
}
