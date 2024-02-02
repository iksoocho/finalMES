package com.example.demo.facility.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.facility.FacManageVO;
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
	
	// 설비삭제
    @DeleteMapping("/facManagement")
    public String deleteFac(String facCode) {
        facManageMapper.deleteFac(facCode);
        return "facility/facManagement";
    }
    
    // 등록
    @PostMapping("/facManagement")
    public String insertFacProcess(@RequestBody FacManageVO facManageVO) {
    	System.out.println("통신테스트");
    	System.out.println(facManageVO);
    	
    	facManageMapper.insertFac(facManageVO);
    	System.out.println("xxx");
		return "facility/facManagement";
    }
 }
