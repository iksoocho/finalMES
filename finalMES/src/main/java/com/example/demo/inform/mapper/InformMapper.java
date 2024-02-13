package com.example.demo.inform.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.inform.EmpVO;
import com.example.demo.inform.MatVO;
import com.example.demo.inform.ProcVO;
import com.example.demo.inform.ProdVO;

public interface InformMapper {
	//사원
	public List<EmpVO> selectEmpList();
	public int insertEmpInfo(EmpVO empVO);
	public EmpVO selectEmpInfo(String userCode);
	
	public int checkPassword(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
	public String getPass(String userPassword);
	public int updatePass(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
	
	
	//자재
	public List<MatVO> selectMatList();
	public int insertMatInfo(MatVO matVO);
	
	
	//제품
	public List<ProdVO> selectProdList();
	public int insertProdInfo(ProdVO prodVO);
	
	
	//공정
	public List<ProcVO> selectProcList();
};
