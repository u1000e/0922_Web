<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>딸깍</title>
<style>
	form {
		width : 90%;
		margin : auto;
	}
</style>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	
	<c:if test="${ userInfo eq null }">
		<script>
			alert("글작성은 로그인 이후 가능합니다.");
			location.href = '/kh';
		</script>
	</c:if>

	<div class="outer">

        <h2 align="center">게시글 작성하기</h2>
        <br><br> 
		
        <form action="insert.board" method="post" id="insert-form"
        	  enctype="multipart/form-data">
       	<!-- 파일첨부요청을 보낼 때 form태그에 반드시
       		enctype="multipart/form-data" 라고 적혀있어야함
       	 -->
        
        	<div class="form-group">
	        	<select name="category" class="form-control">
	        	
	        		<c:forEach items="${category}" var="c">
	                    <option value="${ c.categoryNo }">
	                        ${ c.categoryName }
	                    </option>
                    </c:forEach>
                    
	        	</select>
        	</div>

            <div class="form-group">
                <label for="usr">제목</label>
                <input type="text" class="form-control" id="usr" name="title">
            </div>

            <div class="form-group">
                <label for="comment">내용</label>
                <textarea class="form-control" name="content" rows="15" id="comment" style="resize:none;"></textarea>
            </div>
            
            <div class="form-group">
            	<input type="file" name="upfile">
            </div>

            <div align="center">
                <button type="submit" class="btn btn-sm btn-info">등록하기</button>
                <button type="button" class="btn btn-sm btn-secondary"
                onclick="history.back();">뒤로가기</button>
            </div>

        </form>
        
    </div>
    
    <jsp:include page="../include/footer.jsp" />

</body>
</html>