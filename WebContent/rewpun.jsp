<%@page import="com.hrms.bean.Rewpun"%>
<%@page import="com.hrms.dao.RewDao"%>
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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta name="description" content="这是一个 index 页面">
	<meta name="keywords" content="index">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="icon" type="image/png" href="assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="assets/css/amazeui.min.css" />
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
						奖惩管理
					</ul>
					<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 > <a href="rewpun.jsp">奖惩信息列表</a>
					</dl>
					<dl>
						<a href="addRewInfo.jsp"><button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"
							data-am-modal="{target: '#my-popup'}">添加奖惩信息</button></a>
					</dl>
					<!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束-->

				</div>
				<%
					String type=null;
				%>
				<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
					<ul>
						<li><a href="rewpun.jsp?type=1"><button type="button" class="am-btn am-radius am-btn-xs am-btn-success"
							style="margin-top: -1px;">奖励</button></a></li>
						<li><a href="rewpun.jsp?type=0"><button type="button" class="am-btn am-radius am-btn-xs am-btn-success"
							style="margin-top: -1px;">惩罚</button></a></li>
					</ul>
				</div>
				<form class="am-form am-g">
					<table width="100%"
						class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
						<thead>
							<tr class="am-success">
								<th class="table-type am-text-center">编号</th>
								<th class="table-type am-text-center">奖惩主题</th>
								<th class="table-type am-text-center">奖惩类型</th>
								<th class="table-type am-text-center">奖励金额</th>
								<th class="table-type am-text-center">奖励时间</th>
								<th class="table-type am-text-center">操作</th>
							</tr>
						</thead>
						<tbody>
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
													<div style="margin:0 auto;">
														<div class="am-btn-group am-btn-group-xs" style="margin:0 auto;">
															<a  href="TransferRewSer?rewid=<%=rew.getRewpunid() %>&rewtl=<%=rew.getRewpuntitle() %>&rewty=<%=rew.getRewpuntype() %>&rewmo=<%=rew.getRewpunmount() %>&rewtm=<%=rew.getRewpuntime() %>&rewdi=<%=rew.getDetainfo() %>" class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
																data-am-modal="{target: '#my-popups'}" title="详细信息"></a>	
															<a href="RemoveRewSer?rewid=<%=rew.getRewpunid()%>" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"
																title="删除"><span class="am-icon-trash-o"></span></a>
														</div>
													</div>
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
														<div style="margin:0 auto;">
															<div class="am-btn-group am-btn-group-xs" style="margin:0 auto;">
																<a  href="TransferRewSer?rewid=<%=rew.getRewpunid() %>&rewtl=<%=rew.getRewpuntitle() %>&rewty=<%=rew.getRewpuntype() %>&rewmo=<%=rew.getRewpunmount() %>&rewtm=<%=rew.getRewpuntime() %>&rewdi=<%=rew.getDetainfo() %>" class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
																	data-am-modal="{target: '#my-popups'}" title="详细信息"></a>	
																<a href="RemoveRewSer?rewid=<%=rew.getRewpunid()%>" class="am-btn am-btn-default am-btn-xs am-text-danger am-round"
																	title="删除"><span class="am-icon-trash-o"></span></a>
															</div>
														</div>
													</td>
												</tr>
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
					<hr />
					<a class="am-text-success am-icon-file" title="详细信息"> 详细信息</a>
					<a class="am-icon-trash-o am-text-danger" title="删除"> 删除</a>
				</form>
			</div>
		</div>
	</body>

</html>