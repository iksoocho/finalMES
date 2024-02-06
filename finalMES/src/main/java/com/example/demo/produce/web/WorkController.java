package com.example.demo.produce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.service.WorkService;

@Controller
public class WorkController {
	
	@Autowired
	WorkService workService;
	
	@GetMapping("facList")
	@ResponseBody
	public List<FacCateVO> selectedFacList(@RequestParam String procCode) {
		return workService.getFacSelect(procCode);
	}

}
