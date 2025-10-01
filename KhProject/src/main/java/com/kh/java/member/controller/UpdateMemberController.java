package com.kh.java.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet("/update.me")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) GET ? POST ?
		// POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달 값 뽑기
		// userName, email
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		
		// 2_2) 세션에서 값 뽑기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("userInfo");
		Long userNo = member.getUserNo();
		
		// Long l = ((Member)session.getAttribute("userInfo"))
		// 					        .getUserNo();
		
		
		// 3) 어따담기
		/*
		Map<String, String> map = new HashMap();
		map.put("userName", userName);
		map.put("email", email);
		
		Map.of() : K-V 10개까지 초기화 가능
				   불변맵 반환
		*/
		Map<String, String> map = Map.of(
								  "userName", userName,
								  "email", email,
								  "userNo", String.valueOf(userNo));
		// System.out.println(map);
		// System.out.println(request.getParameter("userId"));
		
		// 4) 요청처리 -> Service
		// 개발자 == 자격 X
		int result = new MemberService().update(map);
		
		// 5) 결과값에 따라서 응답화면 지정
		if(result > 0) {
			
			// 우리에게 생긴 문제점
			
			// Update에 성공했는데
			// session의 userInfo키 값에는
			// 로그인 당시 / 마이페이지 포워딩 당시 조회했던
			// 값들이 필드에 담겨 있기 때문에
			// Update 수행 전 값들이 마이페이지에서 출력됨
			
			// 목표 => DB가서 갱신된 회원정보 들고오기
			//     => 들고온 회원정보 userInfo로 덮어씌우기
			
			/*
			Member loginInfo = new MemberService().login(member);
			session.setAttribute("userInfo", loginInfo);
			request.getRequestDispatcher("/WEB-INF/views/member/my_page.jsp")
				   .forward(request, response);
			*/
			// sendRedirect
			// /kh/myPage
			session.setAttribute("alertMsg", "정보 변경 성공!");
			response.sendRedirect(request.getContextPath() + "/myPage");
			
		} else {
			request.setAttribute("msg", "정보 수정에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/fail_page.jsp")
				   .forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
