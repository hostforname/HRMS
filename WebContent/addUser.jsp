<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<html class="no-js">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Amaze UI Admin index Examples</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta name="description" content="这是一个 index 页面">
	<meta name="keywords" content="index">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="icon" type="image/png" href="assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="assets/css/admin.css">
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/app.js"></script>
</head>

<body>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->

	</head>

	<body>
		<div>
			<div class="admin-biaogelist" style="margin-top: 0px;margin-left: 0px;">
				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on">
						系统管理
					</ul>
					<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 > <a href="#">添加管理员</a>
					</dl>
					<!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束-->

				</div>
				<div class="fbneirong">
					<form class="am-form" action="AddUserSer" method="post">
						<div class="am-form-group am-cf">
							<div class="zuo">账号：</div>
							<div class="you">
								<input type="text" name="txtUseNa" class="am-input-sm" id="doc-ipt-email-1">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">密码：</div>
							<div class="you">
								<input type="password" name="txtUsePwd" class="am-input-sm" id="doc-ipt-email-1">
							</div>
						</div>

						<div class="am-form-group am-cf">
							<div class="zuo"></div>
							<div class="you">
									<%	String error=null;
									error=request.getParameter("error");
									if(error!=null){ 
								%>
									账号和密码不能为空
								<%
									} 
								%>
							</div>
						</div>
						
						
						<div class=" am-form-group am-cf">
								<div class="you" style="margin-left: 11%;">
									<button type="submit" class="am-btn am-btn-success am-radius">新增</button>
								</div>
							</div>
					</form>
				</div>
			</div>
	</body>

</html>