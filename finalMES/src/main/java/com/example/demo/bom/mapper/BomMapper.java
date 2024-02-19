package com.example.demo.bom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bom.BomVO;
import com.example.demo.inform.ProdVO;
import com.example.demo.material.OriginMaterialVO;
import com.example.demo.produce.ProcessVO;

@Mapper
public interface BomMapper {
	
	// 상단 그리드의 제품 리스트
	public List<ProdVO> getProdList();
	// 하단 그리드의 자재코드 자재명 들고오는 리스트
	public List<OriginMaterialVO> getOriginMaterialList();
	// 하단 그리드의 공정 들고오는 리스트
	public List<ProcessVO> getProcessList();
	// bom 시퀀스
	public int getBomSeq();
	// bom insert
	public void bomInsert(BomVO bomVO);
	
	// bom list
	public List<BomVO> getBomList(String prodCode);
	// bom delete
	public int bomDelete(BomVO bomVO);
	// bom update
	public void bomUpdate(String bomCode);
}
