package com.example.demo.material.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.material.mapper.MaterialMapper;



@Controller
public class MaterialController {
	
	@Autowired
	MaterialMapper materialMapper;
	
	
	   @GetMapping("/matOrder")
	   public String list(Model model) {
	   model.addAttribute("list", materialMapper.getMatList(null));
	    return "material/matOrder"; 
	   }
	 
	

}
