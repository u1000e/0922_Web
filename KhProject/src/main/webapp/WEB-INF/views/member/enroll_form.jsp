<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#hobby-wrap{
	    display: flex;
	    justify-content: center;
	    flex-direction: row;
	    flex-wrap: nowrap;
	    align-items: baseline;
	}
	input[type=checkbox]{
		margin-left : 50px;
	}
</style>
</head>
<body>

	<jsp:include page="../include/header.jsp" />
	
	<div style="width : 80%; margin : auto; padding : 50px;">
		<form action="members" name="signup" id="signUpForm" method="post"
						style="margin-bottom: 0;">
			<table
				style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
				<tr>
					<td style="text-align: left">
						<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idChk"></span></p>
					</td>							
				</tr>
				<tr>
					<td><input type="text" name="userId" id="user_id"
						class="form-control tooltipstered" maxlength="14"
						required="required" aria-required="true"
						style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
						placeholder="숫자와 영어로 4-30자">
						</td>
					
				</tr>
				<tr>
					<td style="text-align: left">
						<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk"></span></p>
					</td>
				</tr>
				<tr>
					<td><input type="password" size="17" maxlength="30" id="password"
						name="userPwd" class="form-control tooltipstered" 
						maxlength="20" required="required" aria-required="true"
						style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
						placeholder="영문과 특수문자를 포함한 최소 8자"></td>
				</tr>
				<tr>
					<td style="text-align: left">
						<p><strong>비밀번호를 재확인해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk2"></span></p>
					</td>
				</tr>
				<tr>
					<td><input type="password" size="17" maxlength="20" id="password_check"
						name="pw_check" class="form-control tooltipstered" 
						maxlength="20" required="required" aria-required="true"
						style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
						placeholder="비밀번호가 일치해야합니다."></td>
				</tr>
	
				<tr>
					<td style="text-align: left">
						<p><strong>이름을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="nameChk"></span></p>
					</td>
				</tr>
				<tr>
					<td><input type="text" name="userName" id="user_name"
						class="form-control tooltipstered" maxlength="6"
						required="required" aria-required="true"
						style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
						placeholder="한글로 최대 6자"></td>
				</tr>
				
				<tr>
					<td style="text-align: left">
						<p><strong>이메일을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="emailChk"></span></p>
					</td>
				</tr>
				<tr>
					<td><input type="email" name="email" id="user_email"
						class="form-control tooltipstered" 
						required="required" aria-required="true"
						style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
						placeholder="ex) kh@kh.com"></td>
				</tr>
	
				<tr>
					<td style="padding-top: 10px; text-align: center">
						<p><strong>회원가입하셔서 KH 수강생이 되어보세요~~!</strong></p>
					</td>
				</tr>
				<tr>
					<td style="width: 100%; text-align: center; colspan: 2;"><input
						type="submit" value="회원가입" 
						class="btn form-control tooltipstered" id="signup-btn"
						style="background-color: #52b1ff; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:include page="../include/footer.jsp" />
 
</body>
</html>