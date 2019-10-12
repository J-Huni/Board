<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
</head>
<html lang="en">
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/resources/MainForm.css" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
	<div id="form">
		<div class="container">
			<img src="/resources/OptionImg/logo.png" id="logo">
			<div
				class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-md-8 col-md-offset-2">
				<div id="userform">
					<ul class="nav nav-tabs nav-justified" role="tablist">
						<li class="active"><a href="#login" role="tab" data-toggle="tab">로그인</a></li>
						<li><a href="#signup" role="tab" data-toggle="tab">회원가입</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade" id="signup">
							<h2 class="text-uppercase text-center">회원가입</h2>
							<form id="signup" action="/signup" method="post">
								<div class="row">
									<div class="col-xs-12 col-sm-6">
										<div class="form-group">
											<label>아이디<span class="req">*</span>
											</label> <input type="text" class="form-control" id="id" name="id"
												required
												data-validation-required-message="Please enter your email address."
												autocomplete="off">
											<p class="help-block text-danger"></p>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6">
										<button id="idck" type="button"
											class="btn btn-larger btn-block">중복확인</button>
									</div>
								</div>
								<div class="form-group">
									<label>이름<span class="req">*</span>
									</label> <input type="text" class="form-control" id="name" name="name"
										required
										data-validation-required-message="Please enter your name."
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<!-- 									<div class="col-xs-12 col-sm-6">
										<div class="form-group">
											<label> Last Name<span class="req">*</span>
											</label> <input type="text" class="form-control" id="last_name"
												required
												data-validation-required-message="Please enter your name."
												autocomplete="off">
											<p class="help-block text-danger"></p>
										</div>
									</div> -->



								<div class="form-group">
									<label>핸드폰번호<span class="req">*</span>
									</label> <input type="tel" class="form-control" id="phone" name="pnum"
										required
										data-validation-required-message="Please enter your phone number."
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<label>비밀번호<span class="req">*</span>
									</label> <input type="password" class="form-control" id="password"
										name="pw" required
										data-validation-required-message="Please enter your password"
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="mrgn-30-top">
									<button type="submit" class="btn btn-larger btn-block" />
									등록
									</button>
								</div>
							</form>
						</div>
						<div class="tab-pane fade active in" id="login">
							<h2 class="text-uppercase text-center">로그인</h2>

							<form id="login" action="/login" method="post">
								<div class="form-group">
									<label>아이디<span class="req">*</span>
									</label> <input type="text" class="form-control" id="id" name="id"
										required
										data-validation-required-message="Please enter your email address."
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<label>비밀번호<span class="req">*</span>
									</label> <input type="password" class="form-control" id="pw" name="pw"
										required
										data-validation-required-message="Please enter your password"
										autocomplete="off">
									<p class="help-block text-danger"></p>
								</div>
								<div class="mrgn-30-top">
									<button type="submit" class="btn btn-larger btn-block" />
									로그인
									</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container -->
	</div>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</body>
<script>
	$('#idck').click(function(){
		var id = $("#id").val();
		var data = {
			"id" : id
		};
		console.log(id);
		$.ajax({
			type : "post",
			url : "/id_Check",
			cashe : false,
			data : data,
			success : function(respon) {
				if(respon.result == "success"){
					alert("사용 가능한 아이디입니다.");	
				}
				else {
					alert("사용 불 가능한 아이디입니다.");
				}
			},
 			error : function() {
				alert("사용 불 가능한 아이디입니다.");
			}
		});
	});
	
	$('#form').find('input, textarea').on('keyup blur focus', function(e) {

		var $this = $(this), label = $this.prev('label');

		if (e.type === 'keyup') {
			if ($this.val() === '') {
				label.removeClass('active highlight');
			} else {
				label.addClass('active highlight');
			}
		} else if (e.type === 'blur') {
			if ($this.val() === '') {
				label.removeClass('active highlight');
			} else {
				label.removeClass('highlight');
			}
		} else if (e.type === 'focus') {

			if ($this.val() === '') {
				label.removeClass('highlight');
			} else if ($this.val() !== '') {
				label.addClass('highlight');
			}
		}

	});

	$('.tab a').on('click', function(e) {

		e.preventDefault();

		$(this).parent().addClass('active');
		$(this).parent().siblings().removeClass('active');

		target = $(this).attr('href');

		$('.tab-content > div').not(target).hide();

		$(target).fadeIn(800);

	});
</script>
</html>
