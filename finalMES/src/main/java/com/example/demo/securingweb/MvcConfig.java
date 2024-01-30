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
		registry.addViewController("/empList").setViewName("emp/empList");

		// 영업관리
		registry.addViewController("/orderInsert").setViewName("sales/orderInsert");
		registry.addViewController("/orderList").setViewName("sales/orderList");
		registry.addViewController("/management").setViewName("facility/management");
		// asdasdsadfgadfgasdfg

	}

}
