package com.example.demo.inform.mapper;

import java.util.List;

import com.example.demo.inform.EmpVO;

public interface InformMapper {
	public List<EmpVO> selectEmpList();
	public int insertEmpInfo(EmpVO empVO);
	public EmpVO selectEmpInfo(String userCode);
}
