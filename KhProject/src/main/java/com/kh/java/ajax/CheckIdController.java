package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.member.model.service.MemberService;

@WebServlet("/checkId")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 앞에서 AJAX요청을 통해 넘어온 사용자가 입력한 문자열 데이터를
		// DB까지가서 KH_MEMBER테이블에 USER_ID컬럼에 있는값인가 없는값인가 조회를 해보고
		// 조회결과를 다시 앞단으로 응답해주기
		String id = request.getParameter("id");
		// System.out.println(id);
		
		// SQL문을 어떻게 쓸까?
		// NNNNN
		// NNNNY
		
		String result = new MemberService().checkId(id);
		// System.out.println(result);
		
		// 1) 응답데이터가 뭔데이터인지
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
