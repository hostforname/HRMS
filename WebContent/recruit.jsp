<%@page import="com.hrms.bean.Recruit"%>
<%@page import="com.hrms.dao.RecDao"%>
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
    	<h2>&nbsp;应聘信息</h2>
    	<hr>
    	<table border="1" cellspacing="0" width="800px">
    		<tr align="center">
    			<td>编号</td>
    			<td>姓名</td>
    			<td>性别</td>
    			<td>应聘职务</td>
    			<td>学历</td>
    			<td>工作经验</td>
    			<td>操作</td>
    		</tr>
    		<%
    			RecDao rdao=new RecDao();
    			ArrayList<Recruit> recs=rdao.getRecruit();
    			for(Recruit rec:recs){
    		%>
    		<tr align="center">
    			<td><%=rec.getRecruitid() %></td>
    			<td><%=rec.getName() %></td>
    			<td><%=rec.getSex() %></td>
    			<td><%=rec.getRecruittype() %></td>
    			<td><%=rec.getEducation() %></td>
    			<td><%=rec.getWorkexp() %></td>
    			<td> 			
					<a href="TransferRecSer?recid=<%=rec.getRecruitid()%>&recna=<%=rec.getName() %>&recse=<%=rec.getSex() %>&recty=<%=rec.getRecruittype() %>&reced=<%=rec.getEducation() %>&recwe=<%=rec.getWorkexp() %>&recdi=<%=rec.getDetainfo() %>&recst=<%=rec.getStatus() %>">详细查询</a>
					&nbsp;&nbsp; 
					<a href="RemoveRecSer?recid=<%=rec.getRecruitid()%>">删除</a>
					&nbsp;&nbsp; 
					<%
						if(rec.getStatus()==0){					
					%>						
						<a href="UpdateRecSer?recid=<%=rec.getRecruitid()%>&recst=<%=rec.getStatus() %>">录用</a>
					<%
						}
						else {
					%>
						<a href="UpdateRecSer?recid=<%=rec.getRecruitid()%>&recst=<%=rec.getStatus() %>">已录</a>	
					<%
						}
					%>
				</td>
    		</tr>
    		<%
    			}
    		%>
    	</table>
    	<br>
    	<hr>
    	<a href="addRecInfo.jsp">添加应聘人信息</a>
    	</center>
  </body>
</html>