package com.example.demo.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.emp.mapper.EmpMapper;

@Controller

public class EmpController {

	@Autowired
	EmpMapper empMapper;

	

	  @GetMapping("/empList")
	  public String list(Model model) {
		  model.addAttribute("list", empMapper.getEmpList(null)); 
		  return "emp/empList";
	  }
	 

//	@GetMapping("empList")
//	@ResponseBody
//	public List<EmpVO> getEmpList() {
//		return empMapper.getEmpList(null);
//	}

	


}
