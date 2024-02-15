package com.example.demo.produce.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.produce.InsCompositeVO;
import com.example.demo.produce.PlanCompositeVO;
import com.example.demo.produce.PlanDVO;
import com.example.demo.produce.PlanInsDVO;
import com.example.demo.produce.PlanInsVO;
import com.example.demo.produce.PlanOrdDVO;
import com.example.demo.produce.PlanOrdVO;
import com.example.demo.produce.PlanVO;
import com.example.demo.produce.service.PlanService;

import lombok.extern.log4j.Log4j2;


/**
 * 생산 계획, 생산 지시
 * @author 조익수
 *
 */

@Log4j2
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
		log.info(dList);
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
	 
	
//	  @PostMapping("planInsert")
//	  @ResponseBody
//	  public ResponseEntity<?> insertBoardInfoProcess(@RequestBody List<PlanVO> planList) {
//	      for (PlanVO plan : planList) {
//	          planService.insertPlanInfo(plan);
//	          System.out.println(planService.insertPlanInfo(plan));
//	      };
//	      // 성공 응답을 JSON으로 반환
//	      return ResponseEntity.ok().body("{\"status\":\"success\"}");
//	  }
	
	@PostMapping("/planInsert")
	@ResponseBody
    public String insertProduction(@RequestBody PlanCompositeVO planCompositeVO) {
			String msg;
        	planService.insertProductionWithDetails(planCompositeVO);
        	msg = "생산 계획 및 상세 정보가 성공적으로 삽입되었습니다.";
            return msg;
     
    }
	
	@PutMapping("/planDUpdate")
	@ResponseBody
	public String updatePlanDetail(@RequestBody PlanCompositeVO planCompositeVO) {
		String msg;
		planService.updatePlanDInfo(planCompositeVO);
		msg = "상세 계획이 수정 되었습니다.";
		return msg;
				
	}
	
	@DeleteMapping("/planDelete")
	@ResponseBody
	public String deletePlan(@RequestBody PlanCompositeVO planCompositeVO) {
		String msg;
		planService.deleteplanInfo(planCompositeVO);
		msg = "계획이 삭제 되었습니다.";
		return msg;
	}
	

	
	
	
	
	//생산 지시
	@GetMapping("planIns")
	public String getPlanInsList(Model model) {
		List<PlanInsVO> list = planService.getPlanInsList();
		List<PlanVO> planList = planService.getPlanList();
		
		model.addAttribute("list", list);
		model.addAttribute("planList", planList);
		
		
		return "produce/planIns";
	}
	
	@GetMapping("insDetail")
	@ResponseBody
	public List<PlanInsDVO> getInsDList(@RequestParam String insCode){
		return planService.getPlanDInsList(insCode);
	}

	
	
	@PostMapping("/insInsert")
	@ResponseBody
    public String insertIns(@RequestBody InsCompositeVO insCompositeVO) {
			String msg;
        	planService.insertInsWithDetail(insCompositeVO);
        	msg = "생산 지시 및 상세 정보가 성공적으로 삽입되었습니다.";
            return msg;
     
    }
	
	@DeleteMapping("insDelete")
	@ResponseBody
	public String deleteIns(@RequestBody InsCompositeVO insCompositeVO) {
		String msg;
		planService.deleteInsInfo(insCompositeVO);
		msg = "생산 지시가 삭제 되었습니다.";
		return msg;
	}
	
	@PutMapping("/insDUpdate")
	@ResponseBody
	public String updateInsDetail(@RequestBody InsCompositeVO insCompositeVO) {
		String msg;
		planService.updateInsDInfo(insCompositeVO);
		msg = "상세 지시가 수정 되었습니다.";
		return msg;
				
	}
}
