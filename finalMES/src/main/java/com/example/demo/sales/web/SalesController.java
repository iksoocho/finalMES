package com.example.demo.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.sales.service.OrdService;
import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderVO;
import com.example.demo.sales.vo.product.ProductListVO;

@Controller
public class SalesController {

	@Autowired
	private OrdService ordService;

	@GetMapping("/getOrder/{ordCode}") // 단건조회에 대한 상세목록도 같이 출력하게 SQL문 변경
	public String getOrder(@PathVariable String ordCode, Model model) {
		OrderVO order = ordService.getOrder(ordCode);
		model.addAttribute("order", order);
		return "sales/orderList";
	}

	@GetMapping("/orderInsert")
	public String getBusinessList(Model model) {
		List<BusinessListVO> businessList = ordService.getBusinessList();
		List<ProductListVO> productList = ordService.getProductList();
		model.addAttribute("businessList", businessList);
		model.addAttribute("productList", productList);
		return "sales/orderInsert";
	}

	@PostMapping("/saveOrder")
	public String saveOrder(@RequestBody OrderVO order) {
		// OrderVO에는 주문서 정보가 담겨있을 것으로 가정합니다.

		// 주문서 등록 로직 수행
		ordService.saveOrder(order);

		

		// 등록 후에 주문서 목록 페이지로 리다이렉션
		return "redirect:/orderList"; // "/orderList"로 리다이렉션하도록 설정
	}
	
	@GetMapping("/orderList")
	public String getOrderList(Model model) {
		List<OrderVO> orderList = ordService.getOrderList();
		model.addAttribute("orderList", orderList);
		return "sales/orderList";
	}
		

}
