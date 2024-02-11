package com.example.demo.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service
public class FailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
		
				String message = "";
				
				

		
				// 아이디 x
				if (exception instanceof UsernameNotFoundException) {
					message = "아이디가 틀렸습니다.";
				}
				// 비밀번호 오류
				else if (exception instanceof BadCredentialsException) {
					message = "비밀번호가 틀렸습니다.";
				}
		
				out.println("<script language='javascript'>");
				out.println("alert('" + message + "'); location.href='/login';");
				out.println("</script>");
				out.flush();
			}
	

}