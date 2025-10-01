package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.member.model.vo.Member;

@WebServlet("/delete.board")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardDeleteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long boardNo = Long.parseLong(request.getParameter("boardNo"));
		HttpSession session = request.getSession();
		Long userNo 
		= ((Member)session.getAttribute("userInfo")).getUserNo();
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardWriter(String.valueOf(userNo));
		System.out.println(board);
		int result = new BoardService().deleteBoard(board);
		
		if(result > 0) {
			
			response.sendRedirect(request.getContextPath() + "/boards?page=1");
			
		} else {
			// 35번 게시글 삭제 실패
			// 35번 게시글 상세조회 페이지로 보내고싶음
			// response.sendRedirect("/kh/detail.board?boardNo=35");
			response.sendRedirect(request.getContextPath() + "/detail.board?boardNo=" + boardNo);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
