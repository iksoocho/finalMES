package com.example.demo.sales.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SalesController {

	@RequestMapping("/manager")
	public String showManagerListModal(Model model) {
		// 모델에 필요한 데이터를 추가한다면 여기서 처리합니다.
		List<String> managerList = new ArrayList<>();
		managerList.add("John");
		managerList.add("Lisa");
		managerList.add("David");

		model.addAttribute("managerList", managerList);
		return "common/managerListModal";
	}
}
