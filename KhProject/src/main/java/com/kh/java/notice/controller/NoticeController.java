package com.kh.java.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeController {
	
	// 값뽑기
	// 가공
	// 요청처리
	// 응답화면 지정
	// private NoticeService ns = new NoticeService();
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("abc");
		int result = 0;
		if(result > 0) {
			return "/WEB-INF/views/notice/insert.jsp";
		}
		return "failPage";
	}
	public String select(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("abc");
		int result = 0;
		if(result > 0) {
			return "/WEB-INF/views/notice/update.jsp";
		}
		return "failPage";
		
	}

}
