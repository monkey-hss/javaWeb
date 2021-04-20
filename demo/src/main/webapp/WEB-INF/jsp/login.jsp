<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="styleSheet" href="${bathPath }/layui/css/layui.css">
<script src="${bathPath }/js/jquery-3.3.1.min.js"></script>
<style type="text/css">
.main {
	position: absolute;
	text-align: center;
	width: 600px;
	height: 300px;
	margin: auto;
	top: 0px;
	left: 0px;
	right: 0px;
	bottom: 100px;
}
.main_child1 p{
	font-size: 20px;
	letter-spacing: 10px;
	margin-left: -68px
}
.layui-input{
	width: 300px;
}
</style>
</head>
<body style="background:url('${basePath }/img/login.jpg');">
	<div class="main">
		<div class="main_child1"><p>用户登录</p></div>
		<div class="main_child2">
			<form class="layui-form" action="" style="padding-top: 40px;">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-block">
						<input type="text" id="userName" placeholder="请输入" 
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label" style="letter-spacing: 7px">密码</label>
					<div class="layui-input-block">
						<input type="text" id="password" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">验证码</label>
					<div class="layui-inline" style="margin-left: -179px">
						<input type="text" id="checkCode" style="width: 120px" class="layui-input">
					</div>
					<div class="layui-inline">
						<img id="changeCode" alt="" src="${basePath }/api/img/getCode" style="width: 167px;">
					</div>
				</div>
			</form>
		</div>
		<div class="main_child3">
			<div class="layui-inline" style="margin-left: -80px">
				<button type="button" id="login" class="layui-btn">登录</button>
			</div>
			<div class="layui-inline" style="margin-left: 50px">
				<button type="button" id="register" class="layui-btn layui-btn-normal">注册</button>
			</div>
		</div>
	</div>
	
	<script src="${bathPath }/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use("layer",function(){
			var layer = layui.layer;
			
			//登录
			$("#login").click(function(){
				let userName = $("#userName").val();
				let password = $("#password").val();
				let checkCode = $("#checkCode").val();
				if(userName == "" || password == "" || checkCode == ""){
					layer.msg("请把信息填写完整");
					return;
				}
				//检验验证码
				let data = {"code":checkCode};
				let url = "${basePath }/api/img/checkCode";
				$.post(url,data,function(res){
					if(res == true){
						//校验用户名密码
						let url2 = "${basePath }/api/loginController/login";
						let data2 = {"userName":userName,"password":password};
						$.post(url2,data2,function(res2){
							if(res2.flag == true){
								layer.msg("登陆成功");
								window.location.href = "${basePath }/api/test/toIndex";
							}else{
								layer.msg("登录失败");
							}
						})
					}else{
						layer.msg("验证码错误");
						return;
					}
				})
			})
			
			//注册
			$("#register").click(function(){
				window.location.href = "${basePath }/api/userController/toAddUser";
			})
		})
		
		$("#changeCode").click(function(){
			$("#changeCode").attr('src','${basepath }/api/img/getCode?'+Math.random());
		})
	</script>
</body>
</html>