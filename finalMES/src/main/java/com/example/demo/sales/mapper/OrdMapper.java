package com.example.demo.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderDetailDVO;
import com.example.demo.sales.vo.order.OrderDetailVO;
import com.example.demo.sales.vo.order.OrderVO;
import com.example.demo.sales.vo.product.ProductListVO;
import com.example.demo.sales.vo.product.ProductLotVO;

@Mapper
public interface OrdMapper {
	public OrderVO getOrder(String ordCode);

	public OrderDetailVO getOrderDetail(String ordDCode);

	public void saveOrder(OrderVO orderVO);

	public void saveOrderDetail(OrderDetailVO orderDetailVO);

	public List<OrderVO> getOrderList(OrderVO orderVO); // 주문서 전체 조회

	public List<OrderDetailDVO> getOrderDetailList(String ordCode); // 주문서 상세 조회

	List<ProductLotVO> getProductLotList(@Param("prodCode") String prodCode);

	OrderVO getOrderCode(String businessCode); // 거래처에 대한 제일 최근 주문번호 조회

	public List<BusinessListVO> getBusinessList(); // 거래처 목록 조회

	public List<ProductListVO> getProductList(); // 품목리스트 조회

	public List<OrderVO> getOrderWithDetails(OrderVO orderVO);

}
