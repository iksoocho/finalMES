package com.example.demo.produce.service;

import java.util.List;

import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;

public interface PlanService {
	public List<PlanVO> getPlanList();
	public List<PlanOrdVO> getOrdList();
	public List<PlanOrdDVO> getOrdDList(String ordCode);
}
