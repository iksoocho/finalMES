package com.example.demo.produce.service;

import java.util.List;

import com.example.demo.produce.ProdInsDetailVO;
import com.example.demo.produce.ProdInsVO;

public interface ProdInsService {
	public List<ProdInsVO> getInsList();
	public List<ProdInsDetailVO> getInsDetailList(String insCode);
	public ProdInsDetailVO getCheckDetailList(String dInsCode);
}
