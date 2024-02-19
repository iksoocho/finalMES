package com.example.demo.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/myPage").setViewName("inform/myPage");
		

		// 영업관리
		registry.addViewController("/orderInsert").setViewName("sales/orderInsert");
		registry.addViewController("/orderList").setViewName("sales/orderList");
		registry.addViewController("/inOutManage").setViewName("sales/inOutManage");
		registry.addViewController("/inOutList").setViewName("sales/inOutList");
		
		
		// 설비파트
		registry.addViewController("/facManagement").setViewName("facility/facManagement");
		registry.addViewController("/facNotop").setViewName("facility/facNotop");
		registry.addViewController("/facIns").setViewName("facility/facIns");
		registry.addViewController("/facRep").setViewName("facility/facRep");

		// asdasdsadfgadfgasdfg
		
		
		//생산
		registry.addViewController("/planManage").setViewName("produce/planManage");
		registry.addViewController("/planOrder").setViewName("produce/planOrder");


	}

}
