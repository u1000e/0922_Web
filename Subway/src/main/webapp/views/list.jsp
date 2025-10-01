<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.subway.model.vo.Subway, java.util.List" %>
<%
	// request.getAttribute("키값") : Object
	List<Subway> orders = (List<Subway>)request.getAttribute("orders");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역확인하기</title>

<style>
	#wrap{
		width: 1600px;
		border : 1px solid lightgrey;
		margin : auto;
		text-align : center;
	}
	
	table{
		box-shadow : 1px 1px 1px rgba(0, 0, 0, 0.4);
	}
</style>
</head>
<body>

	<div id="wrap">
		
		<h1>주문내역보기</h1>
		
		<table>
			<tr>
				<th>주문자명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>요청사항</th>
				<th>샌드위치</th>
				<th>채소</th>
				<th>소스</th>
				<th>쿠키</th>
				<th>결제수단</th>
				<th>주문일자</th>
			<tr>
			
			<% if(orders.isEmpty()) { %>
				<tr>
					<th colspan="10">조회결과가 존재하지 않습니다.</th>				
				</tr>
			<% } else { %>
				
				<% for(Subway s : orders) { %>
					<tr>
						<td width="130"><%= s.getName() %></td>
						<td><%= s.getPhone() %></td>
						<td><%= s.getAddress() %></td>
						<td><%= s.getRequest() %></td>
						<td><%= s.getSandwich() %></td>
						<td><%= s.getVegetable() %></td>
						<td><%= s.getSauce() %></td>
						<td><%= s.getCookie() %></td>
						<td><%= s.getPayment() %></td>
						<td><%= s.getOrderDate() %></td>
					</tr>
				<% } %>
				
			<% } %>
		</table>
	
	</div>

</body>
</html>