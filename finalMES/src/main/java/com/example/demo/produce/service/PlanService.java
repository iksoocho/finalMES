package com.example.demo.produce.service;

import java.util.List;

import com.example.demo.produce.InsCompositeVO;
import com.example.demo.produce.MatUseVO;
import com.example.demo.produce.PlanCompositeVO;
import com.example.demo.produce.PlanDVO;
import com.example.demo.produce.PlanInsDVO;
import com.example.demo.produce.PlanInsVO;
import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;

public interface PlanService {
	public List<PlanVO> getPlanList();
	public List<PlanVO> getPlanByOrdCode(String ordCode);
	public List<PlanDVO> getPlanDList(String planCode);
	
	public List<PlanOrdVO> getOrdList();
	public List<PlanOrdDVO> getOrdDList(String ordCode);
	
	//public int insertPlanInfo(PlanVO planVO);
	public PlanVO insertPlanInfo(PlanVO planVO);
	public PlanDVO insertPlanDetailInfo(PlanDVO planDVO);
	
	public void insertProductionWithDetails(PlanCompositeVO planCompositeVO);
	 
	public void updatePlanDInfo(PlanCompositeVO planCompositeVO);
	
	public void deleteplanInfo(PlanCompositeVO planCompositeVO);
	
	public List<PlanVO> getPlanP1();
	
	
	//생산 지시
	public List<PlanInsVO> getPlanInsList();
	public List<PlanInsDVO> getPlanDInsList(String insCode);
//	public PlanInsVO insertInsInfo(PlanInsVO planInsVO);
//	public PlanInsDVO insertInsDInfo(PlanInsDVO planInsDVO);
	public void insertInsWithDetail(InsCompositeVO insCompositeVO);
	public void deleteInsInfo(InsCompositeVO insCompositeVO);
	
	public void updateInsDInfo(InsCompositeVO insCompositeVO);
	
	public List<MatUseVO> getMatUseList(String dinsCode);
}
