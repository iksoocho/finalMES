package com.example.demo.emp.mapper;

import java.util.List;

import com.example.demo.emp.EmpVO;

//@Mapper
public interface EmpMapper { 
	public EmpVO getEmp(EmpVO empVO); 
	public List<EmpVO> getEmpList(EmpVO empVO); 
	public void empInsert(EmpVO empVO);
}
