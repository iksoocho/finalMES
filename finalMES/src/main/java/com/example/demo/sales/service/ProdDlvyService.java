package com.example.demo.sales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sales.vo.delivery.DlvyCompositeVO;
import com.example.demo.sales.vo.delivery.ProdDetailDlvyDVO;
import com.example.demo.sales.vo.delivery.ProdDetailDlvyVO;
import com.example.demo.sales.vo.delivery.ProdDlvyDVO;
import com.example.demo.sales.vo.delivery.ProdDlvyVO;

@Service
public interface ProdDlvyService {

	// 출고서 등록
	public ProdDlvyVO saveDlvy(ProdDlvyVO prodDlvyVO);

	// 출고서 상세 등록
	public ProdDetailDlvyVO saveDetailDlvy(ProdDetailDlvyVO prodDetailDlvyVO);
	
	// 출고서 및 상세 등록
	public void saveDlvyWithDetail(DlvyCompositeVO dlvyCompositeVO);
	
	// 출고서 조회
	public List<ProdDlvyDVO> getProdDlvyList(ProdDlvyDVO prodDlvyDVO);
	
	// 출고서 상세 조회
	public List<ProdDetailDlvyDVO> getProdDetailDlvyList(String ordCode);

	
}
