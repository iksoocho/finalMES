package com.example.demo.produce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.ProcessVO;
import com.example.demo.produce.ProdInsDetailVO;
import com.example.demo.produce.ProdInsVO;
import com.example.demo.produce.ProdProgressJoinVO;
import com.example.demo.produce.WorkLoadVO;
import com.example.demo.produce.mapper.InsMapper;
import com.example.demo.produce.mapper.WorkMapper;
import com.example.demo.produce.service.ProdInsService;

@Service
public class ProdInsServiceImpl implements ProdInsService{

	@Autowired
	InsMapper insMapper;
	
	@Autowired
	WorkMapper workMapper;
	
	@Override
	public List<ProdInsVO> getInsList() {
		return insMapper.getInsList();
	}

	@Override
	public List<ProdInsDetailVO> getInsDetailList(String insCode) {
		return insMapper.getInsDetailList(insCode);
	}

	@Override
	public ProdInsDetailVO getCheckDetailList(String dInsCode) {
		return insMapper.getCheckDetailList(dInsCode);
	}

	@Override
	public List<WorkLoadVO> getWorkPageLoadData(String prodCode) {
		return workMapper.getLoadData(prodCode);
	}

	@Override
	public List<ProcessVO> getProcData() {
		return workMapper.getProcData();
	}

	@Override
	public List<FacCateVO> getFacSelect(String procCode) {
		return workMapper.getFacSelect(procCode);
	}

	@Override
	public List<ProdProgressJoinVO> getProdProgress(String dInsCode) {
		return workMapper.getProdProgress(dInsCode);
	}

}
