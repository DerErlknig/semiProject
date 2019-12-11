<%@page import="net.movieInfo.db.MovieInfoBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과 페이지</title>


<%
	int nowpage = 1;
	int count = ((Integer)(request.getAttribute("count"))).intValue();
	int pageCount = ((Integer)(request.getAttribute("pageCount"))).intValue();
	int startPage = ((Integer)(request.getAttribute("startPage"))).intValue();
	int endPage = ((Integer)(request.getAttribute("endPage"))).intValue();
%>

</head>
<body>

<table border="0" align="center">
	<c:choose>
			<c:when test="${requestScope.itemList[0].MOV_TITLE ==null}" >
				<tr>
					<td align="center">검색 결과가 없습니다.</td>
				</tr>
			</c:when>	
			<c:otherwise>
			
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
	
	</c:otherwise>
	</c:choose>
</table>

</body>
</html>