<%@page import="com.hrms.bean.Staff"%>
<%@page import="com.hrms.dao.StaDao"%>
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
    			<td>员工编号</td>
    			<td>姓名</td>
    			<td>性别</td>
    			<td>部门</td>
    			<td>工种</td>
    			<td>学历</td>
    			<td>参加工作时间</td>
    			<td>操作</td>
    		</tr>
    		<%
    			StaDao sdao=new StaDao();
    			ArrayList<Staff> stas=sdao.getStaff();
    			for(Staff sta:stas){
    		%>
    		<tr align="center">
    			<td><%=sta.getStaffid() %></td>
    			<td><%=sta.getStaffname() %></td>
    			<td><%=sta.getSex() %></td>
    			<td><%=sta.getDepartmeng() %></td>
    			<td><%=sta.getWorktype() %></td>
    			<td><%=sta.getEducation() %></td>
    			<td><%=sta.getWorktime() %></td>
    			<td> 			
					<a href="TransferStaSer?staid=<%=sta.getStaffid()%>&stana=<%=sta.getStaffname() %>&stase=<%=sta.getSex() %>&stade=<%=sta.getDepartmeng() %>&stawty=<%=sta.getWorktype() %>&staed=<%=sta.getEducation() %>&stawtm=<%=sta.getWorktime() %>">修改</a>
					&nbsp;&nbsp; 
					<a href="RemoveStaSer?staid=<%=sta.getStaffid()%>">删除</a>				
				</td>
    		</tr>
    		<%
    			}
    		%>
    	</table>
    	<br>
    	<hr>
    	<a href="addStaInfo.jsp">添加部门信息</a>
    	</center>
  </body>
</html>