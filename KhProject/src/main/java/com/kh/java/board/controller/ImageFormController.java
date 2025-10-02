package com.kh.java.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.image")
public class ImageFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저기로 포워딩해보셈 ㅋㅋ
		request.getRequestDispatcher("/WEB-INF/views/image_board/enroll_form.jsp")
			   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
