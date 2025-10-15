package com.kh.java.member.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.common.Template;
import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.Member;

public class MemberService {
	
	private MemberDao md = new MemberDao();
	
	public Member login(Member member) {
		// 로그인 처리 -> DAO에 보내서 있나없네 -> 결과값 반환
		// validateMember(member); 비즈니스 로직
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = md.login(sqlSession, member);
		
		sqlSession.close();
		
		return loginMember;
	}
	
	public void validateMember(Member member) {
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
			return;
		}
		String pattern = "^[a-zA-Z0-9]{4,20}$";
		if(!member.getUserId().matches(pattern)) {
			return;
		}
		// 비밀번호 검증 로직
	}
	
	// 하이 사비스 ~
	// 아우 알차
	public int signUp(Member member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.signUp(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public int update(Map<String, String> map) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = md.update(session, map);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}
	
	public int delete(Member member) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = md.delete(session, member);
		
		if(result > 0) {
			session.commit();
		}
		session.close();
		
		return result;
	}
	
	public int updatePwd(Map<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.updatePwd(sqlSession, map);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		
		return result;
	}
	
	public String checkId(String id) {
		SqlSession sqlSession = Template.getSqlSession();
		
		String result = md.checkId(sqlSession, id);
		
		sqlSession.close();
		
		return result;
	}
	
	
	
	
	
	
	

}
