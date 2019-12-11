<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="net.movieInfo.db.*"%>

<%
	MovieInfoBean movieInfo = (MovieInfoBean) request.getAttribute("movieInfo");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화정보</title>
</head>
<body>
<!-- http://localhost:8090/Movie/selectMovie.If?title= 형태에 집어넣으면 호출 -->
	
	
	<table>
		<tr>
		<td rowspan="9"><img alt="" src="./poster/${movieInfo.MOV_POSTER }" width="200" height="380"></td>
		</tr>
		<tr>
			<td >${movieInfo.MOV_TITLE }</td>
		</tr>
		<tr>
			<td>개봉일</td>
			<td>${movieInfo.MOV_DATE }</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>상영시간</td>
			<td>${movieInfo.MOV_TIME }</td>
		</tr>
		<tr>
			<td>시청 제한</td>
			<td>${movieInfo.MOV_RATING }</td>
		</tr>
		<tr>
			<td>감독</td>
			<td>${movieInfo.MOV_DIRECTOR }</td>
		</tr>
		<tr>
			<td>배우</td>
			<td>${movieInfo.MOV_ACTOR }</td>
		</tr>
		<tr>
			<td>장르</td>
			<td>${movieInfo.MOV_GENRE }</td>
		</tr>
	</table>
	${movieInfo.MOV_STORY }
</body>
</html>