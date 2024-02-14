package com.example.demo.sales.vo.delivery;

import java.util.List;

import com.example.demo.sales.vo.order.OrderVO;

import lombok.Data;

@Data
public class DlvyCompositeVO {
	private ProdDlvyVO prodDlvyVO;
	public List<ProdDetailDlvyVO> ProdDetailDlvyList;
	
}
