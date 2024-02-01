package com.example.demo.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.material.MatOrderVO;
import com.example.demo.material.service.MaterialService;

@Controller
public class MaterialController {

	@Autowired
	MaterialService materialService;
	

	@GetMapping("matOrder")
	public String getMatlist(Model model) {
		List<MatOrderVO> list = materialService.getMaterialOrderList();
		model.addAttribute("list", list);
		return "material/matOrder";
	}
	

}
