package com.example.demo.sales.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.sales.mapper.OrdMapper;

@Controller
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	OrdMapper ordMapper;

	@GetMapping("/orderInsert")
	public String showOrderInsertPage() {
		return "sales/orderInsert"; // 해당 페이지의 Thymeleaf 경로
	}

}
