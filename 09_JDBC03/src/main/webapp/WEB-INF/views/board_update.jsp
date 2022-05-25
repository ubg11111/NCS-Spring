<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="30%" color="blue"> 
			<h3>BOARD 수정 폼 페이지</h3>
		<hr width="30%" color="blue">
		<br>
		
		<form method="post" action="<%=request.getContextPath()%>/board_update_ok.do">
			<c:set var="dto" value="${update }"/>
			<input type="hidden" name="board_no" value="${dto.getBoard_no() }">
			<table border="1" cellspacing="0" width="400">
				
				<tr>
					<td colspan="2" align="center">
						<h3>${dto.getBoard_writer() }님의 글 상세 내역</h3>
					</td>
				</tr>
				
				<tr>
					<th>작성자</th>
					<td>${dto.getBoard_writer() }</td>
				</tr>
				
				
				<tr>
					<th>글 제목</th>
					<td><input type="text" name="board_title" value="${dto.getBoard_title() }"></td> 
				</tr>
				
				<tr>
					<th>글 내용</th>
					<td>
						<textarea rows="7" cols="20" name="board_cont">
							${dto.getBoard_cont() }
						</textarea>
					</td>
				</tr>
				
				<tr>
					<th>작성일자</th>
					<td>
						${dto.getBoard_update() }
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						<input type="reset" value="다시작성">
						<input type="button" value="목록"
							onclick="location.href='board_content.do?no=${dto.getBoard_no()}'">
					</td>	
				</tr>
			</table>
		</form>
		 
	</div>

</body>
</html>