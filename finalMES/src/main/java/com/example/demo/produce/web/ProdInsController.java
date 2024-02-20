package com.example.demo.produce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.produce.FacCateVO;
import com.example.demo.produce.ProcessVO;
import com.example.demo.produce.ProdInsDetailVO;
import com.example.demo.produce.ProdInsVO;
import com.example.demo.produce.ProdProgressJoinVO;
import com.example.demo.produce.WorkLoadVO;
import com.example.demo.produce.service.ProdInsService;

@Controller
public class ProdInsController {
	
	@Autowired
	ProdInsService prodInsService;
	
	@GetMapping("planOrder")
	public String insList(Model model){
		List<ProdInsVO> list = prodInsService.getInsList();
		model.addAttribute("insList", list);
		
		return "produce/planOrder";
	}
	
	@GetMapping("planOrderList")
	public String insAllList(Model model){
		List<ProdInsVO> list = prodInsService.getInsList();
		String code = null;
	    if (!list.isEmpty()) {
	        ProdInsVO firstProdInsVO = list.get(0); // 첫 번째 ProdInsVO 추출
	        code = firstProdInsVO.getInsCode();
	    }
		List<ProdInsDetailVO> detailList = prodInsService.getInsDetailList(code);
		model.addAttribute("insList", list);
		model.addAttribute("detailList", detailList);
		return "produce/planOrderList";
	}
	
	@GetMapping("planOrderDetail")
	@ResponseBody
	public List<ProdInsDetailVO> getPlanOrderDetailList(@RequestParam String insCode){
//		System.out.println("상세조회 : " + prodInsService.getInsDetailList(insCode));
		return prodInsService.getInsDetailList(insCode);
	}
	
	@GetMapping("workRegist")
	public String workRegist(@RequestParam String dInsCode, @RequestParam String prodCode, Model model) {
		System.out.println("dinsCode : " + dInsCode);
		ProdInsDetailVO vo = prodInsService.getCheckDetailList(dInsCode);
		List<WorkLoadVO> load = prodInsService.getWorkPageLoadData(prodCode);
		List<ProcessVO> proc = prodInsService.getProcData();
		List<FacCateVO> fac = prodInsService.getFacSelect("PROC004");
		List<ProdProgressJoinVO> prJoin = prodInsService.getProdProgress(dInsCode);
		System.out.println(vo);
		System.out.println(load);
		model.addAttribute("vo", vo);
		model.addAttribute("load", load);
		model.addAttribute("proc", proc);
		model.addAttribute("fac", fac);
		model.addAttribute("prJoin", prJoin);
		model.addAttribute("prodCode", prodCode);
		
		return "produce/workRegist";
	}
	
}
