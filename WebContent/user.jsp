<%@page import="com.hrms.bean.User"%>
<%@page import="com.hrms.dao.UserDao"%>
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
    	<h2>&nbsp;管理员信息</h2>
    	<hr>
    	<table border="1" cellspacing="0" width="800px">
    		<tr align="center">
    			<td>序号</td>
    			<td>账号</td>
    			<td>操作</td>
    		</tr>
    		<%
    			UserDao udao=new UserDao();
    			ArrayList<User> uses=udao.getUser();
    			for(User use:uses){
    		%>
    		<tr align="center">
    			<td><%=use.getUserid() %></td>
    			<td><%=use.getUsername()%></td>
    			<td>
					<a href="RemoveUserSer?useid=<%=use.getUserid()%>">删除</a>
				</td>
    		</tr>
    		<%
    			}
    		%>
    	</table>
    	<br>
    	<hr>
    	<a href="addUser.jsp">添加管理员</a>
    	</center>
  </body>
</html>