<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> 
	.list-area{
		text-align : center;
	}

	.thumbnail{
		box-shadow : 1px 1px 2px #0000002e;
		width : 300px;
		padding : 12px;
		margin : 25px;
		display : inline-block;
		background-color: #ffffffb0;
		color:#000000b0;
		font-weight: bold;
		border-radius: 12px;
	}

	.thumbnail > img{
		width : 270px;
		height : 180px;
		margin-bottom : 8px;
		border : 1px solid rgb(172 205 255 / 57%);
		border-radius: 12px;
	}

	.thumbnail:hover{
		cursor:pointer;
		opacity:0.8;
	}


</style>
</head>
<body>

	<jsp:include page="../include/header.jsp" />
	
	<div class="outer">
		
		<div style="margin-top : 15px; width : 400px; height : 280px; margin:auto;">
			<img width="100%" height="100%" src="https://kh-academy.co.kr/resources/images/main/logo.svg" alt="">
		</div>
		
			<div style="align:right;" >
				<a class="btn btn-sm btn-primary"
				   style="background:rgb(193 229 255); border:none; width:100%"
				   href="form.image"
				>글작성</a>
			</div>

		<div class="list-area">
			
			<br>
				
			<c:choose>
			<c:when test="${ empty boards }">
				등록된 게시글이 존재하지 않습니다.<br>
			</c:when>
			<c:otherwise>
			<c:forEach items="${ boards }" var="board">
			<div id="${ board.boardNo }" class="thumbnail" align="center" onclick="detail(this.id);">
				<img src="${ board.filePath }/${ board.changeName }" alt="대표이미지">
				<p>
					<label>No. ${ board.boardNo }</label> / <span>${ board.boardTitle }</span> <br>
					<label>조회수</label> : <span>${ board.count }</span>
				</p>
			</div>
			</c:forEach>
			</c:otherwise>
			</c:choose>
		</div>
		
		<script>
		
			function detail(num){
				// 클릭했을 때 => URL로 요청
				// location.href
				// detail.image?boardNo=
				location.href = `detail.image?boardNo=\${num}`;
			};		
		
		</script>
	
	</div>
	
	<jsp:include page="../include/footer.jsp" />


</body>
</html>