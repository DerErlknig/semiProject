<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<c:forEach var="member" items="${requestScope.memberList }">
		유저 ID : ${member.MEM_ID } 유저 이름 : ${member.MEM_NAME }<br>
	</c:forEach>
</body>
</html>