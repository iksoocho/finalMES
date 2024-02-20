package com.example.demo.inform.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.inform.BadMaterialVO;
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
	public int updateResetPass(EmpVO empVO);
	public int deleteEmp(String userCode);
	
	//자재
	public List<MatVO> selectMatList();
	public int insertMatInfo(MatVO matVO);
	public int deleteMat(String matCode);
	
	
	//제품
	public List<ProdVO> selectProdList();
	public int insertProdInfo(ProdVO prodVO);
	public int deleteProd(String prodCode);
	
	
	//공정
	public List<ProcVO> selectProcList();
	public int insertProcInfo(ProcVO procVO);
	public int deleteProc(String procCode);
	
	
	//자재 불량
	public List<BadMaterialVO> selectBadMatList();
	public int insertBadMatInfo(BadMaterialVO badMatVO);
	public int deleteBad(String badMatCode);
};
