package com.example.demo.produce.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.produce.PlanDVO;
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
    @Transactional
    public void insertProductionWithDetails(PlanVO planVO, List<PlanDVO> planDVOList) {
    	planMapper.insertPlanInfo(planVO); // prod_plan에 데이터 삽입

        String generatedPlanCode = planVO.getPlanCode(); // 생성된 planCode 가져오기

        for (PlanDVO planDVO : planDVOList) {
            planDVO.setPlanCode(generatedPlanCode); // prod_d_plan의 각 항목에 planCode 설정
            planMapper.insertPlanDInfo(planDVO); // prod_d_plan에 데이터 삽입
        }
    }

	

}
