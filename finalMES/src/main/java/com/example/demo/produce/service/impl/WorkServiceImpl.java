package com.example.demo.produce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int updateWorkMidRegist(WorkMidRegistVO workMidRegistVO) {
		int result = workMapper.updateWorkMidRegist(workMidRegistVO);
		if(result == 1) {
			return 1;
		}else {
			return -1;
		}
	}

}
