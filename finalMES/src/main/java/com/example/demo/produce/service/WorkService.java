package com.example.demo.produce.service;

import java.util.List;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.WorkMidRegistVO;

public interface WorkService {
	public List<FacCateVO> getFacSelect(String procCode);
	public int insertWorkMidRegist(WorkMidRegistVO workMidRegistVO);
	public List<WorkMidRegistVO> checkWorkMidRegist(String dinsCode, String procCode);
	public int updateWorkMidRegist(WorkMidRegistVO workMidRegistVO);
	public int insertWorkResult(String dinsCode);
	public int updateProdInsState(String dinsCode);
	public int updateOrdListState(String dinsCode);
	public int updateMatLot(int inputValue, String inputMatCode);
}
