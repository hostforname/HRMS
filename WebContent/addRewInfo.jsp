<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加奖惩信息</title>
    
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
    	<h2>添加奖惩信息</h2>
    	<hr>
    	<form action="AddRewSer" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>奖惩主题</td>
    			<td><input type="text" name="txtRewTl"></td>
    		</tr>
    		<tr align="center">
    			<td>奖惩类型</td>
    			<td><input type="text" name="txtRewTy"></td>
    		</tr>
    		<tr align="center">
    			<td>奖惩金额</td>
    			<td><input type="text" name="txtRewMo"></td>
    		</tr>
    		<tr align="center">
    			<td>详细信息</td>
    			<td><input type="text" name="txtRewDi"></td>
    		</tr>
    	</table>
    	<br>
    	<br>
    	<input type="submit" value="新增">
    	</form>
    	<br>
    	<hr>
    	</center>
  </body>
</html>
