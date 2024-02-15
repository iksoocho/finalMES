package com.example.demo.bom.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bom.BomVO;
import com.example.demo.bom.service.BomService;
import com.example.demo.material.OriginMaterialVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class BomController {
	
	@Autowired
	BomService bomService;
	
	@GetMapping("/bom")
	public String ProdList(Model model) {
		model.addAttribute("Plist", bomService.ProdList());
		List<OriginMaterialVO> MaterialList = bomService.OriginMaterialList();
		model.addAttribute("Mlist", MaterialList);
		return "bom/bom";
	}
	
	@GetMapping("bomSeq")
	@ResponseBody
	public String bomSeq() {
		log.info("bomseq :" +bomService.bomSeq());
		String bomSeq =  String.valueOf(bomService.bomSeq());
		return bomSeq;
	}
	
	@PostMapping("/bomInsert")
	@ResponseBody
	public String bomInsert(@RequestBody List<BomVO> bomList) {
		String msg;
		bomService.bomInsert(bomList);
		msg = "bom 등록 완료";
		return msg;
	}
	
	@GetMapping("bomList")
	@ResponseBody
	public List<BomVO> bomList(@RequestParam String prodCode){
		return bomService.getBomList(prodCode);
	}
}

