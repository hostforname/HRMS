<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加员工信息</title>
    
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
    	<h2>添加薪资</h2>
    	<hr>
    	<form action="AddSalSer" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>员工编号</td>
    			<td><input type="text" name="txtStaId"></td>
    		</tr>
    		<tr align="center">
    			<td>员工姓名</td>
    			<td><input type="text" name="txtStaNa"></td>
    		</tr>
    		<tr align="center">
    			<td>基本工资</td>
    			<td><input type="text" name="txtSalBa"></td>
    		</tr>
    		<tr align="center">
    			<td>加班费</td>
    			<td><input type="text" name="txtSalOv" value="0"></td>
    		</tr>
    		<tr align="center">
    			<td>工龄费</td>
    			<td><input type="text" name="txtSalDu"  value="0"></td>
    		</tr>
    		<tr align="center">
    			<td>考勤费</td>
    			<td><input type="text" name="txtSalAt"  value="0"></td>
    		</tr>
    		<tr align="center">
    			<td>旷工费</td>
    			<td><input type="text" name="txtSalAb"  value="0"></td>
    		</tr>
    		<tr align="center">
    			<td>保险费</td>
    			<td><input type="text" name="txtSalIn"  value="0"></td>
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