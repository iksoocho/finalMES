package com.example.demo.inform.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.inform.EmpVO;

public interface InformService {
	public List<EmpVO> getEmpList();
	public EmpVO insertEmpInfo(EmpVO empVO);
	
	public EmpVO getEmpInfo(String userCode);
}
