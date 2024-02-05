package com.example.demo.facility.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.facility.FacNotopVO;
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
	
	// 비가동등록
	@PostMapping("/facNotop")
	public String insertFacNotop(@RequestBody FacNotopVO facNotopVO) {
		System.out.println("비가동등록 통신 테스트");
		System.out.println(facNotopVO);
		
		facNotopMapper.insertFacNot(facNotopVO);
		System.out.println("여기까지 오나안오나~");
		return "facility/facNotop";
		
	}
	
}
