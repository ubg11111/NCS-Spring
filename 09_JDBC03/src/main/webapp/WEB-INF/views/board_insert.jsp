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
			<h3>BOARD 게시판 글 등록 페이지</h3>
		<hr width="30%" color="blue">
		
		<br>
		
		<form method="post" action="<%=request.getContextPath()%>/board_insert_ok.do">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>작성자</th>
					<td><input name="board_writer"></td>
				</tr>
				
				<tr>
					<th>글제목</th>
					<td><input name="board_title"></td>
				</tr>
				
				<tr>
					<th>글 내용</th>
					<td>
						<textarea rows="7" cols="30" name="board_cont">
							
						</textarea>
					</td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="board_pwd"></td>
				</tr>
								
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글쓰기">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
				
			</table>
		</form>
		
		
	</div>
	
</body>
</html>