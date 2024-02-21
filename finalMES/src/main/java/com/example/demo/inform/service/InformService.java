package com.example.demo.inform.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.inform.BadMaterialVO;
import com.example.demo.inform.BusinessVO;
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
	
	public void updateResetPass(EmpVO empVO);
	
	public void deleteEmp(String userCode);
	
	//자재
	public List<MatVO> getMatList();
	public MatVO insertMatInfo(MatVO matVO);
	public void deleteMat(String matCode);
	
	
	
	
	//제품
	public List<ProdVO> getProdList();
	public ProdVO insertProdInfo(ProdVO prodVO);
	public void deleteProd(String prodCode);
	
	
	//공정
	public List<ProcVO> getProcList();
	public ProcVO insertProcInfo(ProcVO procVO);
	public void deleteProc(String procCode);
	
	
	//자재 불량
	public List<BadMaterialVO> getBadMatList();
	public BadMaterialVO insertBadMatInfo(BadMaterialVO badMatVO);
	public void deleteBad(String badMatCode);
	
	
	//거래처
	public List<BusinessVO> getBusinessList();
	public BusinessVO insertBusiness(BusinessVO businessVO);
	public void deleteBusiness(String businessCode);
}
