package com.example.demo.produce.mapper;

import java.util.List;

import com.example.demo.produce.ProdInsDetailVO;
import com.example.demo.produce.ProdInsVO;


public interface InsMapper {

	public List<ProdInsVO> getInsList();		//생산지시조회
	public List<ProdInsDetailVO> getInsDetailList(String insCode);		//생산지시상세조회
	public ProdInsDetailVO getCheckDetailList(String dInsCode);	//선택된 생산상세지시건
}
