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
import com.example.demo.produce.MatUseVO;
import com.example.demo.produce.WorkMidRegistVO;
import com.example.demo.produce.service.WorkService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class WorkController {
	
	@Autowired
	WorkService workService;
	
	@GetMapping("facList")
	@ResponseBody
	public List<FacCateVO> selectedFacList(@RequestParam String procCode) {
		log.debug("FacList");
		return workService.getFacSelect(procCode);
	}
	
	@PostMapping("/workMidInsert")
	@ResponseBody
	public String insertWorkMid(@RequestBody WorkMidRegistVO workMidVO) {
		System.out.println("==========================midinsert==============================");
		System.out.println(workMidVO);
		System.out.println("=================================================================");
//		String dInsCode = workMidVO.getDInsCode();
//		String procCode = workMidVO.getProcCode();
		
//		List<MatUseVO> vo = workService.checkMatUse(dInsCode, procCode);
//		if(!vo.isEmpty()) {
//			for (MatUseVO matUseVO : vo) {
//		        int inputValue = matUseVO.getMatTotalCon();
//		        String inputMatCode = matUseVO.getMatCode();
//		        int result = workService.updateMatLot(inputValue, inputMatCode);
//		        if(result == 1) {
//					System.out.println("컨트롤러 - 자재소모 성공");
//				}else {
//					System.out.println("컨트롤러 - 자재소모 실패");
//				}
//			}
//		}
		
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
		System.out.println("==========================midupdate==============================");
		System.out.println(workMidVO);
		System.out.println("=================================================================");
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
	
	@PostMapping("/workResultInsert")
	@ResponseBody
	public String insertWorkResult(@RequestBody String dinsCode) {
		System.out.println("=======================co.resultinsert===========================");
		System.out.println(dinsCode);
		System.out.println("=================================================================");
		int result = workService.insertWorkResult(dinsCode);
		String msg;
		if(result == 1) {
			msg = "공정실적 등록성공";
		}else {
			msg = "공정실적 등록실패";
		}
        return msg;
	}
	
	@PutMapping("/insStateUpdate")
	@ResponseBody
	public void updateInsState(@RequestBody MatUseVO matuseVO) {
		String dinsCode = matuseVO.getMatCode();
		String procCode = matuseVO.getProcCode();
		List<MatUseVO> vo = workService.checkMatUse(dinsCode, procCode);
		if(!vo.isEmpty()) {
			for (MatUseVO matUseVO : vo) {
		        int inputValue = matUseVO.getMatTotalCon();
		        String inputMatCode = matUseVO.getMatCode();
		        int result = workService.updateMatLot(inputValue, inputMatCode);
		        if(result == 1) {
					System.out.println("컨트롤러 - 자재소모 성공");
				}else {
					System.out.println("컨트롤러 - 자재소모 실패");
				}
			}
		}
		
		int result = workService.updateProdInsState(dinsCode);
		String msg;
		if(result == 1) {
			msg = "CONTROL 생산지시 상태변경 성공";
		}else {
			msg = "CONTROL 생산지시 상태변경 실패";
		}
		System.out.println(msg);
	}
	
	@PutMapping("/ordStateUpdate")
	@ResponseBody
	public void updateOrdState(@RequestBody String dinsCode) {
		int result = workService.updateOrdListState(dinsCode);
		String msg;
		if(result == 1) {
			msg = "CONTROL 주문서 상태변경 성공";
		}else {
			msg = "CONTROL 주문서 상태변경 실패";
		}
		System.out.println(msg);
	}

}
