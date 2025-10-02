<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">

  <title>웹개발 시작하기</title>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="resources/css/agency.min.css" rel="stylesheet">
  <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
  
  <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
  <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
  
  
<!-- JavaScript -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/alertify.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/alertify.min.css"/>
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/default.min.css"/>
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/semantic.min.css"/>
<!-- Bootstrap theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/bootstrap.min.css"/>

<style>
    #mainNav .navbar-nav .nav-item .nav-link {
        font-weight: 600;
    }

    #sub-bg{
        width : 80%;
        margin : auto;
        height : 1200px;
        padding-top : 60px;
        padding-bottom : 60px;
        margin-top : 300px;
    }

    #sub-1{
        width : 70%;
        height : 40%;
        margin-right : auto;
        background-image: url(https://www.kh-academy.co.kr/resources/images/main/main_renewal/sub/sub02/educationinfo/jongro/04.jpg);
        background-size: cover;
        background-repeat: none;
    }

    #sub-2{
        margin-top : 120px;
        width : 70%;
        margin-left : auto;
        height : 40%;
        background-image: url(https://www.kh-academy.co.kr/resources/images/main/main_renewal/sub/sub02/educationinfo/jongro/05.jpg);
        background-size: cover;
        background-repeat: none;
    }

    footer{
        border-top: #52b1ff28 1px solid;
    }

    .dropdown:hover > .dropdown-menu { 
        display: block;  
    }
</style>


</head>

<body id="page-top">

  <c:if test="${ not empty alertMsg }">
	  <script>
	  		alertify.alert("KH화이팅!", "${ alertMsg }");
	  </script>
	  <c:remove var="alertMsg" scope="session" />
  </c:if>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="#">
      	<img class="img-fluid" src="https://www.kh-academy.co.kr/resources/images/main/logo.svg" alt="로고없음" style="width:130px; height:50px;" />
      </a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive">
        메뉴
        <i class="fas fa-bars"></i>
      </button>
      
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/kh">HOME</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#">공지사항</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/kh/boards?page=1">게시판</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/kh/images">사진게시판</a>
          </li>
          
          <!-- 
          	로그인 전 : 로그인 / 회원가입
          	로그인 후 : 내정보 / 로그아웃
          -->
          <%--<c:when> 얘는 여기 choose에 들어가면 안된다 --%>
          <c:choose>
          <c:when test="${ empty sessionScope.userInfo }">
          <li class="nav-item">
          <a class="nav-link js-scroll-trigger" data-toggle="modal" data-target="#log-in">로그인</a>
          </li>
          <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="join">회원가입</a>
          </li>
          </c:when>
          <c:otherwise>
          <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="myPage">내정보</a>
          </li>
          <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="logout" onclick="return confirm('진짜로 로그아웃 하려고?')">로그아웃</a>
          </li>
          </c:otherwise>
          </c:choose>
          
        </ul>
      </div>
    </div>
  </nav><br><br><br>
  
  	<script>
  	
  		const a = 2;
  		
  		if(a == 3){
	  <%
	  	// System.out.println("이거 왜 됨??");
	  %>
  		}
  	</script>
  
  

  <!-- 로그인 Modal-->
<div class="modal fade" id="log-in">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">
					<span style="color: #52b1ff;">KH</span> 로그인
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<form action="login" name="sign-in" method="post" id="signInForm"
					style="margin-bottom: 0;">
					<table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="userId" id="signInId"
								class="form-control tooltipstered" maxlength="10"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="최대 15자"></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="signInPw"
								name="userPwd" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="최소 8자"></td>
						</tr>
						<tr>
							<td style="padding-top: 10px; text-align: center">
								<p><strong>로그인하셔서 서비스를 이용해보세요~~!</strong></p>
							</td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;"><input
								type="submit" value="로그인" class="btn form-control tooltipstered" id="signIn-btn"
								style="background-color: #52b1ff; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>


</body>
</html>