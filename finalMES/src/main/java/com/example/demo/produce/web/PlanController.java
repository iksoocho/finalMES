package com.example.demo.produce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.produce.PlanVO;
import com.example.demo.produce.service.PlanService;

@Controller
public class PlanController {
	
	@Autowired
	PlanService planService;
	
	@GetMapping("planManage")
	public String getPlanList(Model model) {
		List<PlanVO> list = planService.getPlanList();
		model.addAttribute("list", list);
		return "produce/planManage";
				
	}
	
}
