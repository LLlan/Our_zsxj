<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 

<!DOCTYPE html> 
<html> 
<head> 
  <meta charset="utf-8"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
  <title>掌上巡检</title> 
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" /> 
  
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" /> 
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> 
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css"> 
  <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css"> 
  <link rel="stylesheet" type="text/css" media="screen" href="plugins/treegrid/styles/jqx.base.css" /> 
  <link rel="stylesheet" type="text/css" media="screen" href="plugins/treegrid/styles/jqx.bootstrap.css" /> 
	
  <!--[if lt IE 9]> 
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script> 
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script> 
  <![endif]--> 
</head> 
 
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper"> 
		<!-- Main Header --> 
		<header class="main-header"> 
 
			<!-- Logo --> 
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> 
				<span class="logo-mini"><b>巡检</b></span> <!-- logo for regular state and mobile devices --> 
				<span class="logo-lg"><b>掌上巡检</b></span> 
			</a> 
 
			<!-- Header Navbar --> 
			<nav class="navbar navbar-static-top" role="navigation"> 
				<!-- Sidebar toggle button--> 
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas" 
					role="button"> <span class="sr-only">切换左侧按钮</span> 
				</a> 
				<!-- Navbar Right Menu --> 
				<div class="navbar-custom-menu"> 
					<ul class="nav navbar-nav"> 
						<!-- Messages: style can be found in dropdown.less--> 
						<li class="dropdown messages-menu"> 
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle" 
							data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span 
								class="label label-success">4</span> 
						</a> 
							<ul class="dropdown-menu"> 
								<li class="header">你有4个未读消息</li> 
								<li> 
									<!-- inner menu: contains the messages --> 
									<ul class="menu"> 
										<li> 
											<!-- start message --> <a href="#"> 
												<div class="pull-left"> 
													<!-- User Image --> 
													<img src="${ctx}/dist/img/user2-160x160.jpg" 
														class="img-circle" alt="User Image"> 
												</div> <!-- Message title and timestamp --> 
												<h4> 
													团队 <small><i class="fa fa-clock-o"></i> 5 mins</small> 
												</h4> <!-- The message --> 
												<p>海口，重庆中心的同学们，大家好！</p> 
										</a> 
										</li> 
										<!-- end message --> 
									</ul> <!-- /.menu --> 
								</li> 
								<li class="footer"><a href="#">查看所有消息</a></li> 
							</ul> 
						</li> 
						<!-- /.messages-menu --> 
 
						<!-- Notifications Menu --> 
						<li class="dropdown notifications-menu"> 
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle" 
							data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span 
								class="label label-warning">10</span> 
						</a> 
							<ul class="dropdown-menu"> 
								<li class="header">你有10条提示</li> 
								<li> 
									<!-- Inner Menu: contains the notifications --> 
									<ul class="menu"> 
										<li> 
											<!-- start notification --> <a href="#"> <i 
												class="fa fa-users text-aqua"></i> 5 位同学新加入我们 
										</a> 
										</li> 
										<!-- end notification --> 
									</ul> 
								</li> 
								<li class="footer"><a href="#">查看所有</a></li> 
							</ul> 
						</li> 
						<!-- Tasks Menu --> 
						<li class="dropdown tasks-menu"> 
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle" 
							data-toggle="dropdown"> <i class="fa fa-flag-o"></i> <span 
								class="label label-danger">9</span> 
						</a> 
							<ul class="dropdown-menu"> 
								<li class="header">你有9个任务</li> 
								<li> 
									<!-- Inner menu: contains the tasks --> 
									<ul class="menu"> 
										<li> 
											<!-- Task item --> <a href="#"> <!-- Task title and progress text --> 
												<h3> 
													作业制定计划 <small class="pull-right">20%</small> 
												</h3> <!-- The progress bar --> 
												<div class="progress xs"> 
													<!-- Change the css width attribute to simulate progress --> 
													<div class="progress-bar progress-bar-aqua" 
														style="width: 20%" role="progressbar" aria-valuenow="20" 
														aria-valuemin="0" aria-valuemax="100"> 
														<span class="sr-only">已经完成 20% </span> 
													</div> 
												</div> 
										</a> 
										</li> 
										<!-- end task item --> 
									</ul> 
								</li> 
								<li class="footer"><a href="#">查看所有任务</a></li> 
							</ul> 
						</li> 
						<!-- User Account Menu --> 
						<li class="dropdown user user-menu"> 
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle" 
							data-toggle="dropdown"> <!-- The user image in the navbar--> 
								<img src="dist/img/user2-160x160.jpg" class="user-image" 
								alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. --> 
								<span class="hidden-xs">James</span> 
						</a> 
							<ul class="dropdown-menu"> 
								<!-- The user image in the menu --> 
								<li class="user-header"><img 
									src="${ctx}/dist/img/user2-160x160.jpg" class="img-circle" 
									alt="User Image"> 
									<p> 
										James - 开发工程师 <small>出山10年，哈哈</small> 
									</p></li> 
								<!-- Menu Body --> 
								<li class="user-body"> 
									<div class="col-xs-4 text-center"> 
										<a href="#">赞一个</a> 
									</div> 
									<div class="col-xs-4 text-center"> 
										<a href="#">工作</a> 
									</div> 
									<div class="col-xs-4 text-center"> 
										<a href="#">好友</a> 
									</div> 
								</li> 
								<!-- Menu Footer--> 
								<li class="user-footer"> 
									<div class="pull-left"> 
										<a href="#" class="btn btn-default btn-flat">设置</a> 
									</div> 
									<div class="pull-right"> 
										<a href="#" class="btn btn-default btn-flat">退出</a> 
									</div> 
								</li> 
							</ul> 
						</li> 
						<!-- Control Sidebar Toggle Button --> 
						<li><a href="#" data-toggle="control-sidebar"><i 
								class="fa fa-gears"></i></a></li> 
					</ul> 
				</div> 
			</nav> 
		</header> 
		<!-- Left side column. contains the logo and sidebar --> 
		<aside class="main-sidebar"> 
 
			<!-- sidebar: style can be found in sidebar.less --> 
			<section class="sidebar"> 
 
				<!-- Sidebar user panel (optional) --> 
				<div class="user-panel"> 
					<div class="pull-left image"> 
						<img src="dist/img/user2-160x160.jpg" class="img-circle" 
							alt="User Image"> 
					</div> 
					<div class="pull-left info"> 
						<p>James</p> 
						<!-- Status --> 
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a> 
					</div> 
				</div> 
 
				<!-- search form (Optional) --> 
				<form action="#" method="get" class="sidebar-form"> 
					<div class="input-group"> 
						<input type="text" name="q" class="form-control" 
							placeholder="Search..."> <span class="input-group-btn"> 
							<button type="submit" name="search" id="search-btn" 
								class="btn btn-flat"> 
								<i class="fa fa-search"></i> 
							</button> 
						</span> 
					</div> 
				</form> 
				<!-- /.search form --> 
 
				<!-- Sidebar Menu --> 
				<ul class="sidebar-menu"> 
					<li class="header">掌上巡检</li> 
					<!-- Optionally, you can add icons to the links --> 
					<li class="treeview"><a href="#"><i class="fa fa-pencil"></i> 
							<span>作业计划制定</span> <i class="fa fa-angle-left pull-right"></i></a> 
						<ul class="treeview-menu"> 
							<li><a href="${ctx}/Our_zsxj/workplan/list.jsp"><i
									class="fa fa-edit"></i>专业工作计划</a></li>
							<li><a href="${ctx}/Our_zsxj/projectplan/list.jsp"><i
									class="fa fa-edit"></i>工程随工计划</a></li>
						</ul></li> 
						
						<li class="treeview"><a href="#"><i class="fa fa-pencil"></i> 
							<span>作业计划执行</span> <i class="fa fa-angle-left pull-right"></i></a> 
						<ul class="treeview-menu"> 
							<li><a href="${ctx}/Our_zsxj/wrokplanexec/list.jsp"><i
									class="fa fa-edit"></i>专业工作计划</a></li>
							<li><a href="${ctx}/Our_zsxj/projectplanexec/list.jsp"><i
									class="fa fa-edit"></i>工程随工计划</a></li>
						</ul></li> 
						
						<li class="treeview"><a href="#"><i class="fa fa-arrows"></i> 
							<span>工单管理</span> <i class="fa fa-angle-left pull-right"></i></a> 
						<ul class="treeview-menu"> 
							<li><a href="${ctx }/Our_zsxj/worklist/list.jsp"><i
									class="fa fa-th-list"></i>工单列表</a></li>

						</ul></li> 
						
						<li class="treeview"><a href="#"><i class="fa fa-desktop"></i> 
							<span>现场管理</span> <i class="fa fa-angle-left pull-right"></i></a> 
						<ul class="treeview-menu"> 
							<li><a href="${ctx}/Our_zsxj/macroomcheck/list.jsp"><i
									class="fa fa-laptop"></i>机房日常巡检</a></li>
							<li><a href="${ctx}/Our_zsxj/hindercheck/list.jsp"><i
									class="fa fa-warning"></i>障碍处理</a></li>
							<li><a href="${ctx}/opencheck/list.jsp"><i
									class="fa fa-street-view"></i>开通管理</a></li>
							<li><a href="${ctx}/Our_zsxj/designcheck/list.jsp"><i
									class="fa fa-gears"></i>设计管理</a></li>
							<li><a href="${ctx}/Our_zsxj/supervisorcheck/list.jsp"><i
									class="fa fa-cog"></i>监理管理</a></li>
							<li><a href="${ctx}/Our_zsxj/buildcheck/list.jsp"><i
									class="fa fa-wrench"></i>施工管理</a></li>
							<li><a href="${ctx}/Our_zsxj/adormcheck/list.jsp"><i
									class="fa fa-plus-square"></i>装维管理 </a></li>
							
						</ul></li> 
						
						
						<li class="treeview"><a href="#"><i class="fa fa-gears"></i> 
							<span>系统设置</span> <i class="fa fa-angle-left pull-right"></i></a> 
						<ul class="treeview-menu"> 
							<li><a href="${ctx}/Our_zsxj/base/module/list.jsp"><i
									class="fa fa-th"></i>模块管理</a></li>
							<li><a href="${ctx}/Our_zsxj/base/menus/list.jsp"><i
									class="fa fa-th-large"></i>菜单管理</a></li>
							<li><a href="${ctx}/Our_zsxj/base/usersbranch/list.jsp"><i
									class="fa fa-gg"></i>部门管理</a></li>
							<li><a href="${ctx}/Our_zsxj/base/usersrole/list.jsp">
								<i class="fa fa-user-md"></i>角色管理</a></li>
							<li><a href="${ctx}/Our_zsxj/base/users/list.jsp"><i
									class="fa fa-user"></i>人员管理</a></li>
							<li><a href="${ctx}/Our_zsxj/base/userslog/list.jsp"><i
									class="fa fa-calendar-check-o"></i>日志管理</a></li>
							<li><a href="${ctx}/Our_zsxj/base/rolemenus/list.jsp"><i
									class="fa fa-male"></i>角色菜单管理</a></li>
							<li><a href="${ctx}/Our_zsxj/base/menusmodule/list.jsp"><i
									class="fa fa-windows"></i>菜单模块管理</a></li>
						</ul></li> 
				</ul> 
				<!-- /.sidebar-menu --> 
			</section> 
			<!-- /.sidebar --> 
		</aside> 
 
		<!-- Content Wrapper. Contains page content --> 
		<div class="content-wrapper"> 
			<!-- Content Header (Page header) --> 
			<section class="content-header"> 
				<h1>首页</h1> 
				<ol class="breadcrumb"> 
					<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li> 
				</ol> 
			</section> 
 
			<!-- Main content --> 
			<section class="content"> 
				<h1 align="center">欢迎使用掌上巡检系统！！！</h1>
			</section> 
			<!-- /.content --> 
		</div> 
		<!-- /.content-wrapper --> 
 
		<!-- Main Footer --> 
		<footer class="main-footer"> 
			<!-- To the right --> 
			<div class="pull-right hidden-xs">掌上巡检适用各种外勤，助您管理。</div> 
			<!-- Default to the left --> 
			<strong>Copyright &copy; 2015 <a href="#">掌上巡检</a>. 
			</strong> All rights reserved. 
		</footer> 
 
		<!-- Add the sidebar's background. This div must be placed 
           immediately after the control sidebar --> 
		<div class="control-sidebar-bg"></div> 
	</div> 
	
	<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script> 
	<!-- Bootstrap 3.3.5 --> 
	<script src="bootstrap/js/bootstrap.min.js"></script> 
	<script src="plugins/jQuery/jquery.bootstrap.min.js"></script> 
	<!-- AdminLTE App --> 
	<script src="dist/js/app.min.js"></script> 
	<script src="plugins/treegrid/jqxcore.js"></script>
    <script src="plugins/treegrid/jqxdata.js"></script>
    <script src="plugins/treegrid/jqxbuttons.js"></script>
    <script src="plugins/treegrid/jqxscrollbar.js"></script>
    <script src="plugins/treegrid/jqxdatatable.js"></script>
    <script src="plugins/treegrid/jqxtreegrid.js"></script>
</body> 
</html> 
 
