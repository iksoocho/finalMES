package com.example.demo.facility.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.facility.mapper.FacilityMapper;

@Controller
public class facilityController {
	
	@Autowired
	FacilityMapper facMapper;

	/*
	 * @GetMapping("/facList")
	 * public String list(Model model) {
	 * model.addAttribute("list", facMapper.getfacList(null));
	 *  return "facility/facList"; 
	 * }
	 */
 }
