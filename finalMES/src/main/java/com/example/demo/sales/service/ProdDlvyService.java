package com.example.demo.sales.service;

import org.springframework.stereotype.Service;

import com.example.demo.sales.vo.delivery.ProdDlvyVO;

@Service
public interface ProdDlvyService {
	public void saveDlvy(ProdDlvyVO prodDlvyVO);
}
