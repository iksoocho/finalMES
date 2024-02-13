package com.example.demo.inform.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.inform.BadMaterialVO;
import com.example.demo.inform.EmpVO;
import com.example.demo.inform.MatVO;
import com.example.demo.inform.ProcVO;
import com.example.demo.inform.ProdVO;
import com.example.demo.inform.service.InformService;

@Controller
public class InformController {
	
	@Autowired
	InformService informService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
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
		String encodedPassword = passwordEncoder.encode("1234");
		empVO.setUserPassword(encodedPassword);
		informService.insertEmpInfo(empVO);
		msg = "사원 정보가 등록 되었습니다.";
		return msg;
	}
	
	@GetMapping("/myPage")
	public String getEmpInfo(Model model, HttpSession session) {
	    // 세션에서 userCode 가져오기
	    String userCode = (String) session.getAttribute("userCode");
	    

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
	
	 @PostMapping("/checkPass")
	 @ResponseBody
	    public String checkPassword(HttpServletRequest request,
	                                @RequestParam("userPassword") String userPassword) {
		 // 세션에서 userCode 가져오기
	        String userCode = (String) request.getSession().getAttribute("userCode");

	        // 세션에 userCode가 없는 경우 처리
	        if (userCode == null) {
	            return "사용자 코드가 세션에 존재하지 않습니다.";
	        }

	        // 비밀번호 검증
	        boolean isPasswordMatch = informService.checkPass(userCode, userPassword);
	        
	        if (isPasswordMatch) {
	            return "1";
	        } else {
	            return "0";
	        }
	    }
	 
	 @PutMapping("/passUpdate")
	 @ResponseBody
		public String updatePass(HttpServletRequest request, @RequestParam("userPassword") String userPassword) {
			
			String userCode = (String) request.getSession().getAttribute("userCode");
			String encodedPassword = passwordEncoder.encode(userPassword);

	        // 세션에 userCode가 없는 경우 처리
	        if (userCode == null) {
	            return "사용자 코드가 세션에 존재하지 않습니다.";
	        }
			
	       
	     // 비밀번호 검증
	        boolean isPasswordMatch =  informService.updatePass(userCode, encodedPassword);
	        
	        if (isPasswordMatch) {
	            return "1";
	        } else {
	            return "0";
	        }
					
		}
	 
	 //------------------------------------------자재------------------------------------------------------
	 @GetMapping("matList")
		public String getMatList(Model model) {
			List<MatVO> list = informService.getMatList();
			model.addAttribute("list", list);
			
			return "inform/matList";	
		}
	 
	 @PostMapping("/matInsert")
	 @ResponseBody
	 public String insertMat(@RequestBody MatVO matVO) {
		 String msg;
		 informService.insertMatInfo(matVO);
		 msg = "자재 정보가 등록 되었습니다.";
		 return msg;
	 }
	 
	 
	 
	 
	 
	 //----------------------------------제품---------------------------------------------------------
	 @GetMapping("prodList")
	 public String getProdList(Model model) {
		 List<ProdVO> list = informService.getProdList();
		 model.addAttribute("list", list);
		
		 return "inform/prodList";	
		 }
	 
	 
	 @PostMapping("/prodInsert")
	 @ResponseBody
	 public String insertMat(@RequestBody ProdVO prodVO) {
		 String msg;
		 informService.insertProdInfo(prodVO);
		 msg = "제품 정보가 등록 되었습니다.";
		 return msg;
	 }
	 
	 
	 
	//----------------------------------공정---------------------------------------------------------
	 @GetMapping("procList")
	 public String getProcList(Model model) {
		 List<ProcVO> list = informService.getProcList();
		 model.addAttribute("list", list);
		
		 return "inform/procList";	
		 }
	 
	 @PostMapping("/procInsert")
	 @ResponseBody
	 public String insertProc(@RequestBody ProcVO procVO) {
		 String msg;
		 informService.insertProcInfo(procVO);
		 msg = "공정 정보가 등록 되었습니다.";
		 return msg;
	 }
	 
	 
	//----------------------------------자재불량---------------------------------------------------------
	 @GetMapping("badMatList")
	 public String getBadMatList(Model model) {
		 List<BadMaterialVO> list = informService.getBadMatList();
		 model.addAttribute("list", list);
		
		 return "inform/badMatList";	
		 }
	 
	 @PostMapping("/badMatInsert")
	 @ResponseBody
	 public String insertBadMat(@RequestBody BadMaterialVO badMatVO) {
		 String msg;
		 informService.insertBadMatInfo(badMatVO);
		 msg = "공정 정보가 등록 되었습니다.";
		 return msg;
	 }
	 
}
