package com.example.demo.sales.service;

import org.springframework.stereotype.Service;

import com.example.demo.sales.vo.delivery.DlvyCompositeVO;
import com.example.demo.sales.vo.delivery.ProdDetailDlvyVO;
import com.example.demo.sales.vo.delivery.ProdDlvyVO;

@Service
public interface ProdDlvyService {

	// 출고서 등록
	public ProdDlvyVO saveDlvy(ProdDlvyVO prodDlvyVO);

	// 출고서 상세 등록
	public ProdDetailDlvyVO saveDetailDlvy(ProdDetailDlvyVO prodDetailDlvyVO);
	
	// 출고서 및 상세 등록
	public void saveDlvyWithDetail(DlvyCompositeVO dlvyCompositeVO);
}
