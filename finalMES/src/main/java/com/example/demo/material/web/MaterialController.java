package com.example.demo.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.service.MaterialService;

@Controller
public class MaterialController {

	@Autowired
	MaterialService materialService;
	
	// 발주 조회
	@GetMapping("matOrder")
	public String getMatlist(Model model) {
		List<MatOrderVO> list = materialService.getMaterialOrderList();
		String code = null;
			if(!list.isEmpty()) {
				MatOrderVO firstMatVO = list.get(0);
				code = firstMatVO.getMatOrCode();
			}
		List<MatOrderInfoVO> mList = materialService.getMaterialOrdInfoList(code);
		model.addAttribute("list", list);
		model.addAttribute("mList", mList);
		return "material/matOrder";
	}
	
	//발주 등록
	@PostMapping("matOrderInsert")
	public String insertMatOrder(Model model, @RequestBody MatOrderVO matOrderVO) {
	    System.out.println("통신성공");
	    
	    int result = materialService.insertMaterialOrder(matOrderVO);
	    
	    System.out.println("result: " + result);
	    
	    if (result > 0) {
	        model.addAttribute("message", "주문이 성공적으로 등록되었습니다.");
	    } else {
	        model.addAttribute("message", "주문 등록에 실패하였습니다.");
	    }
	    
	    return "material/matOrder";
	}


}
