<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
	URI(Uniform Resource Identifier)
	식별자 - 고유한 이름(PK) -> 실제위치가 아니라 논리적인 식별값
	
	URL(Uniform Resource Locator)
	위치정보 -> 실제 파일의 경로나 웹 주소
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자신과의싸움</title>
</head>
<body>

	<h1>JSTL이란..?</h1>
	
	<p>
		Jakarta Server Page Standard Tag Library의 약어로 <br>
		JSP에서 사용할 수 있는 커스텀 액션 태그 <br>
		공통적으로 사용해야하는 코드들의 집합을 보다 쉽게 사용할 수 있도록 태그로 만들어서 <br>
		표준으로 제공하는 라이브러리(클래스 모음집)	
	</p>
	
	<hr>
	
	<h3>* 라이브러리를 추가</h3>
	
	1) https://tomcat.apache.org로 접속 <br>
	2) Standard-1.2.5.jar파일 4개다 다운받기 <br>
	3) WEB-INF/lib폴더에 추가해주기 <br>
	
	<h4>* JSTL 선언</h4>
	
	<p>
		JSTL을 사용하고자하는 해당 JSP파일 상단에 <br>
		(보통 page지시어 바로 밑에)<br>
		taglib지시어를 사용해서 선언함 <br><br>
		
		[ 표현법 ]<br>
		&lt;@ taglib prefix="접두어" uri="파일uri">
	</p>
	
	<hr>
	
	<h4>JSTL Core Library(오늘의 주인공)</h4>
	
	<p>
		변수와 조건문, 반복문 등의 로직과 관련된 태그들을 제공
	</p>
	
	<h5>변수(사실 변수아님 속성 선언하기 == Attribute)</h5>
	
	<pre>
		솔직하게 이야기하겠습니다. 사실 그냥 아까 배운 Scope들에 새로운 속성 추가하는 방법입니다.
		
		[ 표현법 ]
		&lt;c:set var="키값" value="리터럴값" scope="스코프영역지정(생략가능)" />
		- Scope에 새로운 Attribute를 추가할 수 있는 태그
		- 더 나아가서 어떤 Scope에 추가할건지도 지정 가능(생략 시 pageScope에 담김)
	
	</pre>
	
	<c:set var="num1" value="10" />
	<c:set var="num2" value="20" scope="request" />
	<c:set var="result" value="${ num1 + num2 }" scope="session" />
	
	num1의 값 : ${ num1 } <br>
	num2의 값 : ${ num2 } <br>
	result의 값 : ${ result } <br>
	
	<c:set var="result" scope="request">9999</c:set>
	<!-- value속성 말고 시작태그와 종료태그 사이에도 대입할 값을 기술할 수 있음 -->
	
	<hr>
	
	<pre>
		* 속성 삭제(&lt;c:remove var="제거하려고하는 키값" scope="스코프영역(생략가능)"/>)
		
		- 해당 Attribute를 Scope영역에서 제거하는 태그
		- scope속성을 작성하지 않으면 모든 scope에서 해당 Attribute를 찾아서 다 제거함
	</pre>
	
	삭제 전 result : ${ result }<br>
	
	<hr>
	
	requestScope에서 result속성을 삭제 <br>
	<c:remove var="result" scope="request" />
	삭제 후 result : ${ result }<br>
	
	<hr>
	
	<pre>
		* 속성 출력(&lt;c:out value="출력할값" default="기본값" escapeXml="t/f"/>)
		- 데이터를 출력하려고 할 때 사용하는 태그
		- default : 기본값, value속성에 출력하고자 하는 값이 없을 경우 대체해서 출력할 
		            내용물을 쓸 수 있음(생략가능)
		- escapeXml : HTML태그를 인식시킬수도있음
	</pre>
	
	num1을 출력! : <c:out value="${ num1 }" /> <br>
	이걸 왜이렇게 씀 ? : ${ num1 } <br>
	
	<br>
	
	requestScope result : ${ requestScope.result } <br>
	out태그를 써볼까? : <c:out value="${ requestScope.result }" default="값이 없어용..." />
	
	<br>
	
	<c:set var="outStr" value="<strong>강한정보</strong>" />
	<br>
	${ outStr } <br>
	<c:out value="${ outStr }" />
	&lt;strong>강한정보&lt;/strong>
	
	<hr>
	
	<h3>2. 조건문 - if</h3>
	
	<pre>
	
		[표현법]
		&lt;c:if test="조건식">
			조건식이 true일 경우 실행할 내용
		&lt;/c:if>
	
		- Java의 단일 if문과 비슷한 역할을 수행하는 태그
		- 조건식은 test라는 속성에 작성
		  (조건식을 만들때는 반드시 EL구문으로 작성해야함!!!!!!!!!!!)
	</pre>
	<%--
	<% if((int)request.getAttribute("v1") > (int)request.getAttribute("v2")){ %>
		value1이 value2보다 큽니다.
	<% } %>
    --%>
    
    <c:if test="${ num1 gt num2 }">
    	<strong>num1이 num2보다 큽니다.</strong> <br>
    </c:if>
    
    <c:if test="${ num1 le num2 }">
    	<strong>num1이 num2보다 작거나 같습니다.</strong> <br>
    </c:if>
    
    <br>
    
    <h3>3. 조건문 - choose, when, otherwise </h3>
	
	<pre>
		[ 표현법 ]
		&lt;c:choose>
			&lt;c:when test="조건1">
				어쩌고저쩌고~
			&lt;/c:when>
			&lt;c:when test="조건2">
				어쩌고저쩌고~
			&lt;/c:when>
			&lt;c:otherwise>
				어쩌고저쩌고~~
			&lt;/c:otherwise>
		&lt;/c:choose>
		
		- Java의 if-else문, switch문 비슷한 역할을 하는 태그
		각 조건들은 choose의 하위요소로 when태그를 이용해서 작성
		otherwise는 조건을 작성하지 않음
	</pre>
	<%-- 
	<% if(조건1) { %>
	
	<% } else if(조건2) { %>
	
	<% } else if(조건3) { %>
	
	<% } else { %>
	
	<% } %>
	--%>
	
	<c:set var="point" value="400" />
	
	회원 등급 출력 : 
	<c:choose>
		<c:when test="${ point le 100 }">
			일반회원 <br>
		</c:when>
		<c:when test="${ point le 300 }">
			우수회원 <br>
		</c:when>
		<c:otherwise>
			<strong>최우수회원</strong><br>
		</c:otherwise>
	</c:choose>
	<!-- choose안에는 when/otherwise말고 들어가면안됨 -->
	
	<h3>4. 반복문 - forEach </h3>
	
	<pre>
		[ 표현법 ]
		for loop문
		&lt;c:forEach var="속성명" begin="초기값" end="끝값" step="몇씩증가">
			반복시킬 내용
		&lt;/c:forEach>
		
		step은 생략 시 기본값이 1
		
		향상된 for문
		&lt;c:forEach var="속성명" items="순차적으로접근할배열/컬렉션" varStatus="상태값">
			반복시킬 내용
		&lt;/c:forEach>
	
		var로 선언된 제어변수를 사용할때는 반드시 EL구문으로 접근해야함!!
	</pre>
	
	<% for(int i = 0; i < 10; i++) { %>
		<%= i %>
	<% } %>
	
	<br>
	
	<c:forEach var="i" begin="0" end="9">
		${ i }
	</c:forEach>
	
	<br>
	
	<c:forEach var="i" begin="1" end="6">
		<h${ i }>이런것도 가능</h${ i }>
	</c:forEach>
	
	<c:set var="color">
		red, orangered, orange, yellow, yellowgreen, greenyellow, forestgreen
	</c:set>
	
	color : ${ color }
	
	<br>
	
	<ul>
		<c:forEach var="c" items="${ color }">
			<li style="color:${ c }">${ c }</li>
		</c:forEach>
	</ul>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>순번</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${ empty list }">
					<tr>
						<th colspan="3">조회결과가 존재하지 않습니다.</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="p" items="${ list }" varStatus="s">
						<tr>
							<!-- index : 0부터 / count : 1부터 -->
							<td>${ s.count }</td>
							<td>${ p.name }</td>
							<td>${ p.age }</td>
							<td>${ p.address }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>		
		</tbody>
		<tfoot>
			<tr>
				<th colspan="3">총 합</th>
				<td>${ list.size() }명</td>
			</tr>
		</tfoot>
	</table>
	
	<hr>
	
	<h5>5. 반복문 - forTokens </h5>
	
	<pre>
		[ 표현법 ] <br>
		
		&lt;c:forTokens var="값을보관할속성명" items="분리하고자하는문자열" delims="구분자">
		
			반복적으로 실행할 문구(출력만)
		
		&lt;/c:forTokens>
		
		- JAVA의 StringTokenizer와 비슷한 역할
		- 구분자를 통해 분리된 각각의 문자열에 순차적으로 접근하면서 반복 수행
	</pre>
	
	<!-- 테스트할 값 -->
	<c:set var="device" value="컴퓨터,핸드폰,TV/에어컨.냉장고-세탁기" />
	
	<ul>
		<c:forTokens var="d" items="${ device }" delims=",/.-">
			<li>${ d }</li>
		</c:forTokens>
	</ul>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>