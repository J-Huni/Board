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
<link rel="stylesheet" href="/resources/LiBoardForm.css" type="text/css"
	media="screen" />
</head>

<body>
	<jsp:include page="BoardMain.jsp" flush="true" />
	<div class="CreateBrd">
		<a href="/board/CreateLiBoard">글 쓰기</a>
	</div>
	<div class="ListBox">
		<c:forEach items="${BoardList}" var="List">
			<div class="ListStyle">
				<ul>
					<li class="imgContain">
						<a href="#" onclick="window.open('/post/readPost?l_no=${List.l_no}','new','resizable=no width=500 height=600');return false">
							<img src="/resources/img/${List.l_picture}">
						</a>
					</li>
					<li class="titleContain">
						<a href="#" onclick="window.open('/post/readPost?l_no=${List.l_no}','new','resizable=no width=500 height=600');return false">
							<span>${List.l_title}</span>
						</a>
					</li>
					<li class="ListBtn"><button>선택하기</button></li>
					<li><button>바로시작</button></li>
				</ul>
			</div>
		</c:forEach>
		<div id="jsonList"></div>
		<div>
			<input type="hidden" id="page" name="pagePost" value="12"> 
			<input type="hidden" id="lpn" name="lastPostNo" value="${lpn}">
			<button type="button" id="listmore" class="btnMore">더보기</button>
		</div>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		$("#listmore").click(function() {
							var pagePost = $("#page").val();
							/* 			var lpn = $("#lpn").val(); */
							/* 			var pagePost = Number(postCnt) + 8; */

							console.log(pagePost);
							var data = {
								"pagePost" : pagePost,
							};

							$.ajax({
										type : "post",
										data : data,
										url : "/MoreList",
										success : function(response) {
											console.log(response)
											$.each(response, function(index, list) {
												$('#jsonList').append("<div class='listStyle'>"
														+ "<ul>"
														+ "<li class='imgContain'>"
														+ "<a href=# onclick=\"window.open('/post/readPost?l_no=" + list.l_no + "','new','resizable=no width=500 height=600');return false\">"
														+ "<img src='/resources/img/" + list.l_picture + "' />" + "</a>"
														+ "</li>" + "<li class='titleContain'>"
														+ "<a href=# onclick=\"window.open('/post/readPost?l_no=" + list.l_no + "','new','resizable=no width=500 height=600');return false\">"
														+ "<span>" + list.l_title
														+ "</span>" + "</a>"+ "</li>"
														+ "<li class='ListBtn'>" + "<button>" + "선택하기"
														+ "</button>"
														+ "</li>" + "<li>"
														+ "<button>" + "바로시작"
														+ "</button>" + "</li>"
														+ "</ul>" + "</div>");
											});
											pagePost = Number(pagePost) + 8;
											$("#page").val(pagePost);

										},
										error : function() {
											alert("더보기 실패");
										}
									});
						});
	</script>
</body>
</html>