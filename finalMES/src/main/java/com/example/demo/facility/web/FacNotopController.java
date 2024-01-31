package com.example.demo.facility.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.facility.mapper.FacNotopMapper;

@Controller
public class FacNotopController {
	
	@Autowired
	FacNotopMapper facNotopMapper;
	
	// 비가동조회
	@GetMapping("/facNotop")
	public String list(Model model) {
		model.addAttribute("list", facNotopMapper.getfacNotList(null));
		return "facility/facNotop";
	}
}
