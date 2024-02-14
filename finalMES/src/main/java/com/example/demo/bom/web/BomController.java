package com.example.demo.bom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.bom.service.BomService;

@Controller
public class BomController {
	
	@Autowired
	BomService bomService;
	
	@GetMapping("/bom")
	public String ProdList(Model model) {
		model.addAttribute("Plist", bomService.ProdList());
		return "bom/bom";
	}
}		

