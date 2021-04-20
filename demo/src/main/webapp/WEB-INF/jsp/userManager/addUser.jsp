<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="${bathPath }/layui/css/layui.css">
<style type="text/css">
.reg-main{
	position: absolute;
	text-align: center;
	width: 600px;
	height: 700px;
	top: 0px;
	left: 0px;
	right: 0px;
	bottom: 20px;
	margin: auto;
}
.reg-main2 p{
	font-size: 18px;
	padding-top: 20px;
	margin-right: 60px;
}
.layui-input{
	width: 300px;
}
.reg-main4{
	margin-right: 70px;
}
</style>
</head>
<body style="background: url(${basePath }/img/login.jpg);">
	<div class="reg-main">
		<div class="reg-main2"><p style="letter-spacing: 15px">用户注册</p></div>
		<div class="reg-main3">
			<form class="layui-form" action="" style="padding-top: 40px">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-block" style="display: flex">
						<input type="text" id="userName" placeholder="请输入用户名" class="layui-input">
						<div id="isCheckUserName" 
							style="color:red;padding-left: 10px;padding-top: 9px"></div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-block">
						<input type="text" id="password" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" id="name" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<input type="text" id="sex" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">年龄</label>
					<div class="layui-input-block">
						<input type="text" id="age" placeholder="请输入" class="layui-input">
					</div>
				</div>
			</form>
		</div>
		<div class="reg-main4">
			<div class="layui-inline">
				<button id="regist" type="button" class="layui-btn">注册</button>
			</div>
			<div class="layui-inline">
				<button id="toLogin" type="button" class="layui-btn">去登录</button>
			</div>
		</div>
	</div>

	<script src="${bathPath }/js/jquery-3.3.1.min.js"></script>
	<script src="${bathPath }/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use("layer", function() {
			var layer = layui.layer;
			
			//校验用户名
			$("#userName").blur(function(){
				let userName = $("#userName").val();
				let url = "${basePath }/api/userController/checkUserName";
				let data = {"userName":userName};
				$.post(url,data,function(res){
					if(res.flag == false){
						$("#isCheckUserName").html("用户名已存在");
						return;
					}else{
						$("#isCheckUserName").html("");
						return;
					}
				})
			})
			
			//注册
			$("#regist").click(function(){
				let userName = $("#userName").val();
				let password = $("#password").val();
				let name = $("#name").val();
				let sex = $("#sex").val();
				let age = $("#age").val();
				if(userName == "" || password == "" || name ==""){
					layer.msg("用户名、密码、姓名不能为空");
					return
				}
				var data = {
						"userName":userName,
						"password":password,
						"name":name,
						"sex":sex,
						"age":age
				}
				let url = "${bathPath }/api/userController/addUser"
				$.post(url,data,function(res){
					console.log(res);
					if(res.flag == true){
						layer.msg("注册成功");
					}else{
						layer.msg("注册失败");
					}
				})
			})
			
			//去登录
			$("#toLogin").click(function(){
				window.location.href = "${basePath }/api/loginController/toLogin";
			})
		})
	</script>
</body>
</html>