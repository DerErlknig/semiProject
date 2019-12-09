<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기 화면</title>
</head>
<body>
	<%
	
//	String id=(String)session.getAttribute("id");
//	System.out.println(id);
//	if(id==null){
		response.sendRedirect("/Movie/loginform.me");
//	}else{
//		response.sendRedirect("Movie/main.me");
//	}
		
		
	%>
</body>
</html>