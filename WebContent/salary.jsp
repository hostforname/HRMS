<%@page import="com.hrms.bean.Salary"%>
<%@page import="com.hrms.dao.SalDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
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
						薪资管理
					</ul>
					<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 > <a href="salary.jsp">薪资信息列表</a>
					</dl>
					<dl>
						<a href="addSalInfo.jsp"><button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"
							data-am-modal="{target: '#my-popup'}">添加薪资信息</button></a>
					</dl>
					<!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束-->

				</div>
				<form class="am-form am-g">
					<table width="100%"
						class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
						<thead>
							<tr class="am-success">
								<th class="table-type am-text-center">员工编号</th>
								<th class="table-type am-text-center">员工姓名</th>
								<th class="table-type am-text-center">当前月份</th>
								<th class="table-type am-text-center">基本工资</th>
								<th class="table-type am-text-center">加班费</th>
								<th class="table-type am-text-center">工龄费</th>
								<th class="table-type am-text-center">考勤费</th>
								<th class="table-type am-text-center">旷工费</th>
								<th class="table-type am-text-center">保险费</th>
								<th class="table-type am-text-center">实发工资</th>
								<th class="table-type am-text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<%
								SalDao sdao=new SalDao();
								ArrayList<Salary> sals=sdao.getSalary();
								for(Salary sal:sals){
							%>
							<tr align="center">
								<td><%=sal.getStaffid() %></td>
								<td><%=sal.getStaffname() %></td>
								<td><%=sal.getCurmonth() %></td>
								<td><%=sal.getBasepay() %></td>
								<td><%=sal.getOvertimepay() %></td>
								<td><%=sal.getDuration() %></td>
								<td><%=sal.getAttpay() %></td>
								<td><%=sal.getAbspay() %></td>
								<td><%=sal.getInspay() %></td>
								<td>
										<%=
											sal.getBasepay()+sal.getOvertimepay()+sal.getDuration()+sal.getAttpay()-sal.getAbspay()-sal.getInspay()
										%>
								</td>
								<td>
									<div style="margin:0 auto;">
										<div class="am-btn-group am-btn-group-xs" style="margin:0 auto;">
											<a href="RemoveSalSer?staid=<%=sal.getStaffid() %>&salcu=<%=sal.getCurmonth() %>" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"
												title="删除"><span class="am-icon-trash-o"></span></a>
										</div>
									</div>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>

					<ul class="am-pagination am-fr">
						<li class="am-disabled"><a href="#">«</a></li>
						<li class="am-active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul>
					<hr />
					<a class="am-icon-trash-o am-text-danger" title="删除"> 删除</a>
				</form>
			</div>
		</div>
	</body>

</html>