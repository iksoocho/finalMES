package com.example.demo.produce.mapper;

import java.util.List;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.ProcessVO;
import com.example.demo.produce.WorkLoadVO;

public interface WorkMapper {
	public List<WorkLoadVO> getLoadData(String prodCode);
	public List<FacCateVO> getFacSelect(String procCode);
	public List<ProcessVO> getProcData();
}
