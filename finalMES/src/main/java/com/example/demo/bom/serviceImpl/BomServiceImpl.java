package com.example.demo.bom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bom.BomVO;
import com.example.demo.bom.mapper.BomMapper;
import com.example.demo.bom.service.BomService;
import com.example.demo.inform.ProdVO;
import com.example.demo.material.OriginMaterialVO;
import com.example.demo.produce.ProcessVO;

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
	public List<ProcessVO> ProcessList() {
		return bomMapper.getProcessList();
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

	@Override
	public List<BomVO> getBomList(String prodCode) {
		return bomMapper.getBomList(prodCode);
	}

	@Override
	public void bomDelete(BomVO bomVO) {
	   bomMapper.bomDelete(bomVO);
	      
	   }

	@Override
	public void bomUpdate(List<BomVO> bomList) {
		for(int i = 0; i < bomList.size(); i++) {
			bomMapper.bomUpdate(bomList.get(i));
		}
	}

	
}
