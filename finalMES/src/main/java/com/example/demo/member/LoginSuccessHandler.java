package com.example.demo.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,  
			Authentication authentication) throws IOException, ServletException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		UserDetailVO userDetailVO = (UserDetailVO) authentication.getPrincipal();
		
		HttpSession session = request.getSession();
		session.setAttribute("userCode", userDetailVO.getUserid()); // 아이디
		session.setAttribute("userGrade", userDetailVO.getAuthorities()); // 권한
		session.setAttribute("userName", userDetailVO.getUsername()); // 이름
		
		
		response.sendRedirect("/");
	}

}
