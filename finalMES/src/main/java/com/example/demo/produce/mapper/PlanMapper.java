package com.example.demo.produce.mapper;

import java.util.List;

import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;

public interface PlanMapper {
	public List<PlanVO> selectPlanList();
	public List<PlanOrdVO> selectOrdList();
	public List<PlanOrdDVO> selectOrdDList(String ordCode);
}
