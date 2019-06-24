<%@page import="com.hrms.bean.Train"%>
<%@page import="com.hrms.dao.TraDao"%>
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
    			<td>培训人</td>
    			<td>培训主题</td>
    			<td>培训时间</td>
    			<td>培训地点</td>
    			<td>操作</td>
    		</tr>
    		<%
    			TraDao tdao=new TraDao();
    			ArrayList<Train> tras=tdao.getTrain();
    			for(Train tra:tras){
    		%>
    		<tr align="center">
    			<td><%=tra.getTrainid() %></td>
    			<td><%=tra.getTrainer() %></td>
    			<td><%=tra.getTraintitle() %></td>
    			<td><%=tra.getTraintime() %></td>
    			<td><%=tra.getTrainaddr() %></td>
    			<td> 			
					<a href="TransferTraSer?traid=<%=tra.getTrainid()%>&traer=<%=tra.getTrainer() %>&tratl=<%=tra.getTraintitle() %>&tratm=<%=tra.getTraintime() %>&traad=<%=tra.getTrainaddr() %>&tradi=<%=tra.getDetainfo() %>">详细查询</a>
					&nbsp;&nbsp; 
					<a href="RemoveTraSer?traid=<%=tra.getTrainid()%>">删除</a>
				</td>
    		</tr>
    		<%
    			}
    		%>
    	</table>
    	<br>
    	<hr>
    	<a href="addTraInfo.jsp">添加培训信息</a>
    	</center>
  </body>
</html>