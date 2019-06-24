<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人力资源管理系统首页</title>
    
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

  		<br><br><br><br>
  		<center>
			<table>
				<tr>
					<th>
						<a href="department.jsp" target="ifrpage">部门管理</a>
					</th>
					<th>
						<a href="staff.jsp" target="ifrpage">员工管理</a>
					</th>
					<th>
						<a href="recruit.jsp" target="ifrpage">招聘管理</a>
					</th>
					<th>
						<a href="train.jsp" target="ifrpage">培训管理</a>
					</th>
					<th>
						<a href="rewpun.jsp" target="ifrpage">奖惩管理</a>
					</th>
					<th>
						<a href="salary.jsp" target="ifrpage">薪酬管理</a>
					</th>
					<th>
						<a href="user.jsp" target="ifrpage">系统管理</a>
					</th>
				</tr>
				<tr>
					<td>
						<a href="updateUser.jsp?name=<%=request.getAttribute("name") %>" target="ifrpage">用户修改</a>
					</td>
					<td>
						<a href="home.jsp" target="ifrpage">返回首页</a>
					</td>
					<td>
						<a href="login.html">安全退出</a>
					</td>
				</tr>
							
			</table>
			<iframe src="home.jsp" id="ifrpage" name="ifrpage" src="" width="100%" height="80%">
			</iframe>
		</center>
		
    	
  </body>
</html>
