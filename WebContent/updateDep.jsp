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
    	<form action="UpdateDepSer" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>编号</td>
    			<td><input type="text" name="txtDepId" value="<%=request.getAttribute("depid") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>部门</td>
    			<td><input type="text" name="txtDep" value="<%=request.getAttribute("dep") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>创建时间</td>
    			<td><input type="text" name="txtDepCt"value="<%=request.getAttribute("depct") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>备注</td>
    			<td><input type="text" name="txtDepRe" value="<%=request.getAttribute("depre") %>"></td>
    		</tr>
    	</table>
    	<br>
    	<br>
    	<input type="submit" value="修改">
    	</form>
    	<br>
    	<hr>
    	</center>  	
  </body>
</html>
