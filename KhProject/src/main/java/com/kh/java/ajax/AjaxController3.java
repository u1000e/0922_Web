package com.kh.java.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.java.board.model.service.BoardService;

@WebServlet("/ajax3.do")
public class AjaxController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Object> board1 = new BoardService().selectBoard(1);
		Map<String, Object> board2 = new BoardService().selectBoard(2);
		Map<String, Object> board3 = new BoardService().selectBoard(3);
		
		List<Map<String, Object>> boards = new ArrayList();
		boards.add(board1);
		boards.add(board2);
		boards.add(board3);
		/*
		System.out.println(board1);
		JSONObject b1 = new JSONObject();
		b1.put("boardNo", ((Board)board1.get("board")).getBoardNo());
		b1.put("boardTitle", ((Board)board1.get("board")).getBoardTitle());
		b1.put("boardWriter", ((Board)board1.get("board")).getBoardWriter());
		Map<String, Object> board2 = new BoardService().selectBoard(2);
		JSONObject b2 = new JSONObject();
		b2.put
		JSONArray array = new JSONArray();
		array.add(b1);
		*/
		// Gson : Google이 만든 JSON라이브러리
		
		// Gson객체 생성후 toJson()를 호출
		Gson gson = new Gson();
		response.setContentType("application/json; charset=UTF-8");
		// response.getWriter().print(b1);
		// gson.toJson(응답할 객체, 응답용 스트림)
		// gson.toJson(board1, response.getWriter());
		// 자동으로 키값이 전달하는 객체의 속성명이 됨!
		
		// 객체 하나만 넘길 시 JSONObject형태로 만들어서 응답
		// List객체는 응답 시 JSONArray형태 안에 요소로 JSONObject를 만들어서 응답
		
		gson.toJson(boards, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
