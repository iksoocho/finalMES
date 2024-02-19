package com.example.demo.material.web;

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

import com.example.demo.material.BadMatVO;
import com.example.demo.material.MatInputVO;
import com.example.demo.material.MatInspectionVO;
import com.example.demo.material.MatOrderCompositeVO;
import com.example.demo.material.MatOrderInfoVO;
import com.example.demo.material.MatOrderVO;
import com.example.demo.material.MatOutputVO;
import com.example.demo.material.MatReturnVO;
import com.example.demo.material.OriginMaterialVO;
import com.example.demo.material.service.MaterialService;

/**
 * '자재관리 페이지에서 담당하는 기능(발주,입고,출고,반품)'
 * 
 * @author 강현진
 * 
 */
@Controller
public class MaterialController {

	@Autowired
	MaterialService materialService;

	/**
	 * 
	 * @param 발주 리스트 정보
	 * @return 발주관리 페이지
	 */
	// 발주 조회
	@GetMapping("matOrder")
	public String getMaterialOrderList(Model model) {
		// 발주 내역
		List<MatOrderInfoVO> mList = materialService.getMaterialOrdInfoList();
		// 자재 리스트
		List<OriginMaterialVO> oList = materialService.getOriginMaterialList();

		model.addAttribute("mList", mList);
		model.addAttribute("oList", oList);
		return "material/matOrder";
	}

	/**
	 * 
	 * @param 데이터 불러오기 그리드사용
	 * @return 거래처 목록 불러오기
	 */
	// 발주 거래처 불러오기
	@GetMapping("/matBusinessList")
	@ResponseBody
	public List<MatOrderInfoVO> getBusinessList(@RequestParam String matCode) {
		return materialService.getMaterialOrdInfoList1(matCode);
	}

	/**
	 * 
	 * @param 미사용
	 * @return
	 */
//	@GetMapping("matDetail")
//	@ResponseBody
//	public List<MatOrderInfoVO> getMaterialOrdInfoList(@RequestParam String matCode) {
//		return materialService.getMaterialOrdInfoList(matCode);
//	}


	/**
	 * 
	 * @param 자재 관리 조회
	 * @return 자재관리 페이지
	 */
	// 자재 관리 조회
	@GetMapping("material")
	public String getOriginMatList(Model model) {
		List<OriginMaterialVO> matList = materialService.getOriginMaterialList1();
		model.addAttribute("matList", matList);
		return "material/material";
	}

	/**
	 * 
	 * @param
	 * @return 입고관리 페이지
	 */
	// 입고 관리 조회
	@GetMapping("matInput")
	public String getInputList(Model model) {
		List<MatInputVO> matInputList = materialService.getInputList();
		List<MatInspectionVO> matInsList = materialService.getMatInsList();
		model.addAttribute("matInputList", matInputList);
		model.addAttribute("matInsList", matInsList);
		return "material/matInput";
	}
	
	/**
	 * 
	 * @param 검수페이지
	 * @return
	 */
	@GetMapping("matIns")
	public String getInsList(Model model) {
		List<BadMatVO> badMatList = materialService.getBadMatList();
		List<MatInspectionVO> matInsList = materialService.getMatInsList();
		model.addAttribute("badMatList", badMatList);
		model.addAttribute("matInsList", matInsList);
		return "material/matIns";
	}
	
	/**
	 * 
	 * @return 검수 불량명 뿌려주는 기능
	 */
    @GetMapping("/getBadMatList")
    public List<BadMatVO> getBadMatList() {
        return materialService.getBadMatList();
    }

	/**
	 * 
	 * @param
	 * @return 출고 관리 페이지
	 */
	// 출고 관리 조회
	@GetMapping("matOutput")
	public String getOutputList(Model model) {
		List<MatOutputVO> matOutList = materialService.getOutputList();
		System.out.println("아무것도 없나요? " + matOutList);
		model.addAttribute("matOutList", matOutList);
		return "material/matOutput";
	}

	/**
	 * 
	 * @param
	 * @return 반품 관리 페이지
	 */
	// 반품 관리 조회
	@GetMapping("matReturn")
	public String getReturnList(Model model) {
		List<MatReturnVO> matReList = materialService.getReturnList();
		System.out.println(matReList);
		model.addAttribute("matReList", matReList);
		return "material/matReturn";
	}

	/**
	 * 
	 * @param
	 * @return 발주등록
	 */
	// 발주 등록
//	@PostMapping("/matOrderInsert")
//	@ResponseBody
//	public String insertMatOrder(@RequestBody MatOrderCompositeVO matOrderCompositeVO) {
//		String msg;
//		materialService.insertMaterialOrder(matOrderCompositeVO);
//		
//		msg = "발주완료";
//		return msg;
//	}
	
	// 발주 등록
	@PostMapping("/matOrderInsert")
	@ResponseBody
	public String insertMatOrder(@RequestBody MatOrderVO matOrderVO) {
		String msg;
		materialService.insertMatOrder(matOrderVO);
		
		msg = "발주완료";
		return msg;
	}

	/**
	 * 
	 * @param
	 * @return 발주 수정(업데이트)
	 */
	@PutMapping("/matUpdate")
	@ResponseBody
	public String updateMatOrder(@RequestBody MatOrderCompositeVO matOrderCompositeVO) {
		String msg;
		materialService.updateMatOrder(matOrderCompositeVO);
		msg = "발주 목록을 수정하였습니다.";
		return msg;
	}

	/**
	 * 
	 * @param
	 * @return 발주 삭제
	 */
	@DeleteMapping("/matDelete")
	@ResponseBody
	public String deleteMatOrder(@RequestBody MatOrderCompositeVO matOrderCompositeVO) {
		String msg;
		materialService.deleteMatOrder(matOrderCompositeVO);
		msg = "발주가 목록에서 삭제되었습니다.";
		return msg;
	}
	
	/**
	 * @param 입고 전 검수 하는 곳
	 * @return 검수 인서트
	 */
	@PostMapping("/MatInsInsert")
	@ResponseBody
	public String MatInsInsert(@RequestBody MatInspectionVO matInspectionVO) {
		String msg;
		materialService.insertMatIns(matInspectionVO);
		msg = "검사가 완료되었습니다";
		return msg;
	}
	
	@PostMapping("matInputInsert")
	@ResponseBody
	public String matInputInsert(@RequestBody MatInputVO matInputVO) {
		String msg;
		materialService.matInputInsert(matInputVO);
		msg = "입고가 완료되었습니다";
		return msg;
		
	}

		
	
	

}
