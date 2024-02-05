package com.example.demo.produce.mapper;

import java.util.List;


import com.example.demo.produce.PlanDVO;
import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;

public interface PlanMapper {
	public List<PlanVO> selectPlanList();
	public List<PlanVO> selectPlanByOrdCode(String ordCode);
	public List<PlanDVO> selectPlanDList(String planCode);
	
	public List<PlanOrdVO> selectOrdList();
	public List<PlanOrdDVO> selectOrdDList(String ordCode);
	
	public int insertPlanInfo(PlanVO planVO);
	
	public int insertPlanDInfo(PlanDVO planDVO);
	
	public int updatePlanInfo(PlanDVO planDVO);
	

	


}
