<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
		<hr width="30%" color="gray">
			<h3>회원 가입 입력 폼 페이지</h3>
		<hr width="30%" color="gray">
	
	
		<br>
		
		
		<form method="post" action="<%=request.getContextPath()%>/join_ok">
			<table border="1" cellspacing="0" width="400">
				<tr>	
					<th>회원 이름</th>
					<td><input name="name"></td>
				</tr>
				
				<tr>	
					<th>회원 아이디</th>
					<td><input name="id"></td>
				</tr>
				
				<tr>	
					<th>회원 비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				
				<tr>	
					<th>회원 나이</th>
					<td><input name="age"></td>
				</tr>
				
				<tr>	
					<th>회원 연락처</th>
					<td><input name="phone"></td>
				</tr>
				
				<tr>	
					<th>회원 이메일</th>
					<td><input name="email"></td>
				</tr>
				
				<tr>	
					<th>회원 주소</th>
					<td><input name="addr"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
				
				
			</table>
		</form>
	
	</div>
	
	
</body>
</html>