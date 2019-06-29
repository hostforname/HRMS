<%@page import="com.hrms.bean.Staff"%>
<%@page import="com.hrms.dao.StaDao"%>
<%@page import="com.hrms.bean.Department"%>
<%@page import="com.hrms.dao.DepartDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>
</head>
<body>
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->

</head>

<body>
	<div>
	<div class="admin-biaogelist" style="margin-top: 0px;margin-left: 0px;">
		<div class="listbiaoti am-cf">
		  <ul class="am-icon-flag on">
			员工管理
		  </ul>
		  <dl class="am-icon-home" style="float: right;">
			当前位置： 首页 > <a href="staff.jsp">员工列表</a>
		  </dl>
		  <dl>
			<a href="addStaffInfo.jsp"><button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-am-modal="{target: '#my-popup'}">添加员工</button></a>
		  </dl>
		  <!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束--> 
		  
		</div>
		<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
			<ul>
				<li>员工查询：</li>
					<%
						String depart=null;
						DepartDao ddao=new DepartDao(); 
						ArrayList<Department> deps=ddao.getDepart();
						for(Department dep:deps){
					%>
					<li><a href="staff.jsp?depart=<%=dep.getDepartment().replace("#", "%23") %>"><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;"><%=dep.getDepartment() %></button></a></li>
					<%
						}
					%>
			</ul>
			<a style="margin-right: 0px" href="staff.jsp"><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">员工全部查询</button></a>
		</div>
		<form class="am-form am-g">
		  <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
			<thead>
			  <tr class="am-success">
				<th class="table-type am-text-center">员工编号</th>
				<th class="table-type am-text-center">姓名</th>
				<th class="table-type am-text-center">性别</th>
				<th class="table-type am-text-center">部门</th>
				<th class="table-type am-text-center">工种</th>
				<th class="table-type am-text-center">学历</th>
				<th class="table-type am-text-center">参加工作时间</th>								
				<th class="table-type am-text-center">操作</th>
			  </tr>
			</thead>
			<tbody>
				<%
					StaDao sdao=new StaDao();
					ArrayList<Staff> stas=sdao.getStaff();
					depart=request.getParameter("depart");
					//System.out.println(depart);
					if(depart!=null){
						//System.out.println("if第一层"+depart);
						for(Staff sta:stas){
							if(sta.getDepartment().equals(depart)){
								//System.out.println("if第二层"+depart);
				%>
								<tr align="center">
										<td><%=sta.getStaffid() %></td>
										<td><%=sta.getStaffname() %></td>
										<td><%=sta.getSex() %></td>
										<td><%=sta.getDepartment() %></td>
										<td><%=sta.getWorktype() %></td>
										<td><%=sta.getEducation() %></td>
										<td><%=sta.getWorktime() %></td>
										<td class="am-text-center">
											<div style="margin:0 auto;">
												<div class="am-btn-group am-btn-group-xs" style="margin:0 auto;">
													
													<a href="TransferStaSer?staid=<%=sta.getStaffid()%>&stana=<%=sta.getStaffname() %>&stase=<%=sta.getSex() %>
														&stade=<%=sta.getDepartment().replace("#", "%23") %>&stawty=<%=sta.getWorktype() %>
														&staed=<%=sta.getEducation() %>&stawtm=<%=sta.getWorktime() %>" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改"><span class="am-icon-pencil-square-o" ></span></a>
													<a href="RemoveStaSer?staid=<%=sta.getStaffid()%>" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  title="删除"><span class="am-icon-trash-o"></span></a>
												</div>
											</div>
										</td>
								</tr>
				<%
							}
						}
					}else{
						//System.out.println("else第一层"+depart);
						for(Staff sta:stas){
				%>
						<tr align="center">
							<td><%=sta.getStaffid() %></td>
							<td><%=sta.getStaffname() %></td>
							<td><%=sta.getSex() %></td>
							<td><%=sta.getDepartment() %></td>
							<td><%=sta.getWorktype() %></td>
							<td><%=sta.getEducation() %></td>
							<td><%=sta.getWorktime() %></td>
							<td class="am-text-center">
									<div style="margin:0 auto;">
										<div class="am-btn-group am-btn-group-xs" style="margin:0 auto;">
											
											<a href="TransferStaSer?staid=<%=sta.getStaffid()%>&stana=<%=sta.getStaffname() %>&stase=<%=sta.getSex() %>
												&stade=<%=sta.getDepartment().replace("#", "%23") %>&stawty=<%=sta.getWorktype() %>
												&staed=<%=sta.getEducation() %>&stawtm=<%=sta.getWorktime() %>" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改"><span class="am-icon-pencil-square-o" ></span></a>
											<a href="RemoveStaSer?staid=<%=sta.getStaffid()%>" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  title="删除"><span class="am-icon-trash-o"></span></a>
										</div>
									</div>
								</td>
				<%
							}
						}
				%>
					
			</tbody>
		  </table>
		  
		  <ul class="am-pagination am-fr">
			<li class="am-disabled"><a href="#">«</a></li>
			<li class="am-active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">»</a></li>
		  </ul>
		  <hr/>
		   <a class="am-icon-pencil-square-o am-text-secondary" title="修改"> 修改</a> 
		   <a class="am-icon-trash-o am-text-danger" title="删除"> 删除</a>		  
		</form>
	  </div>
	</div>
</body>
</html>