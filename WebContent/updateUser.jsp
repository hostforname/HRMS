<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改员工信息</title>
    
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
    	<h2>修改部门信息</h2>
    	<hr>
    	<form action="UpdateUserSer?" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>账号</td>
    			<td><input type="text" value="<%=request.getParameter("name") %>" name="txtName"></td>
    		</tr>
    		<tr align="center">
    			<td>旧密码</td>
    			<td><input type="password" name="txtOld"></td>
    		</tr>
    		<tr align="center">
    			<td>新密码</td>
    			<td><input type="password" name="txtNew"></td>
    		</tr>
    		<tr align="center">
    			<td>确认密码</td>
    			<td><input type="password" name="txtReNew"></td>
    		</tr>
    	</table>
    	<br>
    	<br>
    	<input type="submit" value="保存">&nbsp;&nbsp;
    	<input type="reset" value="重置">
    	</form>
    	<br>
    	<hr>
    	</center>  	
  </body>
</html>
