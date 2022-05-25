<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
		
		<c:set var="dto" value="${Cont }"/>
		<hr width="50%" color="blue">
			<h3>${dto.getMemname() }님의 상세페이지</h3>
		<hr width="50%" color="blue">
		
		<br>
		
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>회원 아이디</th>
				<td>${dto.getMemid() }</td>
			</tr>
			
			<tr>
				<th>회원 이름</th>
				<td>${dto.getMemname() }</td>
			</tr>
			
			<tr>
				<th>회원 비밀번호</th>
				<td>
					<c:if test="${!empty dto.getPwd()}">
						<c:forEach begin="1" end="${dto.getPwd().length() }">
							*
						</c:forEach>
					</c:if>
				</td>
			</tr>
			
			<tr>
				<th>회원 나이</th>
				<td>${dto.getAge() }</td>
			</tr>
			
			<tr>
				<th>회원 마일리지</th>
				<td><fmt:formatNumber value="${dto.getMileage() }"></fmt:formatNumber></td>
			</tr>
			
			<tr>
				<th>회원 직업</th>
				<td>${dto.getJob() }</td>
			</tr>
			
			<tr>
				<th>회원 주소</th>
				<td>${dto.getAddr() }</td>
			</tr>
			
			<c:if test="${empty dto }">
				<td colspan="8" align="center">
					<h3>상세페이지가 없습니다.</h3>
				</td>
			</c:if>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="회원수정"
						onclick="location.href='member_update.do?num=${dto.getNum() }'">
						
					<input type="button" value="회원삭제"
						onclick="if(confirm('정말로 삭제하시겠습니까?')){
						location.href='member_delete.do?num=${dto.getNum()}'
						}else{return;}">	
						
					<input type="button" value="목록으로"
						onclick="location.href='member_list.do'">	
				</td>
			</tr>
			
		</table>
		
	
		
				
	</div>
	
</body>
</html>