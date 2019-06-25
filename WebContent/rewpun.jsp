<%@page import="com.hrms.bean.Rewpun"%>
<%@page import="com.hrms.dao.RewDao"%>
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
    	<h2>&nbsp;奖惩信息</h2>
    	<hr>
    	<%
    		String type=null;
    	%>
    	<a href="rewpun.jsp?type=1">奖励</a>
    	&nbsp;&nbsp;<a href="rewpun.jsp?type=0">惩罚</a>
    	<table border="1" cellspacing="0" width="800px">
    		<tr align="center">
    			<td>编号</td>
    			<td>奖惩主题</td>
    			<td>奖惩类型</td>
    			<td>奖惩金额</td>
    			<td>奖惩时间</td>
    			<td>操作</td>
    		</tr>
    		<%
    			type=request.getParameter("type");
    			RewDao rdao=new RewDao();
    			ArrayList<Rewpun> rews=rdao.getRewpun();
    			
    			if(type!=null){
    				Integer x=Integer.parseInt(type);
    				for(Rewpun rew:rews){
    					if(rew.getRewpuntype()==x){
    		%>
    						<tr align="center">
				    			<td><%=rew.getRewpunid() %></td>
				    			<td><%=rew.getRewpuntitle() %></td>
				    			<td>
				    				<%
				    					if(rew.getRewpuntype()==0) {	   				
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
				    			<td><%=rew.getRewpunmount() %></td>
				    			<td><%=rew.getRewpuntime() %></td>
				    			<td> 			
									<a href="TransferRewSer?rewid=<%=rew.getRewpunid() %>&rewtl=<%=rew.getRewpuntitle() %>&rewty=<%=rew.getRewpuntype() %>&rewmo=<%=rew.getRewpunmount() %>&rewtm=<%=rew.getRewpuntime() %>&rewdi=<%=rew.getDetainfo() %>">详细查询</a>
									&nbsp;&nbsp; 
									<a href="RemoveRewSer?rewid=<%=rew.getRewpunid()%>">删除</a>
								</td>
				    		</tr>
    		<%
    					}
    				}
    			}else{
    				for(Rewpun rew:rews){  			
    		%>
    					<tr align="center">
				    			<td><%=rew.getRewpunid() %></td>
				    			<td><%=rew.getRewpuntitle() %></td>
				    			<td>
				    				<%
				    					if(rew.getRewpuntype()==0) {	   				
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
				    			<td><%=rew.getRewpunmount() %></td>
				    			<td><%=rew.getRewpuntime() %></td>
				    			<td> 			
									<a href="TransferRewSer?rewid=<%=rew.getRewpunid() %>&rewtl=<%=rew.getRewpuntitle() %>&rewty=<%=rew.getRewpuntype() %>&rewmo=<%=rew.getRewpunmount() %>&rewtm=<%=rew.getRewpuntime() %>&rewdi=<%=rew.getDetainfo() %>">详细查询</a>
									&nbsp;&nbsp; 
									<a href="RemoveRewSer?rewid=<%=rew.getRewpunid()%>">删除</a>
								</td>
				    		</tr>
    		<%
    				}
    			}
    		%>
    	</table>
    	<br>
    	<hr>
    	<a href="addRewInfo.jsp">添加奖惩信息</a>
    	</center>
  </body>
</html>