package com.kh.java.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.notice")
public class NoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("앞이 뭐로 시작하든 notice로 끝나면 출동");
		
		String uri = request.getRequestURI();
		// System.out.println(uri);
		String mapping = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		System.out.println(mapping);
		
		NoticeController nc = new NoticeController();
		String view = "";
		
		switch(mapping) {
		case "insert" : view = nc.insert(request, response);
		case "select" : view = nc.select(request, response);
		}
		
		// 오늘의 숙제 -> 내일까지
		// AJAX로 테이블에다가 INSERT, SELECT구현해보기 -> Notice
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
