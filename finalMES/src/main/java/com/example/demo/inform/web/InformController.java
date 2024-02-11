package com.example.demo.inform.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/empInsert")
	@ResponseBody
	public String insertEmp(@RequestBody EmpVO empVO) {
		String msg;
		informService.insertEmpInfo(empVO);
		msg = "사원 정보가 등록 되었습니다.";
		return msg;
	}
}
