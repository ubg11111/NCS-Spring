<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h3>PRODUCTS 테이블 전체리스트 폼 페이지</h3>
		<hr width="30%" color="blue">
		
		<br>
	
		<table border="1" cellspacing="0" width="500">
			<c:set var="search" value="${Search}"/>
			<tr>
				<th>제품번호</th>
				<th>제품명</th>
				<th>판매가격</th>
				<th>제조회사</th>
			</tr>
			
			<c:if test="${!empty search }">
				<c:forEach items="${search }" var="dto">
					<tr>
						<td>${dto.getPnum() }</td>
						<td>
						<a href="<%=request.getContextPath()%>/product_content.do?pnum=${dto.getPnum()}">
							${dto.getCategory_name() }</a>
						</td>
						<td><fmt:formatNumber value="${dto.getOutput_price() }"/>원</td>
						<td>${dto.getCompany() }</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty search }">
				<tr>
					<td colspan="4" align="center">
						<h3>조회된 상품목록이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			
			
			<tr>
				<td colspan="4" align="center">
					<input type="button" value="목록으로"
						onclick="location.href='product_list.do'">
				<td>
			</tr>
			
		</table>
		
		
	</div>

</body>
</html>