package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet("/ajax2.do")
public class AjaxController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 뽑기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Member member = new Member();
		member.setUserId(id);
		member.setUserPwd(pwd);
		
		Member loginMember = new MemberService().login(member);
		System.out.println(loginMember);
		String name = loginMember.getUserName();
		String email = loginMember.getEmail();
		/*
		response.setContentType("text/xml; charset=UTF-8");
		response.getWriter().print("<name>" + name + "</name>");
		response.getWriter().print("<email>" + email + "</email>");
		*/
		
		// AJAX를 활용하는데 실제 값을 여러 개 응답하고 싶음
		// JSON 형태로 데이터를 가공해서 앞단으로 응답해주기
		
		// 1. 배열
		// 2. 객체
		
		// [name, email]
		// ["홍길동2", "hong@kh.com"]
		// String responseData = "[\"" + name + "\",\"" + email + "\"]";
		// System.out.println(responseData);
		// response.setContentType("application/json; charset=UTF-8");
		// response.getWriter().print(responseData);
		/*
		 * 라이브러리를 사용해서 JSON형태의 데이터 만들기
		 * 
		 * 1. JSONArray
		 * 2. JSONObject
		 */
		JSONArray array = new JSONArray();
		// 요소를 추가
		array.add(name); // ["홍길동2"]
		array.add(email); // ["홍길동2", "hong@kh.com"]
		
		response.setContentType("application/json; charset=UTF-8");
		//response.getWriter().print(array);
		
		JSONObject obj = new JSONObject();
		// put()
		obj.put("name", name);
		obj.put("email", email);
		
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
