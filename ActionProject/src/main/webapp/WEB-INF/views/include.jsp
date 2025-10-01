<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인크루드~~</title>
</head>
<body>

	<h1>include</h1>
	
	<p>
		다른 페이지를 포함할 때 사용
	</p>
	
	<%-- 
	<%@ include file="footer.jsp" %>
	<%@ include file="footer.jsp" %>
	--%>
	
	
	<h4>JSP표준 액션 태그를 이용한 방식 (동적 include)</h4>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- 
		XML기반기술이기 때문에 반드시 시작태그와 종료태그가 쌍으로 존재해야함!!!
		닫는 태그를 작성하지 않는다면 500에러 발생!!
	-->
	
	<jsp:include page="footer.jsp" />
	<jsp:include page="footer.jsp" />
	<jsp:include page="footer.jsp" />
	<jsp:include page="footer.jsp" />
	<jsp:include page="footer.jsp" />
	<jsp:include page="footer.jsp" />
	<jsp:include page="footer.jsp" />
	
	<hr>
	
	<!-- name은 내맘대로 밸류ㅠ도 내맘대로 -->
	<!-- Content영역에 주석넣지않기! -->
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Hi" />
	</jsp:include>
	
	<br>
	
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Bye" />
	</jsp:include>
	
	


	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	Copyright © 1998-2026 KH Information Educational Institute All Right Reserved
</body>
</html>