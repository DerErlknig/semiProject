<%@page import="net.movieInfo.db.MovieInfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MovieInfoBean movies = new MovieInfoBean();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" >
<c:choose>
			<c:when test="${requestScope.itemList[0].MOV_POSTER ==null}" >
				<tr >
					<td align="center"  >검색 결과가 없습니다.</td>
				</tr>
			</c:when>
		</c:choose>
		<tr>
			<td></td>
		</tr>
</table>
</body>
</html>