package com.kh.el.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.vo.Person;

@WebServlet("/el.do")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ElServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 만약 서블릿에서 응답데이터가 존재했다면,
		// JSP로 포워딩할 때 request에 담아서 보내줬음! --> Servlet내장객체 / Scope객체
		
		// application / session / request / page
		
		/*
		 * 1. application scope : SevletContext
		 * 한 애플리케이션 당, 단 한 개 존재하는 객체
		 * 이 영역에 데이터를 담으면 애플리케이션 전역에서 사용 가능
		 * 
		 * 2. session scope     : HttpSession
		 * 하나의 브라우저 당, 한 개 존재하는 객체
		 * 이 영역에 데이터를 담으면 JSP/Servlet단에서 사용 가능
		 * 값이 한 번 담기면 서버를 멈추거나, 세션을 비우거나, 브라우저가 닫히기 전까지는 사용 가능
		 * 
		 * 3. request scope     : HttpServletRequest
		 * 요청 및 응답 시 매 번 생성되는 객체
		 * 이 영역에 데이터를 담으면 해당 request객체를 포워딩 받는 응답 JSP에서만 사용가능(1회성)
		 * 
		 * 4. page scope        : PageContext
		 * JSP페이지 내에서만 사용 가능
		 * 
		 * 
		 * => 위 객체들에 속성을 추가할 때는 .setAttribute("키", 밸류);	
		 * 							   .getAttribute("키");
		 * 							   .removeAttribute("키");
		 */
		
		// requestScope
		request.setAttribute("classRoom", "A강의장");
		request.setAttribute("student" , new Person("홍길동", 15, "한양"));
		
		// sessionScope
		HttpSession session = request.getSession();
		session.setAttribute("academy", "KH 아카데미");
		session.setAttribute("lecture", new Person("고길동", 40, "마포"));
		
		// request와 session에 동일한 키값으로 Attribute추가
		request.setAttribute("key", "request Key");
		session.setAttribute("key", "session Key");
		
		// DB에서 작업한 요청 처리결과
		
		// 숫자값
		request.setAttribute("small", 3);
		request.setAttribute("big", 10);
		
		// 문자열
		request.setAttribute("strOne", "안녕");
		request.setAttribute("strTwo", new String("안녕"));
		
		// 객체
		request.setAttribute("obj", new Person("콩쥐", 20, "콩쥐네집"));
		
		// 리스트
		request.setAttribute("list", new ArrayList());
		
		
		// 응답 뷰 배정 -> 포워딩
		request.getRequestDispatcher("/WEB-INF/views/01_el.jsp")
			   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
