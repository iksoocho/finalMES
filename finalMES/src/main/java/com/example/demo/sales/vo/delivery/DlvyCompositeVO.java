package com.example.demo.sales.vo.delivery;

import java.util.List;

import com.example.demo.sales.vo.order.OrderVO;
import com.example.demo.sales.vo.product.ProductLotDVO;

import lombok.Data;

@Data
public class DlvyCompositeVO {
	private ProdDlvyVO prodDlvyVO;
	public List<ProdDetailDlvyVO> prodDetailDlvyList;
	private ProductLotDVO productLotDVO;
	private OrderVO orderVO;
	public ProdDetailDlvyVO prodDetailDlvyVO;
}
