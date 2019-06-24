<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加部门信息</title>
    
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
    	<h2>奖惩详细信息</h2>
    	<hr>
    	<form action="" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>编号</td>
    			<td><%=request.getAttribute("rewid") %></td>
            </tr>
            <tr align="center">
    			<td>奖惩主题</td>
    			<td><%=request.getAttribute("rewtl") %></td>
    		</tr>
            <tr align="center">
    			<td>奖惩类型</td>
    			<td>
					<%
    					if(request.getParameter("rewty").equals("0")) {	   				
    				%>						
						惩罚
					<%
						}
						else {
					%>
						奖励
					<%
						}
					%>
				</td>
    		</tr>
            <tr align="center">
    			<td>奖惩金额</td>
    			<td><%=request.getAttribute("rewmo") %></td>
    		</tr>
            <tr align="center">
    			<td>奖惩时间</td>
    			<td><%=request.getAttribute("rewtm") %></td>
    		</tr>
            <tr align="center">
    			<td>详细信息</td>
    			<td><%=request.getAttribute("rewdi") %></td>
    		</tr>       
    	</table>
    	</form>
    	<br>
    	<hr>
    	</center>
  </body>
</html>
