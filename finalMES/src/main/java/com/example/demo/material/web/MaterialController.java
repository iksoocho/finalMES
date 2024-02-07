package com.example.demo.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.material.MatInputVO;
import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.MatOutputVO;
import com.example.demo.material.MatReturnVO;
import com.example.demo.material.OriginMaterialVO;
import com.example.demo.material.service.MaterialService;

@Controller
public class MaterialController {

	@Autowired
	MaterialService materialService;
	
	// 발주 조회
	@GetMapping("matOrder")
	public String getMaterialOrderList(Model model) {
		List<MatOrderVO> list = materialService.getMaterialOrderList();
		String code = null;
			if(!list.isEmpty()) {
				MatOrderVO firstMatVO = list.get(0);
				code = firstMatVO.getMatOrCode();
			}
		List<MatOrderInfoVO> mList = materialService.getMaterialOrdInfoList(code);
		List<OriginMaterialVO> oList = materialService.getOriginMaterialList();
		List<OriginMaterialVO> buisList = materialService.getMatBusiness();
		model.addAttribute("list", list);
		model.addAttribute("mList", mList);
		model.addAttribute("oList", oList);
		System.out.println("oList"+oList);
		model.addAttribute("buisList", buisList);
		return "material/matOrder";
	}
	
	
	// 발주 디테일
	@GetMapping("matDetail")
	@ResponseBody
	public List<MatOrderInfoVO> getMaterialOrdInfoList(@RequestParam String matCode){
		return materialService.getMaterialOrdInfoList(matCode);
	}
	
	
	// 자재 관리 조회
	@GetMapping("material")
	public String getOriginMatList(Model model) {
		List<OriginMaterialVO> matList = materialService.getOriginMaterialList1();
		model.addAttribute("matList",matList);
		return "material/material";
	}
	
	// 입고 관리 조회
	@GetMapping("matInput")
	public String getInputList(Model model) {
		List<MatInputVO> matInputList = materialService.getInputList();
		model.addAttribute("matInputList", matInputList);
		return "material/matInput";
	}
	
	// 출고 관리 조회
	@GetMapping("matOutput")
	public String getOutputList(Model model) {
		List<MatOutputVO> matOutList = materialService.getOutputList();
		System.out.println("아무것도 없나요? " + matOutList);
		model.addAttribute("matOutList" , matOutList);
		return "material/matOutput";
	}
	
	// 반품 관리 조회
	@GetMapping("matReturn")
	public String getReturnList(Model model) {
		List<MatReturnVO> matReList = materialService.getReturnList();
		System.out.println(matReList);
		model.addAttribute("matReList",matReList);
		return "material/matReturn";
	}
	
	//발주 등록
	@PostMapping("/matOrderInsert")
	public String insertMatOrder(@RequestBody MatOrderVO matOrderVO) {
	    System.out.println("통신성공");
	    
	    int result = materialService.insertMaterialOrder(matOrderVO);
	    
	    System.out.println("result: " + result);
	    
//	    if (result > 0) {
//	        model.addAttribute("message", "주문이 성공적으로 등록되었습니다.");
//	    } else {
//	        model.addAttribute("message", "주문 등록에 실패하였습니다.");
//	    }
	    
	    return "material/matOrder";
	}


}
