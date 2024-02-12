package com.example.demo.inform.web;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/myPage")
	public String getEmpInfo(Model model, HttpSession session) {
	    // 세션에서 userCode 가져오기
	    String userCode = (String) session.getAttribute("userCode");
	    System.out.println("userCode : " + userCode);

	    // userCode가 세션에 존재하는 경우에만 사용자 정보를 조회
	    if (userCode != null) {
	        EmpVO vo = informService.getEmpInfo(userCode);
	        model.addAttribute("vo", vo);
	        System.out.println("vo : " + vo);
	    } else {
	        // 세션에 userCode가 없는 경우, 적절한 처리 (예: 로그인 페이지로 리디렉션)
	        return "redirect:/login";
	    }

	    return "inform/myPage";
	}
}
