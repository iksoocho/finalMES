package com.example.demo.produce.mapper;

import java.util.List;

import com.example.demo.produce.WorkLoadVO;

public interface WorkMapper {
	public List<WorkLoadVO> getLoadData(String prodCode);
}
