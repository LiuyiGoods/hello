<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="utf-8" />
		<title>xxx餐饮后台管理系统</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ace-skins.min.css" />
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							xxx餐饮后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="xh-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${pageContext.request.contextPath}/resources/images/user.png" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎,</small>
									${loginUser.userName}
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										基本信息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#" id="logout-btn">
										<i class="icon-off"></i>
										注销
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					

					<ul class="nav nav-list" id="menu-list">
						<c:forEach var="category" items="${loginUser.menuList}" varStatus="st">
							<li>
								<a href="#" class="dropdown-toggle">
									<i class="icon-desktop"></i>
									<span class="menu-text" id="category_${st.index}"> ${category.name} </span>
									<b class="arrow icon-angle-down"></b>
								</a>
								<ul class="submenu">
									<c:forEach var="menu" items="${category.children }">
										<li>
											<a href="javascript:void(0)" data-url="${menu.url}" data-category="category_${st.index}" class="menu-click">
												<i class="icon-double-angle-right"></i>
												${menu.name}
											</a>
										</li>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li id="category"></li>
							<li class="active" id="menu"></li>
						</ul><!-- .breadcrumb -->
					</div><!-- /.page-content -->
					<div style="overflow: auto;"><iframe id="contentPanel" width="100%" height="800px" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/ace.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/manageUI/config.js"></script>
</body>
</html>
