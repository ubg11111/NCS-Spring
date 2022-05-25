<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
		<hr width="30%" color="blue">
			<h3>BOARD 메인 페이지</h3>
		<hr width="30%" color="blue">
	
		<br>
		
		<a href="<%=request.getContextPath()%>/board_list.do">[전체 게시판 목록]</a>
		
	</div>

</body>
</html>
