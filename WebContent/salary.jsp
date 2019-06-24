<%@page import="com.hrms.bean.Salary"%>
<%@page import="com.hrms.dao.SalDao"%>
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
    	<h2>&nbsp;薪资信息</h2>
    	<hr>
    	<table border="1" cellspacing="0" width="800px">
    		<tr align="center">
    			<td>员工编号</td>
    			<td>员工姓名</td>
    			<td>当前月份</td>
    			<td>基本工资</td>
    			<td>加班费</td>
    			<td>工龄费</td>
    			<td>考勤费</td>
    			<td>旷工费</td>
    			<td>保险费</td>
    			<td>实发工资</td>
    			<td>操作</td>
    		</tr>
    		<%
    			SalDao sdao=new SalDao();
    			ArrayList<Salary> sals=sdao.getSalary();
    			for(Salary sal:sals){
    		%>
    		<tr align="center">
    			<td><%=sal.getStaffid() %></td>
    			<td><%=sal.getStaffname() %></td>
    			<td><%=sal.getCurmonth() %></td>
    			<td><%=sal.getBasepay() %></td>
    			<td><%=sal.getOvertimepay() %></td>
    			<td><%=sal.getDuration() %></td>
    			<td><%=sal.getAttpay() %></td>
    			<td><%=sal.getAbspay() %></td>
    			<td><%=sal.getInspay() %></td>
    			<td>
    				<%=
    					sal.getBasepay()+sal.getOvertimepay()+sal.getDuration()+sal.getAttpay()-sal.getAbspay()-sal.getInspay()
    				%>
    			</td>
    			<td> 								
					<a href="RemoveSalSer?staid=<%=sal.getStaffid() %>&salcu=<%=sal.getCurmonth() %>">删除</a>
				</td>
    		</tr>
    		<%
    			}
    		%>
    	</table>
    	<br>
    	<hr>
    	<a href="addSalInfo.jsp">添加薪资</a>
    	</center>
  </body>
</html>