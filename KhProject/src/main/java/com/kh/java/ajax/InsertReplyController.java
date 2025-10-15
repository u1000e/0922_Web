package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Reply;
import com.kh.java.member.model.vo.Member;

@WebServlet("/insert.reply")
public class InsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertReplyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST => 인코딩
		// request.setCharacterEncoding("UTF-8");
		
		// request로부터 값뽑기
		Long boardNo = Long.parseLong(request.getParameter("boardNo"));
		String content = request.getParameter("replyContent");
		
		// session에서 뽑기
		Long userNo = ((Member)request.getSession().getAttribute("userInfo"))
									  .getUserNo();
		
		// 데이터 가공
		Reply reply = new Reply();
		reply.setRefBno(boardNo);
		reply.setReplyContent(content);
		reply.setReplyWriter(String.valueOf(userNo));
		
		// Service로 요청
		int result = new BoardService().insertReply(reply);
		
		// success / fail
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result > 0 ? "success" : "fail");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
