<%@page import="com.hrms.bean.Department"%>
<%@page import="com.hrms.dao.DepartDao"%>
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
    	<h2>&nbsp;员工信息编辑</h2>
    	<hr>
    	<table border="1" cellspacing="0" width="800px">
    		<tr align="center">
    			<td>序号</td>
    			<td>部门名称</td>
    			<td>创建时间</td>
    			<td>部门人数</td>
    			<td>备注</td>
    			<td>操作</td>
    		</tr>
    		<%
    			DepartDao ddao=new DepartDao();
    			ArrayList<Department> departs=ddao.getDepartment();
    			for(Department depart:departs){
    		%>
    		<tr align="center">
    			<td><%=depart.getDepartmentid() %></td>
    			<td><%=depart.getDepartment() %></td>
    			<td><%=depart.getCreatetime() %></td>
    			<td><%=ddao.getNums(depart.getDepartment()) %></td>
    			<td><%=depart.getRemarks() %></td>
    			<td>
    			<!-- 
					<a href="TransferDepSer?depid=<%=depart.getDepartmentid()%>&dep=<%=depart.getDepartment() %>&depct=<%=depart.getCreatetime() %>&depre=<%=depart.getRemarks() %>">修改</a>
					&nbsp;&nbsp; -->
					<a href="RemoveDepSer?depid=<%=depart.getDepartmentid()%>">删除</a>
					
				</td>
    		</tr>
    		<%
    			}
    		%>
    	</table>
    	<br>
    	<hr>
    	<a href="addDepInfo.jsp">添加部门信息</a>
    	</center>
  </body>
</html>









