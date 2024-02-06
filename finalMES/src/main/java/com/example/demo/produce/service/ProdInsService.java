package com.example.demo.produce.service;

import java.util.List;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.ProcessVO;
import com.example.demo.produce.ProdInsDetailVO;
import com.example.demo.produce.ProdInsVO;
import com.example.demo.produce.WorkLoadVO;

public interface ProdInsService {
	public List<ProdInsVO> getInsList();
	public List<ProdInsDetailVO> getInsDetailList(String insCode);
	public ProdInsDetailVO getCheckDetailList(String dInsCode);
	public List<WorkLoadVO> getWorkPageLoadData(String prodCode);
	public List<ProcessVO> getProcData();
	public List<FacCateVO> getFacSelect(String procCode);
}
