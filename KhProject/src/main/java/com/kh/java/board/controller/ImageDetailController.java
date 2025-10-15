package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.dto.BoardDto;
import com.kh.java.board.model.service.BoardService;

@WebServlet("/detail.image")
public class ImageDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String boardNo = request.getParameter("boardNo");
		//if(boardNo != null || !boardNo.isEmpty()) {
		//	Long num = Long.parseLong(boardNo);
		//}
		Long num = Long.parseLong(request.getParameter("boardNo"));
		
		BoardDto board = new BoardService().selectImageDetail(num);
		// System.out.println(map);
		
		
		if(board != null) {
			request.setAttribute("board", board);
			request.getRequestDispatcher("/WEB-INF/views/image_board/detail.jsp")
				   .forward(request, response);
		} else {
			request.setAttribute("msg", "게시글 조회 실패..");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp")
				   .forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
