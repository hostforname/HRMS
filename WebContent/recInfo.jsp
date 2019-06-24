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
    	<h2>招聘详细信息</h2>
    	<hr>
    	<form action="" method="post">
    	<table border="1" cellspacing="0" width="300px">
    		<tr align="center">
    			<td>编号</td>
    			<td><%=request.getAttribute("recid") %></td>
            </tr>
            <tr align="center">
    			<td>姓名</td>
    			<td><%=request.getAttribute("recna") %></td>
    		</tr>
            <tr align="center">
    			<td>性别</td>
    			<td><%=request.getAttribute("recse") %></td>
    		</tr>
            <tr align="center">
    			<td>应聘职务</td>
    			<td><%=request.getAttribute("recty") %></td>
    		</tr>
            <tr align="center">
    			<td>学历</td>
    			<td><%=request.getAttribute("reced") %></td>
    		</tr>
            <tr align="center">
    			<td>工作经验</td>
    			<td><%=request.getAttribute("recwe") %></td>
    		</tr>
            <tr align="center">
    			<td>详细情况</td>
    			<td><%=request.getAttribute("recdi") %></td>
            </tr>
            <tr align="center">
    			<td>状态</td>
    			<td>
    			<%/*System.out.println(request.getAttribute("recst"))
    			这里无法准确判断状态的值是多少
    			但是使用Parameter就能获取到准确的值
    			getParameter()：返回String类型的数据

    		    getAttribute()：返回String类型的数据，或 ，也可以是对象，但是当返回的是对象时需要进行强制转换
    			*/
    			%>
    				<%
    					if(request.getParameter("recst").equals("0")) {	   				
    				%>						
						未被录用
					<%
						}
						else {
					%>
						已被录用
					<%
						}
					%>
    				
    			</td>
    		</tr>
    	</table>
    	</form>
    	<br>
    	<hr>
    	</center>
  </body>
</html>
