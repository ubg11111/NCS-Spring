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
		<hr width="30%" color="blue">
			<h3>성적표 조회</h3>
		<hr width="30%" color="blue">
	
		<table border="1" cellspacing="0" width="300">
			<tr>
				<th>학생이름</th>
				<td>${student_name }</td>
			</tr>
		
			<tr>
				<th>국어점수</th>
				<td>${kor }</td>
			</tr>
			
			<tr>
				<th>수학점수</th>
				<td>${mat }</td>
			</tr>
			
			<tr>
				<th>영어점수</th>
				<td>${eng }</td>
			</tr>
						
			<tr>
				<th>총점</th>
				<td>${sum}</td>
			</tr>			
			
			<tr>
				<th>평균점수</th>
				<td>${avgFomat}</td>
			</tr>
			
			<tr>
				<th>학점</th>
				<td>${grade}</td>
			</tr>
			
		</table>
	</div>

</body>
</html>