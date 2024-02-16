package com.example.demo.facility.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.example.demo.produce.service.ProdInsService;
import com.example.demo.sales.service.OrdService;

import lombok.extern.log4j.Log4j2;
/**
 * 설비관리 비가동관리 수리관리 점검관리
 * @author 박규현
 *
 */
@Log4j2
@Controller
public class FacManageController {

	@Autowired
	FacManageMapper facManageMapper;
	@Autowired
	FacManageService facManageService;
	@Autowired
	ProdInsService prodInsService;
	@Autowired
	OrdService ordService;

	/**
	 * 설비 전체조회
	 * @param model
	 * @return facility/facManagement
	 */
	@GetMapping("/facManagement")
	public String list(Model model, HttpServletRequest session) {
		model.addAttribute("list", facManageService.FacList(null));
		model.addAttribute("proList", prodInsService.getProcData());
		model.addAttribute("busiList", ordService.getBusinessList());
		System.out.println(ordService.getBusinessList());
		System.out.println("userName : "+ session.getAttribute("userName"));
		model.addAttribute("username", session.getSession().getAttribute("userName"));
		return "facility/facManagement";

	}

	/**
	 * 비가동 전체조회
	 * @param model
	 * @return facility/facNotop
	 */
	@GetMapping("/facNotop")
	public String Notoplist(Model model, HttpServletRequest session) {
		model.addAttribute("nlist", facManageService.FacNotopList());
		System.out.println("userName : "+ session.getAttribute("userName"));
		model.addAttribute("username", session.getSession().getAttribute("userName"));
		return "facility/facNotop";

	}

	/**
	 * 비가동 수정
	 * @param model
	 * @return msg
	 */
	@PutMapping("/updateFacNot")
	@ResponseBody
	public String updateFacNot(@RequestBody FacNotopVO facNotopVO) {
		String msg;
		facManageService.updateFacNot(facNotopVO);
		msg = "수정완료";
		log.info(msg);
		return msg;
	}

	/**
	 * 점검관리 리스트
	 * @return 점검리스트
	 */
	@GetMapping("/facInsList")
	@ResponseBody
	public List<FacInsVO> getFacInsList() {
		return facManageService.FacInsList();
	}

	/**
	 * 점검관리 수정
	 * @param facInsVO
	 * @return msg
	 */
	@PutMapping("updateFacIns")
	@ResponseBody
	public String updateFacIns(@RequestBody FacInsVO facInsVO) {
		String msg;
		facManageService.updateFacIns(facInsVO);
		msg = "수정완료";
		return msg;
	}
	
	// 설비점검관리	
	@GetMapping("/facIns")
	public String NotopInslist(Model model, HttpServletRequest session) {
		System.out.println("userName : "+ session.getAttribute("userName"));
		model.addAttribute("username", session.getSession().getAttribute("userName"));
		// 모달 설비관리 리스트
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
	
	
	// 수리관리 전체조회
	@GetMapping("/FacRepList")
	@ResponseBody
	public List<FacRepVO> getFacRepList() {
		return facManageMapper.getfacRepList();
		
	}
	
	// 수리관리 리스트
	@GetMapping("/facRep")
	public String NotopReplist(Model model, HttpServletRequest session) {
		System.out.println("userName : "+ session.getAttribute("userName"));
		model.addAttribute("username", session.getSession().getAttribute("userName"));
		// 수리관리 모달리스트
		model.addAttribute("Replist", facManageService.FacNotopList());
		return "facility/facRep";

	}
	
	// insert
	@PostMapping("/insertFacRep")
	@ResponseBody
	public String insertFacRep(FacRepVO facRepVO) {
		String msg;
		facManageService.insertFacRep(facRepVO);
		msg = "등록성공";
		return msg;
	}
	
	// 수리쪽 비가동처리 등록
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
		facManageService.updateFacRep(facRepVO);
		msg = "수정완료";
		return msg;
	}
}
