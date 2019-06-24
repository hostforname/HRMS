<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp_manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<center>
    	<table>
    		<tr>
    			<td><a href="addStaInfo.jsp" target="ifrpage">添加员工信息</a></td>
    			<td><a href="addTraInfo.jsp" target="ifrpage">制定培训计划</a></td>
    		</tr>
    		<tr>
    			<td><a href="addRecInfo.jsp" target="ifrpage">添加应聘信息</a></td>
    			<td><a href="addRewInfo.jsp" target="ifrpage">制定奖惩制度</a></td>
    		</tr>
    		<tr>
    			<td><a href="addDepInfo.jsp" target="ifrpage">添加部门信息</a></td>
    			<td><a href="addSalInfo.jsp" target="ifrpage">制定薪资信息</a></td>
    		</tr>
    	</table>
    	</center>
  </body>
</html>