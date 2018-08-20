<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>产品列表</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/layer/skin/default/layer.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/bootstrap-table/bootstrap-table.css" />
</head>
<body>
	<div style="margin-left: auto;margin-right: auto;width: 95%">
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-12">
					<div style="position: absolute;top:15px" id="btns">
							<a href="#" id="querybtn" class="btn btn-danger btn-sm" data-code="user:delete">
								<i class="icon-trash"></i>查询
							</a>
						
					</div>
						<table id="table"></table>
				</div>
			</div>
		</div>
	</div>
</div>	
<%@ include file="../common.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/product/list.js"></script>
</body>
</html>