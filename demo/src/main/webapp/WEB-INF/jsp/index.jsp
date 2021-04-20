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
<meta content="charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>首页</title>
<link rel="stylesheet" href="${basePath }/layui/css/layui.css">
<link rel="stylesheet" href="${basePath }/css/style.css">
<style type="text/css">
.index-iframe{
	width: 100%;
	height: 100%;
}
.dl-child{
	padding-left: 25px;
}
</style>
</head>
<body>
	<div class="menu">
		<div class="index-top">
			<div class="index-top-left">
				<div>信息管理后台</div>
			</div>
			<div class="index-top-right">
				<div class="index-tx">
					<img alt="" src="${basePath }/img/touxiang.jpg">
					<i class="index-yhm">admin
						<a href="${basePath }/api/loginController/logOut" class="index-logout">退出系统</a>
					</i>
				</div>
			</div>
		</div>
		
		<div class="index-left">
			<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" 
				style="width: 100%;height: 100%;">
				<li class="layui-nav-item layui-nav-itemed">
					<a href="${basePath }/api/index/toIframe" target="index-iframe">首页</a>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">用户管理</a>
					<dl class="layui-nav-child">
						<dd class="dl-child"><a href="javascript:;" target="index-iframe">创建用户</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">菜单管理</a>
					<dl class="layui-nav-child">
						<dd class="dl-child"><a href="${basePath }/api/index/toAddMenu" target="index-iframe">创建菜单</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">权限管理</a>
					<dl class="layui-nav-child">
						<dd class="dl-child"><a href="${basePath }/api/index/toAddRole" target="index-iframe">创建角色</a></dd>
						<dd class="dl-child"><a href="javascript:;" target="index-iframe">创建组</a></dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>
	<div class="index-right">
		<iframe id="iframe" name="index-iframe" class="index-iframe" src=""></iframe>
	</div>
	<script src="${bathPath }/js/jquery-3.3.1.min.js"></script>
	<script src="${bathPath }/layui/layui.js"></script>
	<script type="text/javascript">
		//菜单导航事件
		layui.use(["element","layer"],function(){
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
			var layer = layui.layer;
			
			element.on('nav(demo)',function(elem){
				
			})
		})
		
		//请求获取菜单列表
		$(function(){
			let url = "${basePath}/api/menuController/getMenuList";
			let data = {};
			$.post(url,data,function(res){
				if(res.flag){
					//layer.msg("hhhh");
					alert("chenggong")
					return;
				}else{
					//layer.msg("ssss");
					alert("shibai")
					return;
				}
			})
		})
	</script>
</body>
</html>