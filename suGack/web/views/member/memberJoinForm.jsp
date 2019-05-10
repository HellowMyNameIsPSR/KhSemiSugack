<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
	.joinForm{
		border:1px solid lightgray;
		width:600px;
		height:650px;
		padding:30px;
	}
	table{
		margin-top:50px;
	}
	input{
		padding:5px;
	}
	.btn{
		width:100px;
	}
	.btn-block{
		width:300px;
	}
	form{
		margin-top:20px;
	}
	h2{
		margin-bottom:20px;
	}
	.content{
		margin-top:20px;
	}
</style>
</head>
<body>
<%@ include file="../main/mainMenubar.jsp" %>
	<div class="container" align="center">			
			<div class="joinForm" align="center">
				<h2 align="center">회원가입</h2>
			
				<form action="<%= request.getContextPath() %>/insertMember.me" method="post" class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-3">이메일</label>
						<div class="col-sm-6">
							<input type="email" name="email" id="email" class="form-control" placeholder="이메일">
						</div>
						<!-- <button class="col-sm-2 btn btn-primary" onclick="idCheck();">중복확인</button> -->
						<input type="button" class="col-sm-2 btn btn-primary" id="idCheck" value="중복확인">
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">비밀번호</label>
						<div class="col-sm-6">
							<input type="password" name="password" id="password" class="form-control" placeholder="비밀번호">
						</div>
						<label class="control-label col-sm-3" id="passwordResult"></label>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">비밀번호확인</label>
						<div class="col-sm-6">
							<input type="password" name="password2" id="password2" class="form-control" placeholder="비밀번호 확인">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">핸드폰</label>
						<div class="col-sm-6">
							<input type="tel" name="phone" class="form-control" placeholder="000-0000-0000">
						</div>
						<button class="col-sm-2 btn btn-primary">인증</button>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">이름</label>
						<div class="col-sm-6">
							<input type="text" name="name" class="form-control" placeholder="이름">
						</div>
					</div>
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
					<button type="submit" class="btn btn-primary btn-md btn-block" id="submit">회원가입</button>
					<button type="reset" class="btn btn-default btn-md btn-block" id="reset"> 취소 </button>
					</div>
				</form>
					<br>
					
			
			</div>
			
	</div>
	
	
	
	
	<script>
		$(function(){
			$("#password2").change(function(){
				var password = $("#password").val();
				var password2 = $("#password2").val();
				console.log(password);
				console.log(password2);
				
				if(password == password2){
					$("#passwordResult").text("일치합니다").css("color", "yellowgreen");
					$("#submit").attr("disabled", false);
				}else{
					$("#passwordResult").text("일치하지않습니다").css("color", "red");
					$("#submit").attr("disabled", true);
				}
			});
			
			$("#idCheck").click(function(){
				var email = $("#email").val();
				$.ajax({
					url:"/sg/idCheck.me",
					type:"post",
					data:{email:email},
					success:function(data){
						if(data == "fail") {
							alert("사용 할 수 없는 이메일 입니다.");
							$("#submit").attr("disabled", true);
						}else {
							alert("사용 가능한 아이디입니다.");
							$("#submit").attr("disabled", false);
						}
					},
					error:function(data){
						console.log("실패 원인분석해라");
					}
				});
			});
		});
	</script>
</body>
</html>




















