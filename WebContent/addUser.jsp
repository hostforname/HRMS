<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加管理员</title>
    
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
    	<h2>添加管理员</h2>
    	<hr>
    	<form action="AddUserSer" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>账号</td>
    			<td><input type="text" name="txtUseNa"></td>
    		</tr>
    		<tr align="center">
    			<td>密码</td>
    			<td><input type="password" name="txtUsePwd"></td>
    		</tr>
    	</table>
    	<br>
    	<%	String error=null;
    		error=request.getParameter("error");
    		if(error!=null){ 
    	%>
    		账号或密码不能为空
    	<%
    		} 
    	%>
    	<br>
    	<input type="submit" value="新增">
    	</form>
    	<br>
    	<hr>
    	</center>
  </body>
</html>
