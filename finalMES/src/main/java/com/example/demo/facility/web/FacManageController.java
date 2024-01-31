package com.example.demo.facility.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.facility.mapper.FacManageMapper;


@Controller
public class FacManageController {
	
	@Autowired
	FacManageMapper facManageMapper;

	// 설비 전체조회
	@GetMapping("/facManagement")
	public String list(Model model) {
		model.addAttribute("list", facManageMapper.getfacList(null));
		return "facility/facManagement";

	}
	
	// 설비등록

 }
