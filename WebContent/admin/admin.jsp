<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.admin.db.*"  %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	AdminDAO adDAO = new AdminDAO();
	OptionBean options = new OptionBean();
	options = adDAO.optionAdmin();
	List<String> genreOption = options.getGenreOptionList();
	List<String> feelOption = options.getFeelOptionList();
	List<String> locOption = options.getLocOptionList();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<table width="960" cellspacing="0" cellpadding="0" border="0"
	bordercolor="gray" align="center">
<tr>
<td colspan=2>

<table border="0" width="80%">
<form name="movieform" action="./movieAddAction.ad" method="post"
	enctype="multipart/form-data">
	<input type="hidden" name="movie_info" value="0">
	<tr> 
		<td>
			<p align="center">
				<span style="font-size: 26pt;">관 리 용 페 이 지</span>
			</p>
		</td>
	</tr>
	<tr>
		<td height="331">
		<table border="1" align="center" width="558">
			<tr>
			<td width="196" height="30">
				<p align="center">
					<font size=2>장르</font>
				</p>
			</td>
			<td width="346" height="30">
				<select name="movie_genre" size="1">
					<%	for(String genre : genreOption){%>
					<option value="<%=genre %>" selected><%=genre %></option>
					<%
					}
					%>
				</select>
			</td>
			</tr>
			<tr>
			<td>
				<p align="center"><font size=2>영화명</font></p>
			</td>
			<td><input type="text" name="movie_name"></td>
		</tr>
		
		<tr>
			<td width="196" height="30">
				<p align="center">
					<font size=2>연관 장소</font>
				</p>
			</td>
			<td width="346" height="30">
				<select name="movie_loc" size="1">
					<%	for(String loc : locOption){%>
					<option value="<%=loc %>" selected><%=loc %></option>
					<%
					}
					%>
				</select>
			</td>
			</tr>
		
			<tr>
			<td width="196" height="30">
				<p align="center">
					<font size=2>기분</font>
				</p>
			</td>
			<td width="346" height="30">
				<select name="movie_feel" size="1">
					<%	for(String feel : feelOption){%>
					<option value="<%=feel %>" selected><%=feel %></option>
					<%
					}
					%>
				</select>
			</td>
			</tr>
			
		<tr>
			<td>
				<p align="center"><font size=2>연령가</font></p>
			</td>
			<td><input type="text" name="movie_rating"></td>
		</tr>
		<tr>
			<td>
				<p align="center"><font size=2>상영시간</font></p>
			</td>
			<td><input type="text" name="movie_time"></td>
		</tr>
		<tr>
			<td>
				<p align="center"><font size=2>개봉일</font></p>
			</td>
			<td><input type="text" name="movie_date"></td>
		</tr>
		<tr>
			<td width="196">
				<p align="center"><font size=2>줄거리</font></p>
			</td>
			<td width="346">
				<textarea 
				name="movie_story" cols=50 rows=15></textarea>
			</td>
		</tr>
		<tr>
			<td>
			<p align="center"><font size=2>영화 포스터(jpg)</font></p>
			</td>
			<td><input type="file" name="poster"></td>
		</tr>
	</table>
	</td>
</tr>
<tr>
	<td height="75">
	<p align="center"><input type="submit" value="등록">&nbsp;
	<input type="reset" value="다시쓰기"></p>
	</td>
</tr>
</table>
</form>		
</td>
</tr>
</table>
</body>
</html>