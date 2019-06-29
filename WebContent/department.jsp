<%@page import="com.hrms.bean.Department"%>
<%@page import="com.hrms.dao.DepartDao"%>
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
			部门管理
		  </ul>
		  <dl class="am-icon-home" style="float: right;">
			当前位置： 首页 > <a href="#">部门列表</a>
		  </dl>
		  <dl>
			<a href="addDepInfo.jsp"><button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-am-modal="{target: '#my-popup'}">添加部门</button></a>
		  </dl>
		  <!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束--> 
		  
		</div>
		<form class="am-form am-g">
		  <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped 	">
			<thead>
			  <tr class="am-success">
				<th class="table-type am-text-center">序号</th>
				<th class="table-type am-text-center">项目名称</th>
				<th class="table-type am-text-center">创建时间</th>
				<th class="table-type am-text-center">部门人数</th>
				<th class="table-type am-text-center">备注</th>
				<th class="table-type am-text-center">操作</th>
			  </tr>
			</thead>
			<tbody>
				<%
					DepartDao ddao=new DepartDao();
					ArrayList<Department> departs=ddao.getDepartment();
					for(Department depart:departs){
				%>
			  <tr>
				<td class="am-text-center"><%=depart.getDepartmentid() %></td>
				<td class="am-text-center"><%=depart.getDepartment() %></td>
				<td class="am-text-center"><%=depart.getCreatetime() %></td>
				<td class="am-text-center"><%=ddao.getNums(depart.getDepartment()) %></td>
				<td class="am-text-center"><%=depart.getRemarks() %></td>
				<td class="am-text-center am-text-center"><div style="margin:0 auto;">
					<div class="am-btn-group am-btn-group-xs">
					  	<a href="RemoveDepSer?depid=<%=depart.getDepartmentid()%>" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  title="删除"><span class="am-icon-trash-o"></span></a>
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
		   <a class="am-icon-trash-o am-text-danger" title="删除"> 删除部门</a>
		   
  
		  
		  
		  
		  
		  
		</form>
	  </div>
	</div>
</body>
</html>