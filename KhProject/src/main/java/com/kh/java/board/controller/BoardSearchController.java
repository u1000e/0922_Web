package com.kh.java.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.vo.PageInfo;

@WebServlet("/search.board")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자가 선택한 옵션과 사용자가 입력한 키워드를 가지고
		// DB상에서 검색해서 나온 조회 결과를
		// 페이징처리까지 끝내서 들고 갈 것
		
		String condition = request.getParameter("condition");
		// "writer", "title", "content"
		String keyword = request.getParameter("query");
		// 사용자가 입력한 값
		
		Map<String, Object> map = new HashMap();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		int listCount = new BoardService().searchedCount(map);
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageLimit = 5;
		int boardLimit = 5;
		int maxPage = (int)(Math.ceil((double)listCount / boardLimit));
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		int offset = (currentPage - 1) * boardLimit;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 아 이거 중복코드.. 아 이거 책임분리 아 이거... 아으아아아아ㅏ아!!!
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,
								   boardLimit, startPage, endPage,
								   maxPage, offset);
		
		map.put("offset", offset);
		map.put("limit", boardLimit);
		
		List<Board> boards = new BoardService().selectSearchList(map);
		
		request.setAttribute("boards", boards);
		request.setAttribute("pi", pi);
		request.setAttribute("keyword", keyword);
		request.setAttribute("condition", condition);
		
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp")
			   .forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
