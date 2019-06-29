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
	<meta name="desRecption" content="这是一个 index 页面">
	<meta name="keyRecds" content="index">
	<meta name="vieRecrt" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="renRecer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="icon" type="image/png" href="assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
	<meta name="appRecmobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="assets/css/amazeui.min.css" />
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
						招聘管理
					</ul>
					<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 > <a href="#">添加应聘人信息</a>
					</dl>
					<!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束-->

				</div>
				<div class="fbneirong">
					<form class="am-form" action="AddRecSer" method="post">
						<div class="am-form-group am-cf">
							<div class="zuo">姓名：</div>
							<div class="you">
								<input type="text" name="txtRecNa" class="am-input-sm" id="doc-ipt-email-1">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">性别：</div>
							<div class="you">
								<input type="text" name="txtRecSe" class="am-input-sm" id="doc-ipt-email-1">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">应聘职位：</div>
							<div class="you">
								<input type="text" name="txtRecTy" class="am-input-sm" id="doc-ipt-email-1">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">学历：</div>
							<div class="you">
								<input type="text" name="txtRecEd" class="am-input-sm" id="doc-ipt-email-1">
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">工作经验：</div>
							<div class="you">
								<textarea class="" name="txtRecWe" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">详细信息：</div>
							<div class="you">
								<textarea class="" name="txtRecDi" rows="2" id="doc-ta-1"></textarea>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo"></div>
							<div class="you">
									<%	String error=null;
									error=request.getParameter("error");
									if(error!=null){ 
								%>
									前四项不能为空
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