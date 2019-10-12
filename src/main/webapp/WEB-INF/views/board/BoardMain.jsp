<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<title>Daily Food</title>
<style>
</style>
<link rel="stylesheet" href="/resources/BoardForm.css" type="text/css" media="screen" />
</head>

<body>
	<header id="head">
		<div id="logo">
				<a href="/board/ImgMain"><img id="LogoImg" src="/resources/OptionImg/logo.png"></a>
		</div>
	</header>

	<nav id="mainnav" class="group">
		<div id="menu">&#x2261; Menu</div>
		<ul>
			<li><a href="/board/SelectBoard">선택장애</a></li>
			<li><a href="/board/FreeBoard">자유게시판</a></li>
		</ul>
	</nav>


	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
	$(document).ready(function() {
		   
	      // JQUERY NAV TOGGLE
	      $('#menu').bind('click',function(event){
	          $('#mainnav ul').slideToggle();
	      });

	      $(window).resize(function(){  
	          var w = $(window).width();  
	          if(w > 768) {  
	              $('#mainnav ul').removeAttr('style');  
	          }  
	      });
			
		});
	</script>
</body>
</html>
