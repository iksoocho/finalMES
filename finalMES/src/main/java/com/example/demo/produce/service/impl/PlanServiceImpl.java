package com.example.demo.produce.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.produce.PlanCompositeVO;
import com.example.demo.produce.PlanDVO;
import com.example.demo.produce.PlanInsDVO;
import com.example.demo.produce.PlanInsVO;
import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;
import com.example.demo.produce.mapper.PlanMapper;
import com.example.demo.produce.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	PlanMapper planMapper;
	
	
	
	@Override
	public List<PlanVO> getPlanList() {
		// TODO Auto-generated method stub
		return planMapper.selectPlanList();
	}
	
	@Override
	public List<PlanVO> getPlanByOrdCode(String ordCode) {
		// TODO Auto-generated method stub
		return planMapper.selectPlanByOrdCode(ordCode);
	}
	
	@Override
	public List<PlanDVO> getPlanDList(String planCode) {
		// TODO Auto-generated method stub
		return planMapper.selectPlanDList(planCode);
	}

	@Override
	public List<PlanOrdVO> getOrdList() {
		// TODO Auto-generated method stub
		return planMapper.selectOrdList();
	}

	@Override
	public List<PlanOrdDVO> getOrdDList(String ordCode) {
		// TODO Auto-generated method stub
		return planMapper.selectOrdDList(ordCode);
	}

//	@Override
//	public int insertPlanInfo(PlanVO planVO) {
//		int result = planMapper.insertPlanInfo(planVO);
//		if(result ==1) {
//			return 1;
//		}else {
//			return -1;
//		}
//	}
	
	@Override
	public PlanVO insertPlanInfo(PlanVO planVO) {
	    planMapper.insertPlanInfo(planVO);
	    // insertPlanInfo 후에 PlanVO 객체는 새로 생성된 키를 포함해야 합니다.
	    // 이 키는 MyBatis에 의해 자동으로 할당되어야 합니다.
	    return planVO; 
	}

	@Override
	public PlanDVO insertPlanDetailInfo(PlanDVO planDVO) {
		planMapper.insertPlanDInfo(planDVO);
		return planDVO;
	}

	@Override
    public void insertProductionWithDetails(PlanCompositeVO planCompositeVO) {
		//주문서 상태 업데이트
		planMapper.updateOrderStateZero(planCompositeVO.getPlanOrdVO().getOrdCode());
		
		// prod_plan에 데이터 삽입
    	planMapper.insertPlanInfo(planCompositeVO.getPlanVO()); 
    	
    	
    	//루프 돌면서 상세 insert
        for (int i =0; i<planCompositeVO.getPlanDVOList().size(); i++) {
        	planCompositeVO.getPlanDVOList().get(i).setPlanCode(planCompositeVO.getPlanVO().getPlanCode()); // prod_d_plan의 각 항목에 planCode 설정
            planMapper.insertPlanDInfo(planCompositeVO.getPlanDVOList().get(i)); // prod_d_plan에 데이터 삽입
            System.out.println("등록성공");
        }
    }

	@Override
	public void updatePlanDInfo(PlanCompositeVO planCompositeVO) {
		System.out.println(planCompositeVO);
		for(int i = 0; i < planCompositeVO.getPlanDVOList().size(); i++) {
			 planMapper.updatePlanDInfo(planCompositeVO.getPlanDVOList().get(i));
		}
		
	}

	@Override
	public void deleteplanInfo(PlanCompositeVO planCompositeVO) {
		//주문서 상태 다시 1로 변경
		planMapper.updateOrderStateOne(planCompositeVO.getPlanOrdVO().getOrdCode());
		//plan 삭제
		planMapper.deltePlanInfo(planCompositeVO.getPlanVO().getPlanCode());
		
	}
	
	
	
	//생산 지시 
	@Override
	public List<PlanInsVO> getPlanInsList() {
		// TODO Auto-generated method stub
		return planMapper.selectPlanInsList();
	}

	@Override
	public List<PlanInsDVO> getPlanDInsList(String insCode) {
		// TODO Auto-generated method stub
		return planMapper.selectPlanDInsList(insCode);
	}

	

}
