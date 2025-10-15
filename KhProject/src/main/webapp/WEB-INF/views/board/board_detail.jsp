<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<br/><br/>

	<jsp:include page="../include/header.jsp" />
	
	<div class="outer">
		<div class="container">
		
		<div class="row">
		  <div class="offset-lg-2 col-lg-8">
		    <div class="card">
		      <div class="card-header text-white" style="background-color: #52b1ff;">${ map.board.boardNo }번 게시물 내용</div>
		      <div class="card-body"> 
		
		          <div class="form-group">
		            <label>카테고리</label><br>
		            <span>${ map.board.category }</span>
		          </div>      
		        
		          <div class="form-group">
		            <label>작성자</label>
		            <input type="text" class="form-control" name='writer' value="${ map.board.boardWriter }" readonly>
		          </div>
		          
		          <div class="form-group">
		            <label>제목</label>
		            <input type="text" class="form-control" name='title' value="${ map.board.boardTitle }" readonly>
		          </div>
		
		          <div class="form-group">
		            <label>내용</label>
		            <textarea class="form-control" rows="5" name='content' readonly style="resize:none;">${ map.board.boardContent }</textarea>
		          </div>
		
		          <div class="form-group">
		            <label>첨부파일</label>

					<c:choose>
						<c:when test="${ map.at ne null }">
<!-- 
localhost:4000/kh/resources/board_upfiles/KHacademy_20250930172348_627.jpg
 -->
			            	<!-- 첨부파일은 있을수도있음 -->
			            	<a 
			            	download="${ map.at.originName }"
			            	href="${ map.at.filePath }/${ map.at.changeName}"
			            	>${ map.at.originName }</a><br>
			            	
			            	<img src="${ map.at.filePath }/${ map.at.changeName }" width="360" height="240"/>
						</c:when>
						<c:otherwise>
			            	<!-- 첨부파일은 없을수도있음 -->
			            	&nbsp;&nbsp;<span>첨부파일이 존재하지 않습니다.</span>
			            </c:otherwise>
			      </c:choose>
		          </div>
		         
		          <a class="btn" href="boards?currentPage=1"
		             style="background-color: #52b1ff; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"
		          >목록</a>&nbsp;&nbsp;
		          
		          <!-- 
		          	버튼 두 개를 게시글 작성자만 볼 수 있게 하고 싶음
		          	사용자의 식별 : MEMBER -> PK(USER_NO), UNIQUE(USER_ID)
		          -->
		          
		          	<c:if test="${ userInfo.userNo eq map.boardWriter }">
			          <a 
			            class="btn" 
			            href="updateForm.board?boardNo=${ map.board.boardNo }"
			      		style="background-color: orange; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"
			      		>수정</a>&nbsp;&nbsp;
			          
			          <a 
			            class="btn" 
			            href="delete.board?boardNo=${ map.board.boardNo }" onclick="return confirm('정말로 삭제하시겠습니까?')"
			      		style="background-color: red; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8"
			      		>삭제</a>&nbsp;&nbsp;
					</c:if>
		      </div>
		    </div>
		  </div>
		</div>
		</div>
		<div id="reply-area">
			
			<table class="form-group" align="center">
				<thead>
					<tr>
						<th>댓글작성</th>
						
							<c:choose>
							<c:when test="${ sessionScope.userInfo ne null }">
							<td>
								<textarea id="replyContent" cols="50" rows="3" style="resize:none;" class="form-control"></textarea>
							</td>
							<td><button onclick="insertReply();" class="btn" style="width : 100%; height : 100%; background-color: #52b1ff; color : white;">댓글등록</button></td>
							</c:when>
							<c:otherwise>
							<td>
								<textarea readonly cols="50" rows="3" style="resize:none;" class="form-control">로그인 후 이용가능한 서비스입니다.</textarea>
							</td>
							<td><button class="btn" style="width : 100%; height : 100%; background-color: #52b1ff; color : white;">댓글등록</button></td>
							</c:otherwise>
							</c:choose>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<br><br><br><br>
	    </div>

	</div>
	
	<script>
		function insertReply(){
			// 댓글작성 요청 -> KH_REPLY 한 행 INSERT
			// 게시글번호, 댓글 내용, 작성자 번호
			
			const content = $("#replyContent").val();
			
			$.ajax({
				url : "insert.reply",
				type : "POST",
				data : {
					replyContent : content,
					boardNo : ${map.board.boardNo}
				},
				success : function(result){
					//console.log(result);
					
					if(result === 'success'){
						$('#replyContent').val('');
						selectReply();
					}
				}
			});
		}
		
		$(function(){
			selectReply();
		})
		
		function selectReply(){
			
			$.ajax({
				url : "list.reply",
				type : "get",
				data : {
					boardNo : ${map.board.boardNo}
				},
				success : function(result){
					// console.log(result);
					
					const str = result.map(e => `
												<tr>
													<td>\${e.replyWriter}</td>
													<td>\${e.replyContent}</td>
													<td>\${e.createDate}</td>
												</tr>
											   `).join('');
					
					$('tbody').html(str);
				}
			});
		}
	
	</script>
	
	<jsp:include page="../include/footer.jsp" />
	

	
	
</body>
</html>