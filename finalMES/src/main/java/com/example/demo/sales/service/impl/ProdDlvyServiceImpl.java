package com.example.demo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sales.mapper.ProdDlvyMapper;
import com.example.demo.sales.service.ProdDlvyService;
import com.example.demo.sales.vo.delivery.ProdDlvyVO;

@Service
public class ProdDlvyServiceImpl implements ProdDlvyService {

	@Autowired
	private ProdDlvyMapper prodDlvyMapper;

	@Override
	public void saveDlvy(ProdDlvyVO prodDlvyVO) {
		
		// 출고서 저장
		prodDlvyMapper.saveDlvy(prodDlvyVO);
	}

}
