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
		<hr width="30%" color="blue">
			<h3>BOARD 글 상세페이지</h3>
		<hr width="30%" color="blue">
		
		<br>
		
		<c:set var="con" value="${Cont }"/>
		
		<c:if test="${!empty con }">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th colspan="2">
						<h3>${con.getBoard_writer() }님의 글 상세내역</h3>
					</th>
				</tr>
				
				<tr>
					<th>작성자</th>
					<td>${con.getBoard_writer() }</td>
				</tr>
				
				<tr>
					<th>글제목</th>
					<td>${con.getBoard_title() }</td>
				</tr>
				
				<tr>
					<th>글내용</th>
					<td>
						<textarea rows="7" cols="25" readonly="readonly">
							${con.getBoard_cont() }
						</textarea>
					</td>
				</tr>
					
					
				<tr>
					<th>비밀번호</th>
					<td>
						<c:if test="${!empty con.getBoard_pwd()}">
							<c:forEach begin="1" end="${con.getBoard_pwd().length() }">
								*
							</c:forEach>
						</c:if>
					</td>					
				</tr>		
				
				
				<tr>
					<c:if test="${empty con.getBoard_update()}">
						<th>작성일자</th>
						<td>${con.getBoard_date() }</td>
					</c:if>
					
					<c:if test="${!empty con.getBoard_update() }">
						<th>수정일자</th>
						<td>${con.getBoard_update() }</td>
					</c:if>
				</tr>
				
				<c:if test="${empty con }">
					<tr>
						<td colspan="2" align="center">
							<h3>검색된 내역이 없습니다.</h3>
						</td>
					</tr>
				</c:if>
				
				
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글 수정" 
					onclick="location.href='board_update.do?no=${con.getBoard_no()}'">
					
					<input type="button" value="글 삭제" 
					onclick="if(confirm('정말로 삭제하시겠습니까?')){
						location.href='board_delete.do?no=${con.getBoard_no()}'
					}else{return;}">
					
					<input type="button" value="글 목록"
						onclick="location.href='select.do'">
				</td>
			</tr>
				
				
			</table>
		</c:if>
	
	</div>


</body>
</html>