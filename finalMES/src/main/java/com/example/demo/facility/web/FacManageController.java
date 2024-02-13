package com.example.demo.facility.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.facility.FacCompositeVO;
import com.example.demo.facility.FacInsDVO;
import com.example.demo.facility.FacInsVO;
import com.example.demo.facility.FacNotopVO;
import com.example.demo.facility.FacRepVO;
import com.example.demo.facility.mapper.FacManageMapper;
import com.example.demo.facility.service.FacManageService;

@Controller
public class FacManageController {

	@Autowired
	FacManageMapper facManageMapper;
	@Autowired
	FacManageService facManageService;

	// 설비 전체조회
	@GetMapping("/facManagement")
	public String list(Model model) {
		model.addAttribute("list", facManageService.FacList(null));
		return "facility/facManagement";

	}

	// 비가동 전체조회
	@GetMapping("/facNotop")
	public String Notoplist(Model model) {
		model.addAttribute("nlist", facManageService.FacNotopList());
		return "facility/facNotop";

	}

	// 비가동 수정
	@PutMapping("/updateFacNot")
	@ResponseBody
	public String updateFacNot(@RequestBody FacNotopVO facNotopVO) {
		String msg;
		facManageService.updateFacNot(facNotopVO);
		System.out.println(facNotopVO);
		msg = "수정완료";
		return msg;
	}

	// 점검관리 전체조회
	@GetMapping("/facInsList")
	@ResponseBody
	public List<FacInsVO> getFacInsList() {
		return facManageService.FacInsList();
	}

	// 점검관리 수정
	@PutMapping("updateFacIns")
	@ResponseBody
	public String updateFacIns(@RequestBody FacInsVO facInsVO) {
		String msg;
		String facInsJud = facInsVO.getFacInsJud();
		String facNotCode = facInsVO.getFacNotCode();
		System.out.println("facInsJud : " + facInsJud);
		System.out.println("facNotCode : " + facNotCode);
		if ("적합".equals(facInsJud)) {
		    System.out.println("적합합니다");
		    facManageService.updateFacInsSi(facNotCode);
		}
		facManageService.updateFacIns(facInsVO);
		System.out.println(facInsVO);
		msg = "수정완료";
		return msg;
	}

	// 점검관리 모달리스트
	@GetMapping("/facIns")
	public String NotopInslist(Model model) {
		model.addAttribute("Inslist", facManageService.FacNotopList());
		return "facility/facIns";

	}

	@PostMapping("/insrtFacAndNot")
	@ResponseBody
	public String insertFacAndNot(@RequestBody FacCompositeVO facCompositeVO) {
		String msg;
		facManageService.insertFacWithNotop(facCompositeVO);
		msg = "등록 성공";
		return msg;
	}
	
	@PostMapping("/insertFacIns")
	@ResponseBody
	public String insertFacIns(@RequestBody FacInsDVO facInsDVO) {
		String msg;
		facManageService.insertFacIns(facInsDVO);
		msg = "등록성공";
		return msg;
	}

	
	@PostMapping("/insertFacInsNot")
	@ResponseBody
	public String insertFacInsNot(@RequestBody FacNotopVO facNotopVO) {
		String msg;
		facManageService.insertFacInsNot(facNotopVO);
		msg = "등록성공";
		return msg;
	}
	
	/*
	 * @GetMapping("/facRep") public String facRepList(Model model) {
	 * System.out.println("통신완료"); model.addAttribute("rlist",
	 * facManageService.FacRepList()); return "facility/facRep";
	 * 
	 * }
	 */
	// 점검관리 전체조회
	@GetMapping("/FacRepList")
	@ResponseBody
	public List<FacRepVO> getFacRepList() {
		return facManageMapper.getfacRepList();
		
	}
	
	// 수리관리 모달리스트
	@GetMapping("/facRep")
	public String NotopReplist(Model model) {
		model.addAttribute("Replist", facManageService.FacNotopList());
		return "facility/facRep";

	}
	
	// insert
	@PostMapping("/insertFacRep")
	@ResponseBody
	public String insertFacRep(@RequestBody FacRepVO facRepVO) {
		String msg;
		facManageService.insertFacRep(facRepVO);
		msg = "등록성공";
		return msg;
	}
	
	@PostMapping("/insertFacRepNot")
	@ResponseBody
	public String insertFacRepNot(@RequestBody FacNotopVO facNotopVO) {
		String msg;
		facManageService.insertFacRepNot(facNotopVO);
		msg = "등록성공";
		return msg;
	}
	
	@PutMapping("/updateFacRep")
	@ResponseBody
	public String updateFacRep(@RequestBody FacRepVO facRepVO) {
		String msg;
		String facRepRepairs = facRepVO.getFacRepRepairs();
		String facNotCode = facRepVO.getFacNotCode();
		System.out.println("facRepRepairs : " + facRepRepairs);
		System.out.println("facNotCode : " + facNotCode);
		if ("수리완료".equals(facRepRepairs)) {
		    System.out.println("적합합니다");
		    facManageService.updateFacRepNot(facNotCode);
		}
		facManageService.updateFacRep(facRepVO);
		System.out.println(facRepVO);
		msg = "수정완료";
		return msg;
	}
}
