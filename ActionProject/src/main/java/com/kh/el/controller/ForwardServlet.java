package com.kh.el.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward.do")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForwardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 포워딩해서 forward.jsp가 응답되게하기
		request.getRequestDispatcher("/WEB-INF/views/forward.jsp")
			   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
