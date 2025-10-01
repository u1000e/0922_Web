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

@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePwdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) POST -> 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 값뽑기
		String userPwd = request.getParameter("userPwd");
		String updatePwd = request.getParameter("changePwd");
		
		// 3) 식별할 수 있는 값이 필요함
		// UPDATE MEMBER SET USER_PWD = '새비밀번호'
		//  WHERE USER_PWD = '기존비밀번호'
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("userInfo");
		Long userNo = member.getUserNo();
		
		Map<String, String> map = 
				Map.of("userPwd", userPwd,
					   "updatePwd", updatePwd,
					   "userNo", String.valueOf(userNo));
		
		int result = new MemberService().updatePwd(map);
		if(result > 0) {
			member.setUserPwd(updatePwd);
		}
		
		session.setAttribute("alertMsg", 
				result > 0 ? "변경 성공 ~ " : "변경 실패...");
		
		// 성공이든 실패든 마이페이지로 응답
		response.sendRedirect(request.getContextPath() + "/myPage");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
