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
    	<h2>修改员工信息</h2>
    	<hr>
    	<form action="UpdateStaSer" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>员工编号</td>
    			<td><input type="text" name="txtStaId" value="<%=request.getAttribute("staid") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>姓名</td>
    			<td><input type="text" name="txtStaNa" value="<%=request.getAttribute("stana") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>性别</td>
    			<td><input type="text" name="txtStaSe"value="<%=request.getAttribute("stase") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>部门</td>
    			<td><input type="text" name="txtStaDe" value="<%=request.getAttribute("stade") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>工种</td>
    			<td><input type="text" name="txtStaWTy" value="<%=request.getAttribute("stawty") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>学历</td>
    			<td><input type="text" name="txtStaEd" value="<%=request.getAttribute("staed") %>"></td>
    		</tr>
    		<tr align="center">
    			<td>参加工作时间</td>
    			<td><input type="text" name="txtStaWTm" value="<%=request.getAttribute("stawtm") %>"></td>
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
