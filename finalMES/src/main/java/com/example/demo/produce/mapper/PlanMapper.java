package com.example.demo.produce.mapper;

import java.util.List;

import com.example.demo.bom.BomVO;
import com.example.demo.produce.MatUseVO;
import com.example.demo.produce.PlanDVO;
import com.example.demo.produce.PlanInsDVO;
import com.example.demo.produce.PlanInsVO;
import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;

public interface PlanMapper {
	//생산 계획
	public List<PlanVO> selectPlanList();
	public List<PlanVO> selectPlanByOrdCode(String ordCode);
	public List<PlanDVO> selectPlanDList(String planCode);
	
	public List<PlanOrdVO> selectOrdList();
	public List<PlanOrdDVO> selectOrdDList(String ordCode);
	
	public int insertPlanInfo(PlanVO planVO);
	
	public int insertPlanDInfo(PlanDVO planDVO);

	public void deltePlanInfo(String planCode);
	
	public int updatePlanDInfo(PlanDVO planDVO);
	
	//주문서 상태 수정
	public void updateOrderStateZero(String ordCode);
	public void updateOrderStateOne(String ordCode);
	
	
	
	
	
	//생산 지시
	public List<PlanInsVO> selectPlanInsList();
	//public List<PlanVO> selectPlanByOrdCode(String ordCode);
	public List<PlanInsDVO> selectPlanDInsList(String insCode);

	public int insertPlanInsInfo(PlanInsVO planInsVO);
	
	public int insertPlanDInsInfo(PlanInsDVO planInsDVO);
	
	public int updatePlanDInsInfo(PlanInsDVO planInsDVO);
	
	public void deltePlanInsInfo(String insCode);
	//계획 상태 수정
	public void updatePlanStateZero(String planCode);
	public void updatePlanStateOne(String planCode);
	
	public void deleteInsInfo(String insCode);
	
	public void updateInsDInfo(PlanInsDVO planInsDVO);
	
	//prod_code 로 bom 조회
	public List<BomVO> selectBomByProd(String prodCode);
	
	//mat_use insert
	public void insertMatUse(MatUseVO matUseVO);
	
	//mat_ues list
	public List<MatUseVO> selectMatUseList(String dinsCode);
	


}
