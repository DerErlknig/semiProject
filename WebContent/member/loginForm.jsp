<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script>
function check(){
	var id=loginform.mem_id.value;
	var pass=loginform.mem_pass.value;
	
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		loginform.mem_id.focus();
		return false;	
	}
	if(pass.length == 0){
		alert("비밀번호를 입력하세요.");
		loginform.mem_pass.focus();
		return false;		
	}
	return true;	
}


</script>

</head>
<body>
	<form action="" align="center" height="30px" name="loginform" onsubmit="return check()">
		<h3>로그인 하세요.</h3>
		<label align="center" font-size="20">I D : </label>
		<input type="text" name="mem_id" size="20"><br>
		PASSWORD : <input type="password" name="mem_pass" size="20"><br><br>
		<input type="submit" value="로그인" ">
		<span><a href="javascript:window.location='./join.me'">회원가입</a></span>


	</form>

</body>
</html>