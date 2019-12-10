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
<c:forEach var="info" items="${requestScope.infoList }" >
	${info.MOV_TITLE }<br>
	${info.MOV_DATE }<br>
	${info.MOV_TIME }<br>
	${info.MOV_RATING }<br>
	${info.MOV_STORY }<br>
	${info.MOV_POSTER }<br>
</c:forEach>
	
</body>
</html>