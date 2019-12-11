<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 검색창 </title>
<script src="./js/jquery-3.4.1.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$('#search_btn').click(function(){
			$.ajax({
				url:'bbb.jsp',
				datatype : 'jsp',
				success: function(data){
					$('#poster').html(data);
				}
			});
		});
	});
</script>
</head>
<body>
<form id="sform" name="sform" method="get" action="./serchMovie.If">
	<fieldset width="200px" heigt="200px" align="center" >
   		<legend class="blind" >찾으시는 영화가 있나요?</legend>
        <span class="green_window">
            <input id="query" name="query" type="text" title="검색어 입력" maxlength="255" class="input_text"  />
        </span>
        
        <button id="search_btn" type="submit" title="검색"  ><span >검색</span></button>
    </fieldset>
    
    <div id ="poster" ></div>
   
</form>
</body>
</html>