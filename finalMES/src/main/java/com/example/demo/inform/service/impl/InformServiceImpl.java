package com.example.demo.inform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.inform.EmpVO;
import com.example.demo.inform.MatVO;
import com.example.demo.inform.ProcVO;
import com.example.demo.inform.ProdVO;
import com.example.demo.inform.mapper.InformMapper;
import com.example.demo.inform.service.InformService;

@Service
public class InformServiceImpl implements InformService {
	
	@Autowired
	InformMapper informMapper;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public List<EmpVO> getEmpList() {
		return informMapper.selectEmpList();
	}

	@Override
	public EmpVO insertEmpInfo(EmpVO empVO) {
		informMapper.insertEmpInfo(empVO);
		return empVO;
	}

	@Override
	public EmpVO getEmpInfo(String userCode) {
		return informMapper.selectEmpInfo(userCode);
	}

	

	@Override
	public int checkPassword(String userCode, String userPassword) {
		int result = informMapper.checkPassword(userCode, userPassword);
		return result > 0 ? 1 : 0;
	}

	@Override
	public boolean checkPass(String userCode, String userPassword) {
		String storedPasswordHash = informMapper.getPass(userCode);

        // 입력된 비밀번호와 저장된 해시 비교
        return storedPasswordHash != null && passwordEncoder.matches(userPassword, storedPasswordHash);
	}

	@Override
	public boolean updatePass(String userCode, String userPassword) {
		int affectedRows = informMapper.updatePass(userCode, userPassword);
	    return affectedRows > 0;
		
	}

	
	//자재
	@Override
	public List<MatVO> getMatList() {
		return informMapper.selectMatList();
	}

	@Override
	public MatVO insertMatInfo(MatVO matVO) {
		informMapper.insertMatInfo(matVO);
		return matVO;
	}

	
	
	//제품
	@Override
	public List<ProdVO> getProdList() {
		return informMapper.selectProdList();
	}

	@Override
	public ProdVO insertProdInfo(ProdVO prodVO) {
		informMapper.insertProdInfo(prodVO);
		return prodVO;
	}
	
	
	
	
	//공정
	@Override
	public List<ProcVO> getProcList() {
		return informMapper.selectProcList();
	}

}
