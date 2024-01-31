package com.example.demo.produce.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;

import com.example.demo.produce.PlanVO;
import com.example.demo.produce.service.PlanService;

@Controller
public class PlanController {
	
	@Autowired
	PlanService planService;
	
	@GetMapping("planManage")
	public String getPlanList(Model model) {
		List<PlanVO> list = planService.getPlanList();
		List<PlanOrdVO> ordList = planService.getOrdList();
		model.addAttribute("list", list);
		model.addAttribute("ordList", ordList);
		return "produce/planManage";
				
	}
	
	@GetMapping("orderDetail")
	@ResponseBody
	public List<PlanOrdDVO> getOrdDList(@RequestParam String ordCode) {
	    return planService.getOrdDList(ordCode);
	}
	

	
}
