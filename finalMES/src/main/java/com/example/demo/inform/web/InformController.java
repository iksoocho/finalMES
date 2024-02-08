package com.example.demo.inform.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.inform.EmpVO;
import com.example.demo.inform.service.InformService;

@Controller
public class InformController {
	
	@Autowired
	InformService informService;
	
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = informService.getEmpList();
		model.addAttribute("list", list);
		
		return "inform/empList";
	}
}
