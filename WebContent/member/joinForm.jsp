<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#background{
    background-image: url("./member/images/collection.jpg");
   -webkit-filter: blur(5px);
  -moz-filter: blur(5px);
  -o-filter: blur(5px);
  -ms-filter: blur(100px);
  filter: blur(1.5px);
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  z-index: -1;
 /*  background-repeat: round; */
}

fieldset{
	font-size:15px;
	background-color: lavender;
	width:400px;
	padding:3px;
	margin:150px;
	cellspacing:3px;
	font-family: fantasy;
	border-color: lavender;
	
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="background">
</div>
<form name="joinform" id="joinform" action="./MemberJoinAction.me" method="post" align="center"
		onsubmit="return check()">
<font color="white" face="함초롬돋움">
	<div align="center">
	<fieldset name="joinform">
		<h2>회원가입 폼</h2>
		이름
			<input type="text" name="mem_name" size="20"/></br>
		
	
	
		생년월일
			<input type="text" name="mem_birthday" size="20" placeholder="예)1992-03-01"></br>
	
		주소
			<input type="text" name="mem_address" size="20"/></br>
		
	
	
		아이디
			<input type="text" name="mem_id" size="20"/></br>
		
	
	
		비밀번호
			<input type="password" name="mem_pass" size="20"/></br>
		
	
	
		비밀번호 확인
			<input type="password" name="mem_repass" size="20"/></br>
		
	
	
		성별
			<input type="radio" name="mem_gender" value="M" checked="checked">남
			<input type="radio" name="mem_gender" value="F">여</br>
		
	
	
		전화번호
			<input type="text" name="mem_phone1"  size="3"/>-
			<input type="text" name="mem_phone2" size="4"/>-
			<input type="text" name="mem_phone3"  size="4"/></br></br>
	
	
	<input type="submit" value="등록">
	</fieldset>	
	</div>
</font>
</form>
</body>
</html>