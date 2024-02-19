package com.example.demo.bom.service;

import java.util.List;

import com.example.demo.bom.BomVO;
import com.example.demo.inform.ProdVO;
import com.example.demo.material.OriginMaterialVO;
import com.example.demo.produce.ProcessVO;

public interface BomService {
	// 제품 리스트
	public List<ProdVO> ProdList();
	// 자재리스트
	public List<OriginMaterialVO> OriginMaterialList();
	// 공정리스트
	public List<ProcessVO> ProcessList();
	// bom 시퀀스
	public int bomSeq();
	// bom insert
	public void bomInsert(List<BomVO> bomList);
	//bom list 
	public List<BomVO> getBomList(String prodCode);
	// bom delete
	public void bomDelete(BomVO bomVO);
	// bom update
	public void bomUpdate(List<BomVO> bomList);
}
