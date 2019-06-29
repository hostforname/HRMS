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
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->

</head>

<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="assets/i/logo.png"></div>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
      <li class="kuanjie">
        <a href="department.jsp" target="ifrpage">部门管理</a>          
        <a href="staff.jsp" target="ifrpage">员工管理</a> 
        <a href="recruit.jsp" target="ifrpage">招聘管理</a>   
        <a href="train.jsp" target="ifrpage">培训管理</a> 
        <a href="rewpun.jsp" target="ifrpage">奖惩管理</a> 
        <a href="salary.jsp" target="ifrpage">薪酬管理</a>
        <a href="user.jsp" target="ifrpage">系统管理</a>
      </li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main"> 

	<div class="nav-navicon admin-main admin-sidebar">
		<%
			
			String name=null;
			if(request.getParameter("name")!=null){
				name=request.getParameter("name");
			}else{
				name=request.getAttribute("name")+"";
			}
			 
		
		%>
    	<div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：<%=name %></div>
   		<div class="sideMenu">
      		<h3 class="am-icon-flag"><em></em> <a href="department.jsp" target="ifrpage">部门管理</a></h3>
			  <ul>
				<li><a href="addDepInfo.jsp" target="ifrpage">添加部门</a></li>
				<li></li>
				<li></li>
				<li></li>
				<li> </li>
			  </ul>
			<h3 class="am-icon-flag"><em></em> <a href="staff.jsp" target="ifrpage">员工管理</a></h3>
			  <ul>
				<li><a href="addStaInfo.jsp" target="ifrpage">添加员工</a></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			  </ul>
			<h3 class="am-icon-flag"><em></em> <a href="recruit.jsp" target="ifrpage">招聘管理</a></h3>
			  <ul>
				<li><a href="addRecInfo.jsp" target="ifrpage">添加应聘人信息</a></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			  </ul>
			<h3 class="am-icon-flag"><em></em> <a href="train.jsp" target="ifrpage">培训管理</a> </h3>
			  <ul>
				<li><a href="addTraInfo.jsp" target="ifrpage">添加培训信息</a></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			  </ul>
			<h3 class="am-icon-flag"><em></em> <a href="rewpun.jsp" target="ifrpage">奖惩管理</a> </h3>
			  <ul>
				<li><a href="addRewInfo.jsp" target="ifrpage">添加奖惩信息</a></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			  </ul>
			<h3 class="am-icon-flag"><em></em> <a href="salary.jsp" target="ifrpage">薪酬管理</a></h3>
			  <ul>
				<li><a href="addSalInfo.jsp" target="ifrpage">添加薪资信息</a></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			  </ul>
			<h3 class="am-icon-gears"><em></em> <a href="user.jsp" target="ifrpage">系统管理</a></h3>
			  <ul>
				<li><a href="updateUser.jsp?name=<%=name %>" target="ifrpage">用户修改</a></li>
				<li><a href="addUser.jsp" target="ifrpage">添加管理员</a></li>
				<li><a href="login.html">安全退出</a></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			  </ul>
    	</div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script> 

    
    
    
    
    
    
    
	</div>

	<div class=" admin-content">
		
			<div class="daohang">
				<ul>
					<li><a href="hrmshome.jsp?name=<%=name %>"><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页 </button></a></li>
					
				</ul>	
			</div>
		
	</div>


	<div class="admin"> 
		<div class="admin-biaoge">
		  <div class="xinxitj"></div>     
		</div>
		 <div class="slideTxtBox" style="margin-top:10px; height:80%">     
			<iframe src="home.jsp" id="ifrpage" name="ifrpage" width="100%" height="100%;" scrolling="no"> </iframe>
		 </div>
		  <script type="text/javascript">jQuery(".slideTxtBox").slide();</script> 
		  <div class:"foods" style="margin-top:145px; background-color:#2a3542; height:4%; color:#fff">
		  	<center><ul>版权所有@2019</ul></center>
		</div>  
	</div>
	
	

</div>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]--> 

<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->



</body>
</html>