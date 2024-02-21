package com.example.demo.produce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.WorkMidRegistVO;
import com.example.demo.produce.mapper.WorkMapper;
import com.example.demo.produce.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	WorkMapper workMapper;

	@Override
	public List<FacCateVO> getFacSelect(String procCode) {
		return workMapper.getFacSelect(procCode);
	}

	@Override
	@Transactional
	public int insertWorkMidRegist(WorkMidRegistVO workMidRegistVO) {
		int result = workMapper.insertWorkMidRegist(workMidRegistVO);
		if(result == 1) {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public List<WorkMidRegistVO> checkWorkMidRegist(String dinsCode, String procCode) {
		return workMapper.checkWorkMidRegist(dinsCode, procCode);
	}

	@Override
	@Transactional
	public int updateWorkMidRegist(WorkMidRegistVO workMidRegistVO) {
		int result = workMapper.updateWorkMidRegist(workMidRegistVO);
		if(result == 1) {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public int insertWorkResult(String dinsCode) {
        int result = workMapper.insertWorkResult(dinsCode);
        System.out.println("=====================IMPL result insert==========================");
        System.out.println(dinsCode);
        System.out.println("=================================================================");
        if(result > 0) {
        	System.out.println("공정실적등록성공");
        	int ordResult = workMapper.updateOrdListState(dinsCode);
    		if(ordResult > 0) {
            	System.out.println("IMPL 주문서 상태변경 성공");
    			return 1;
    		}else {
    			System.out.println("IMPL 주문서 상태변경 실패");
    			return -1;
    		}
		}else {
			System.out.println("공정실적등록실패");
			return -1;
		}
	}

	@Override
	public int updateProdInsState(String dinsCode) {
		int result = workMapper.updateProdInsState(dinsCode);
		if(result > 0) {
        	System.out.println("IMPL 생산지시 상태변경 성공");
			return 1;
		}else {
			System.out.println("IMPL 생산지시 상태변경 실패");
			return -1;
		}
	}

	@Override
	public int updateOrdListState(String dinsCode) {
		int ordResult = workMapper.updateOrdListState(dinsCode);
		if(ordResult > 0) {
        	System.out.println("IMPL 주문서 상태변경 성공");
			return 1;
		}else {
			System.out.println("IMPL 주문서 상태변경 실패");
			return -1;
		}
	}

	@Override
	public int updateMatLot(int inputValue, String inputMatCode) {
		int result = workMapper.updateMatLot(inputValue, inputMatCode);
		if(result > 0) {
        	System.out.println("IMPL 소모자재 업데이트 성공");
			return 1;
		}else {
			System.out.println("IMPL 소모자재 업데이트 실패");
			return -1;
		}
	}

}
