<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실패용 페이지</title>
<style>
	h1{
		color : red;
		font-size : 64px;
		text-align : center;
		height : 600px;
		line-height : 600px;
	}
</style>
</head>
<body>

	<jsp:include page="../include/header.jsp" />

	<h1>${ msg }</h1>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>