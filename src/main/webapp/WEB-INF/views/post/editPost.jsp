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
			<h2>수정</h2>
		</div>
		<div>
			<div>
				<img src="/resources/img/${read.l_picture}">
			</div>
			<div>
				<input type="hidden" name="l_no" id="l_no" value="${read.l_no}"> <span>제목</span>
				<input type="text" name="l_title" id="l_title" value="${read.l_title}"> <span>내용</span>
				<input type="text" name="l_content" id="l_content" value="${read.l_content}">
				<button type="button" id="editBtn">완료</button>
			</div>
		</div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		$("#editBtn").click(function(){
			var l_no = $("#l_no").val();
			var l_title = $("#l_title").val();
			var l_content = $("#l_content").val();

			var data = {
					"l_no" : l_no,
					"l_title" : l_title,
					"l_content" : l_content
					};
			
			$.ajax({
				type : "post",
				data : data,
				url : "/post/editPost",
				success : function(response) {
					if(response.result == "fail"){
						alert("수정 실패");
						}
					else {
						alert("수정이 완료 되었습니다.");
						self.close()
						}
				}
			});
		});	
	</script>
</body>
</html>