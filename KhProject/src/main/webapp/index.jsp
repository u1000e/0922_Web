<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웰컴웰컴</title>
</head>
<body>

	<!-- 
		* WEB환경에서의 CRUD
		
		* 회원서비스
		로그인/로그아웃*, 회원가입*(아이디중복체크*), 내정보조회(마이페이지)*, 내정보변경*,
		비밀번호변경*, 회원탈퇴*
		
		* 공지사항서비스 => 숙제
		공지사항 등록, 공지사항 목록조회, 공지사항 상세조회, 공지사항 수정, 공지사항 삭제
		
		* 일반게시판서비스
		게시글목록조회(페이징처리)*, 상세조회*, 게시글 작성(첨부파일 1개 업로드)*, 게시글 수정*
		, 게시글 삭제*, 댓글서비스*, 게시글 검색*
		
		* 사진게시판서비스
		사진게시글목록조회(이미지)*, 상세조회*, 게시글 작성(다중파일업로드)*
	-->
	<jsp:include page="WEB-INF/views/include/header.jsp" />
	<jsp:include page="WEB-INF/views/include/main.jsp" />
	<jsp:include page="WEB-INF/views/include/footer.jsp" />
	
</body>
</html>