package com.example.demo.produce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.WorkMidRegistVO;
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
	
	@PostMapping("/workMidInsert")
	@ResponseBody
	public String insertWorkMid(@RequestBody WorkMidRegistVO workMidVO) {
		System.out.println(workMidVO);
		int result = workService.insertWorkMidRegist(workMidVO);
		String msg;
		if(result == 1) {
			msg = "작업등록이 완료되었습니다.";
		}else {
			msg = "작업등록이 실패했습니다.";
		}
		
		return msg;
	}
	
	@PutMapping("/workMidUpdate")
	@ResponseBody
	public String updateWorkMid(@RequestBody WorkMidRegistVO workMidVO) {
		System.out.println(workMidVO);
		int result = workService.updateWorkMidRegist(workMidVO);
		String msg;
		if(result == 1) {
			msg = "작업추가등록이 완료되었습니다.";
		}else {
			msg = "작업추가등록이 실패했습니다.";
		}
		
		return msg;
	}
	
	@GetMapping("checkWorkMid")
	@ResponseBody
	public List<WorkMidRegistVO> checkWorkMidRegist(@RequestParam String dinsCode, @RequestParam String procCode){
		return workService.checkWorkMidRegist(dinsCode, procCode);
	}

}
