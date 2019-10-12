<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<title>Daily Food</title>
<style>
</style>
<link rel="stylesheet" href="/resources/LiBoardForm.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/basic.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/resources/dropzone.css" type="text/css" media="screen" />
</head>
<body>
	<jsp:include page="BoardMain.jsp" flush="true" />
	<div class="tableBox">
		<div class="fileBox" id="fb">
			<table>
				<h1>썸네일 업로드</h1>
				<tr>
					<td>
						<form id="frm" action="/fileUpload" method="post" enctype="multipart/form-data">
							<input type="file" name="file" value="0" id="fileVal">
							<button type="button" id="imgbtn">등록</button>
						</form>
					</td>
				</tr>
			</table>
		</div>

		<div class="userBox" id="ub">
			<form action="/board/CreateLiBoard" method="post">
				<table>
					<h1>기본정보</h1>
					<tr>
						<td>제목</td>
						<td><input type="text" name="l_title"></td>
					</tr>
					<tr>
						<td class="liContent">설명</td>
						<td>
							<input type="text" name="l_content"> 
							<input id="id" name="id" type="hidden" value="${sessionScope.id}">
							<input id="fn" name="l_picture" type="hidden" value="">
							<button type="submit" id="apply">등록</button>
						</td>	
				</table>
			</form>
		</div>
		
		<div class="col-xs-6 col-xs-offset-3">
			<h1>이미지 업로드</h1>
            <form action="/uploadFile" class="dropzone" method="post" id="dropzone">
            	<div class="fallback"> <input type="file" name="file" multiple /></div>
            	<div class="dz-message">파일을 등록하세요.</div>
            </form>
            	<input type="hidden" value="${end}" name="endNo" id="endNo">
            	<input type="hidden" value="${start}" name="startNo" id="startNo">
            	<button type="button" id="applyImgBtn">등록</button>
		</div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="/resources/dropzone.js"></script>
	<script>
	
		$("#applyImgBtn").click(function(){
			var endNo = $("#endNo").val();
			var startNo = $("#startNo").val();

			var data = {
					"endNo" : endNo,
					"startNo" : startNo
					};

			$.ajax({
				url : "/apllyImg",
				type : "post",
				data : data,
				success : function(reponse) {
					}
				});
			});
	
		$("#imgbtn").click(function() {
			var fv = $('#fileval').val();
			var form = $('#frm')[0];
			var data = new FormData(form);
			$.ajax({
				url : "/fileUpload",
				type : "post",
				processData : false,
				contentType : false,
				data : data,
				success : function(result) {
					if (!result) {
						alert("사진 업로드가 실패했습니다.");
					} else {
						if (result.emptyfile == 0) {
							alert("파일을 업로드하세요!!");
						} else {
							$("#fn").val(result.name);
							$(".tableBox").css("height", 350);
							$("#fb").hide();
							$("#ub").show();
						}
					}
				}
			});
		});

		Dropzone.options.dropzoneForm = {
	            paramName: "file",
				uploadMultiple: true,
				acceptedFiles: "image/jpeg,image/png,image/jpg",
				resizeWidth : 1200,
				resizeMimeType : "image/jpeg"
	        };
	</script>
</body>
</html>
