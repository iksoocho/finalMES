package com.example.demo.inform.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.inform.EmpVO;
import com.example.demo.inform.MatVO;
import com.example.demo.inform.ProcVO;
import com.example.demo.inform.ProdVO;

public interface InformService {
	//사원
	public List<EmpVO> getEmpList();
	public EmpVO insertEmpInfo(EmpVO empVO);
	
	public EmpVO getEmpInfo(String userCode);
	
	public int checkPassword(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
	
	public boolean checkPass(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
	
	public boolean updatePass(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
	
	//자재
	public List<MatVO> getMatList();
	public MatVO insertMatInfo(MatVO matVO);
	
	
	
	//제품
	public List<ProdVO> getProdList();
	public ProdVO insertProdInfo(ProdVO prodVO);
	
	
	//공정
	public List<ProcVO> getProcList();
}
