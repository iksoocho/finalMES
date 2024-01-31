package com.example.demo.produce.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.produce.mapper.InsMapper;

@Controller
public class PlanController {
	
	@Autowired
	InsMapper insMapper;
	
	@GetMapping("insList")
	public String insList(Model model){
		model.addAttribute("insList", insMapper.getInsList(null));
		
		return "produce/planOrder";
	}
}
