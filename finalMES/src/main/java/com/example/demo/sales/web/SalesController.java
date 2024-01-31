package com.example.demo.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.sales.service.OrdService;
import com.example.demo.sales.vo.business.BusinessListVO;
import com.example.demo.sales.vo.order.OrderVO;

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

	@GetMapping("/ordInsert")
	public String getBusinessList(Model model) {
		List<BusinessListVO> businessList = ordService.getBusinessList();
		model.addAttribute("businessList", businessList);
		return "sales/orderInsert";
	}

}
