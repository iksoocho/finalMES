package com.example.demo.sales.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.sales.vo.delivery.ProdDetailDlvyVO;
import com.example.demo.sales.vo.delivery.ProdDlvyVO;

@Mapper
public interface ProdDlvyMapper {
	public int saveDlvy(ProdDlvyVO prodDlvyVO); // 완제품 출고 등록.
	
	public int saveDetailDlvy(ProdDetailDlvyVO prodDetailDlvyVO); // 완제품 출고 상세 등록
	
	
}
