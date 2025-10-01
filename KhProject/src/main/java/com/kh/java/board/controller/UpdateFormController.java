package com.kh.java.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Category;

@WebServlet("/updateForm.board")
public class UpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 시~원하게 해 보겠 읍 니다~~~~~~~~~ 수정하기 ~~
		// 자 일다 ㄴ슬랙에 수업자료 탭에서 update_form.html을 가져오시기 바랍니다 ~
		// /WEB-INF/views/board밑에다가 update_form.jsp를 만들고
		// 슬랙에서 받은걸 참고해서 잘 한 번 만들어보시기 바랍니다~ 예 ~ 오예 ~
		// 기회를 드리겠음 빨리해보셈 그리고 16일에 자리바꿀꺼니까
		// 짝꿍들하고 작별인사하셈 그동안 즐거웠어 흑흑 하셈 시간을 드리겠셈
		// 참고로 5인 1조셈 한조당 두 줄 먹는거셈 3명 앉고 2명 앉는거셈
		// 님들ㅇ ㅙ 작별인사안하셈? 사실 짝꿍이 별로였던거셈????
		
		//---------------------------------------------------------------
		// 우리는 지금 자바코드 다루는 중
		
		// 게시글 수정양식 보여주기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardService boardService = new BoardService();
		
		List<Category> category = boardService.selectCategory();
		Map<String, Object> map = boardService.selectBoard(boardNo);
		
		request.setAttribute("category", category);
		request.setAttribute("map", map);
		
		// 와 이거 중복코드 어쩌ㅣ?? 참을 수가없는걸?? 이걸 대체 어쩐담??
		// 이거 너무 없애고 싶다. 중복코드 제거해버리고 싶다. 아주 그냥 사라지게만들고싶다.
		request.getRequestDispatcher("/WEB-INF/views/board/update_form.jsp")
			   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
