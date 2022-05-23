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
		<hr widht="30%" color="blue">
			<h3>성적표 입력 창</h3>
		<hr widht="30%" color="blue">
		
		<br>
		
		<form method="post" action="<%=request.getContextPath()%>/report">
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>학생이름</th>
					<td><input name="student_name"></td>
				</tr>
		
				<tr>
					<th>국어점수</th>
					<td><input name="kor"></td>
				</tr>
		
				<tr>
					<th>수학점수</th>
					<td><input name="mat"></td>
				</tr>
				
				
				<tr>
					<th>영어점수</th>
					<td><input name="eng"></td>
				</tr>
					
				
				<tr>
					<td colspan="4"  align="center">
						<input type="submit" value="제출">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
				
			</table>
		</form>
	
	</div>

</body>
</html>