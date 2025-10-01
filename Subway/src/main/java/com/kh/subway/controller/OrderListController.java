package com.kh.subway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.service.SubwayService;
import com.kh.subway.model.vo.Subway;

@WebServlet("/orderList.sandwich")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GET? POST ?
		// a태그 요청 == 100% GET방식
		
		// 요청 시 전달값이 있는가?
		// String value = request.getParameter("value");
		// System.out.println(value);
		
		// 1) 데이터 가공 => X
		
		// 2) 요청처리 -> Service단 호출
		List<Subway> orderList = new SubwayService().findAll();
		
		// System.out.println(orderList);
		request.setAttribute("orders", orderList);
		
		request.getRequestDispatcher("/views/list.jsp")
			   .forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
