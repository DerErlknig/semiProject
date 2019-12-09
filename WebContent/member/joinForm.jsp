<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3 align="center">회원가입 폼</h3>
<form name="joinform" id="joinform" action="./MemberJoinAction.me" method="post" 
		onsubmit="return check()">
<table width="960" cellspacing="0" cellpadding="0" border="0" align="center">
	<tr>
		<td>이름
			<input type="text" name="mem_name" size="20"/>
		</td>
	</tr>
	<tr>
		<td>생년월일
			<input type="text" name="mem_birthday" size="20" placeholder="예)19920301">
	<tr>
		<td>주소
			<input type="text" name="mem_address" size="20"/>
		</td>
	</tr>
	<tr>
		<td>아이디
			<input type="text" name="mem_id" size="20"/>
		</td>
	</tr>
	<tr>
		<td>비밀번호
			<input type="password" name="mem_pass" size="20"/>
		</td>
	</tr>
	<tr>
		<td>비밀번호 확인
			<input type="password" name="mem_repass" size="20"/>
		</td>
	</tr>
	<tr>
		<td>성별
			<input type="radio" name="mem_gender" value="M" checked="checked">남
			<input type="radio" name="mem_gender" value="F">여
		</td>
	</tr>
	<tr>
		<td>전화번호
			<input type="text" name="mem_phone1"  size="3"/>-
			<input type="text" name="mem_phone2" size="4"/>-
			<input type="text" name="mem_phone3"  size="4"/>
		</td>
	</tr>
	<td><input type="submit" value="등록"></td>
	





</table>
</form>
</body>
</html>