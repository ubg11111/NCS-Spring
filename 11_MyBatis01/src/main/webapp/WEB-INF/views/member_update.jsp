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
		<c:set var="dto" value="${Update }"/>
		<hr width="50%" color="blue"> 
			<h3>${dto.getMemname() }님의 수정페이지</h3>
		<hr width="50%" color="blue"> 
		
		<br>
		
		<form method="post" action="<%=request.getContextPath()%>/member_update_ok.do">
			<input type="hidden" name="num" value="${dto.getNum() }">
			
			<table border="1" cellspacing="0" width="450">
				<c:if test="${!empty dto}">
					<tr>
						<th>회원 아이디</th>
						<td><input type="text" name="memid" readonly="readonly" value="${dto.getMemid() }"></td>
					</tr>
					
					<tr>
						<th>회원 이름</th>
						<td><input type="text" name="memname" readonly="readonly" value="${dto.getMemname() }"></td>
					</tr>
					
					<tr>
						<th>회원 비밀번호</th>
						<td><input type="password" name="pwd" value="${dto.getPwd() }"></td>
					</tr>
					
					<tr>
						<th>회원 나이</th>
						<td><input type="text" name="age" value="${dto.getAge() }"></td>
					</tr>
					
					<tr>
						<th>회원 마일리지</th>
						<td><input type="text" name="mileage" value="${dto.getMileage() }"></td>
					</tr>
					
					<tr>
						<th>회원 직업</th>
						<td><input type="text" name="job" value="${dto.getJob() }"></td>
					</tr>
					
					<tr>
						<th>회원 주소</th>
						<td><input type="text" name="addr" value="${dto.getAddr() }"></td>
					</tr>
				</c:if>
				
				<c:if test="${empty dto }">
					<tr>
						<td colspan="7" align="center">
							<h3>검색된 회원정보가 없습니다...</h3>
						</td>
					</tr>					
				</c:if>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						<input type="reset" value="다시작성">
						<input type="button" value="목록으로"
							onclick="location.href='member_content.do?num=${dto.getNum()}'">
					</td>
				</tr>
				
				
			</table>
		</form>
		
	</div>

</body>
</html>