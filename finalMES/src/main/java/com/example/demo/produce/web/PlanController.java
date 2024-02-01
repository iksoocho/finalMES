package com.example.demo.produce.web;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.produce.PlanDVO;
import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;
import com.example.demo.produce.service.PlanService;


@Controller
public class PlanController {
	
	@Autowired
	PlanService planService;
	
	@GetMapping("planManage")
	public String getPlanList(Model model) {
		List<PlanVO> list = planService.getPlanList();
		String code = null;
	       if (!list.isEmpty()) {
	           PlanVO firstProdVO = list.get(0); // 첫 번째 ProdInsVO 추출
	           code = firstProdVO.getPlanCode();
	       }
	    List<PlanDVO> dList = planService.getPlanDList(code);
		List<PlanOrdVO> ordList = planService.getOrdList();
		model.addAttribute("list", list);
		model.addAttribute("dList", dList);
		model.addAttribute("ordList", ordList);
		
		return "produce/planManage";
				
	}
	
	
	@GetMapping("planByOrdCode")
	@ResponseBody
	public List<PlanVO> getPlanbyOrdCode(@RequestParam String ordCode){
		return planService.getPlanByOrdCode(ordCode);
	}
	
	@GetMapping("planDetail")
	@ResponseBody
	public List<PlanDVO> getPlanDList(@RequestParam String planCode){
		return planService.getPlanDList(planCode);
	}
	
	@GetMapping("orderDetail")
	@ResponseBody
	public List<PlanOrdDVO> getOrdDList(@RequestParam String ordCode) {
	    return planService.getOrdDList(ordCode);
	}
	
	
	  // 등록
	  
//	  @PostMapping("planInsert") 
//	  public String insertBoardInfoProcess(@RequestBody List<PlanVO> planList) { 
//		  for (PlanVO plan : planList) {
//		        planService.insertPlanInfo(plan);
//		    }; 
//		  return "redirect:planManage";
//	  
//	  }
	 
	
	  @PostMapping("planInsert")
	  @ResponseBody
	  public ResponseEntity<?> insertBoardInfoProcess(@RequestBody List<PlanVO> planList) {
	      for (PlanVO plan : planList) {
	          planService.insertPlanInfo(plan);
	      };
	      // 성공 응답을 JSON으로 반환
	      return ResponseEntity.ok().body("{\"status\":\"success\"}");
	  }
	

	
}
