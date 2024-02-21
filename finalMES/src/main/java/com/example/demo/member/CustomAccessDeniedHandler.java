package com.example.demo.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {
		// 여기서는 403 상태 코드를 설정합니다.
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("text/html;charset=UTF-8");
		// 클라이언트에게 자바스크립트를 실행하라는 지시를 합니다.
		// response.getWriter().print("<script>alert('권한이 없습니다');
		// window.history.back();</script>");
		response.getWriter().print(
			    "<script src='https://cdn.jsdelivr.net/npm/sweetalert2@10'></script>" +
			    "<script>" +
			    "window.onload = function() {" +
			    "    Swal.fire({" +
			    "        icon: 'error'," +
			    "        text: '권한이 없습니다.'" +
			    "    }).then(()=>{window.history.back()});" +
			    "}" +
			    "</script>"
			);
		//response.getWriter().print("<script>window.history.back();</script>");
	}
}