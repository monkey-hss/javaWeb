<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="styleSheet" href="${bathPath }/layui/css/layui.css">
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
.layui-input{
	width: 300px;
}
</style>
</head>
<body style="background: url('${basePath }/img/default.png');background-repeat: no-repeat;">
<%-- 	<div class="reg-main">
		<form class="layui-form" action="" style="padding-top: 40px" id="menuForm">
			<div class="layui-form-item">
				<label class="layui-form-label">菜单名称</label>
				<div class="layui-input-block" style="display: flex">
					<input type="text" id="menuName" placeholder="请输入"
						class="layui-input">
					<div id="is_repeate" style="color:red;padding-left: 10px;padding-top: 7px"></div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单层级</label>
				<div class="layui-input-block">
					<input type="text" id="menuLevel" placeholder="请输入" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单路径</label>
				<div class="layui-input-block">
					<input type="text" id="menuUrl" placeholder="请输入" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">父菜单名称</label>
				<div class="layui-input-block">
					<input type="text" id="menuParentName" placeholder="请输入" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">功能类型</label>
				<div class="layui-input-block">
					<select id="menuType">
						<option value="">请选择</option>
						<option value="1">菜单</option>
						<option value="2">按钮</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单顺序</label>
				<div class="layui-input-block">
					<input type="text" id="menuOrder" placeholder="请输入" class="layui-input">
				</div>
			</div>
		</form>
	</div>
	<button id="regist" type="button" class="layui-btn">保存</button>

	<script src="${bathPath }/js/jquery-3.3.1.min.js"></script>
	<script src="${bathPath }/layui/layui.js"></script>
	<script type="text/javascript">
		
	</script>
	<script type="text/javascript">
		layui.use(["layer","form"],function(){
			var layer = layui.layer;
			var form = layui.form;
			
			//校验菜单名
			$("#menuName").blur(function(){
				var menuName = $("#menuName").val();				
				let url = "${basePath}/api/menuController/checkMenuName";
				let data = {"menuName":menuName};
				$.post(url,data,function(res){
					if(res.flag == false){
						$("#is_repeate").html(res.result);
						return;
					}else{
						$("#is_repeate").html("");
						return;
					}
				})
			})
			
			//新增
			$("#regist").click(function(){
				var menuName = $("#menuName").val();
				var menuType = $("#menuType").val();
				var menuLevel = $("#menuLevel").val();
				var menuUrl = $("#menuUrl").val();
				var menuOrder = $("#menuOrder").val();
				var menuParentName = $("#menuParentName").val();
				
				if(menuLevel != "1" && menuLevel != ""){
					if(menuName == "" || menuType == "" || menuOrder == "" || 
							menuParentName == "" || menuLevel == ""){
						layer.msg("请把信息填写完整");
						return;
					}
				}else{
					if(menuLevel == "" || menuType == "" || menuOrder == ""){
						layer.msg("请把信息填写完整");
						return;
					}
				}
				if(menuType == "1"){
					menuType = "菜单";
				}else if(menuType == "2"){
					menuType = "按钮";
				}
				var url = "${basePath}/api/menuController/addMenu";
				var data = {
						"menuName":menuName,
						"menuType":menuType,
						"menuLevel":menuLevel,
						"menuUrl":menuUrl,
						"menuOrder":menuOrder,
						"menuParentName":menuParentName
				};
				$.post(url,data,function(res){
					if(res.flag == true){
						layer.msg("保存成功");
					}else{
						layer.msg("保存失败");
					}
					$("#menuForm")[0].reset();
				})
			})
		})
	</script> --%>
</body>
</html>