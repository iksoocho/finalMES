package com.example.demo.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.sales.vo.delivery.ProdDetailDlvyVO;
import com.example.demo.sales.vo.delivery.ProdDlvyDVO;
import com.example.demo.sales.vo.delivery.ProdDlvyVO;
import com.example.demo.sales.vo.order.OrderVO;

@Mapper
public interface ProdDlvyMapper {
	public int saveDlvy(ProdDlvyVO prodDlvyVO); // 완제품 출고 등록.

	public int saveDetailDlvy(ProdDetailDlvyVO prodDetailDlvyVO); // 완제품 출고 상세 등록

	public int updateInventory(@Param("prodLotCode") String prodLotCode, @Param("prodOutputCount") int prodOutputCount); // 재고량 업데이트 메서드 호출
	
	public void updateOrderState(String ordCode); // 출고등록시 주문서 상태 업데이트
	
	public List<ProdDlvyDVO> prodDlvyList(ProdDlvyDVO prodDlvyDVO); // 제품출고서 조회
}