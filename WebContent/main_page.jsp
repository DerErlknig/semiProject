<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
<link rel="stylesheet" href="./css/animate.css">
 <style>
 body{
	padding:0;
	margin:0;
 }
 
.emotion{
	width:100px;
	height:100px;
}

div#background {
    background-image:url("./images/space.jpg");
    top:0;
    left:0;
    position:absolute;
    background-size:100%;
    opacity:0.5!important;
    filter:alpha(opacity=50);
    z-index:-1;
    width:100%;
    height:100%;
    
}

#box{
	position:relative;
	top:20px;
}

#emotions{
	position:relative;
	top:20px;
	border-spacing: 30px;
}

#place{
	position:relative;
	border-spacing: 20px;
}

	
</style>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#box').on({
			mouseenter : function(){ $(this).addClass('animated wobble'); },
			mouseleave : function(){ $(this).removeClass('animated wobble'); }
		});
		
		$('#lovely').on({
			mouseenter : function(){ $(this).addClass('animated rubberBand');},
			mouseleave : function(){ $(this).removeClass('animated rubberBand');}
		});
		
		$('#angry').on({
			mouseenter : function(){ $(this).addClass('animated wobble');},
			mouseleave : function(){ $(this).removeClass('animated wobble');}
		});
		
		$('#sad').on({
			mouseenter : function(){ $(this).addClass('animated swing');},
			mouseleave : function(){ $(this).removeClass('animated swing');}
		});
		
		$('#funny').on({
			mouseenter : function(){ $(this).addClass('animated tada');},
			mouseleave : function(){ $(this).removeClass('animated tada');}
		});
		
		$('#hhh').on({
			mouseenter : function(){ $(this).addClass('animated flash');},
			mouseleave : function(){ $(this).removeClass('animated flash');}
		});
	});
</script>
</head>


<body>

	<div id="background">
	</div>
	<div>
		<table align="center" id="box">
			<tr>
				<td>
					<a href="#">
						<img src="./images/randomBox1.png" width="300px" height="200px">
					</a>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<table align="center" id="emotions" >
			<tr>
				<td colspan="2">
					<a href="#">
						<img src="./images/angry.png" id="angry" class="emotion">
					</a>
				</td>
				<td colspan="2" >
					<a href="#" >
						<img src="./images/lovely.png" id="lovely" class="emotion">
					</a>
				</td>
				<td colspan="2">
					<a href="#">
						<img src="./images/sad.png" id="sad" class="emotion">
					</a>
				</td>
				<td colspan="2">
					<a href="#">
						<img src="./images/funny.png" id="funny" class="emotion">
					</a>
				</td>
				<td colspan="2">
					<a href="#">
						<img src="./images/hhh1.png" id="hhh" width="200px" height="200px">
					</a>
				</td>
			</tr>
		</table>
		<table align="center" id="place">
			<tr>
				<td colspan="2">
					<a href="#">
						<img src="./images/mountain.png" width="200px" height="200px">
					</a>
				</td>
				<td colspan="2">
					<a href="#">
						<img src="./images/sea.jpg" width="200px" height="200px">
					</a>
				</td>
			</tr>
		</table>
		<jsp:include page="search/search.jsp"></jsp:include>
	</div>

		

	
	
</body>
</html>
