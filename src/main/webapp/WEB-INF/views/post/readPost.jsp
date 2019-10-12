<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<title>Food Select</title>
<link rel="stylesheet" href="/resources/ReadForm.css" type="text/css" media="screen" />
</head>
<body>
	<div class="readStyle">
		<div>
			<h2>자세히 보기</h2>
		</div>
		<div>
			<div>
				<table>
					<tr>
						<td><img src="/resources/img/${read.l_picture}"></td>
						<td class="titleBox">${read.l_title}</td>
					</tr>
				</table>
			</div>
			<hr>
			<div>
				<table>
					<tr>
						<td>${read.l_content}</td>
					</tr>
				</table>
			</div>
			<hr>
			<div class="buttonBox">
				<div class="editBox">
					<button type="button" id="editPost">수정</button>
				</div>
				<div>
					<form method="post" action="/post/deletePost">
						<input type="hidden" value="${read.l_no}" name="l_no" id="dltBtn">
						<button type="submit" onclick="top.window.close()">삭제</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		$("#editPost").click(function() {
			location.href = "/post/editPost?l_no=" + ${read.l_no};
		});
	</script>
</body>
</html>