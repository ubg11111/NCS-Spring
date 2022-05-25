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
		<c:set var="dto" value="${modify }"/>
		
		<hr width="30%" color="gray">
			<h3>PRODUCTS 테이블 ${dto.getCategory_name() }제품 수정 폼 페이지</h3>
		<hr width="30%" color="gray">
		
		<form method="post" action="<%=request.getContextPath()%>/product_modify_ok.do">
			
			<input type="hidden" name="pnum" value="${dto.getPnum()}">
			
			<table width="400">
				<tr>
					<th>카테고리 코드</th>
					<td><input name="category_fk" value="${dto.getCategory_fk() }" readonly></td>				
				</tr>
				
				<tr>
					<th>제품명</th>
					<td><input name="category_name" value="${dto.getCategory_name() }" readonly></td>					
				</tr>
				
				<tr>
					<th>제품 코드</th>
					<td><input name="ep_code_fk" value="${dto.getEp_code_fk() }" readonly></td>	
				</tr>
				
				
				<tr>
					<th>제품 입고 가격</th>
					<td><input name="input_price" value="${dto.getInput_price()}">원</td>
				</tr>
				
				<tr>
					<th>제품 출고 가격</th>
					<td><input name="output_price" value="${dto.getOutput_price()}">원</td>
				</tr>
				
				<tr>
					<th>제품 배송비</th>
					<td><input name="trans_cost" value="${dto.getTrans_cost()}">원</td>
				</tr>
				
				<tr>
					<th>제품 마일리지</th>
					<td><input name="mileage" value="${dto.getMileage()}">마일리지</td>
				</tr>
				
				
				<tr>
					<th>제품 제조사</th>
					<td><input name="company" value="${dto.getCompany() }"></td>
				</tr>
				
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="제품수정">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>