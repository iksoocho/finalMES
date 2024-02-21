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
		
				out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@10'></script>");
				out.println("<script>");
				out.println("window.onload = function() {");
				out.println("    Swal.fire({");
				out.println("        icon: 'error',");
				out.println("        text: '" + message + "',");
				out.println("        confirmButtonText: 'OK'");
				out.println("    }).then((result) => {");
				out.println("        if (result.isConfirmed) {");
				out.println("            location.href = '/login';");
				out.println("        }");
				out.println("    });");
				out.println("}");
				out.println("</script>");
				out.flush();
			}
	

}
