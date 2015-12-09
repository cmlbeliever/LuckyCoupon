<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:getAsString name="title"></tiles:getAsString> </title>
		<!-- 包含css与js -->
		<jsp:include page="/WEB-INF/jsp/base/base.jsp"></jsp:include>
	</head>
<body>
	<!-- start: Header -->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<!-- start: Header -->
	
	<div class="container-fluid-full">
		<div class="row-fluid">
				<!-- start: Main Menu -->
					<tiles:insertAttribute name="menu"></tiles:insertAttribute>
				<!-- end: Main Menu -->
				
				<noscript>
					<div class="alert alert-block span10">
						<h4 class="alert-heading">Warning!</h4>
						<p>哈哈 你什么的 <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
					</div>
				</noscript>
				
				<!-- start: Content -->
			<div id="content" class="span10">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
				<!-- end: Content -->
			</div><!--/#content.span10-->
		</div><!--/fluid-row-->
	</div><!--/.fluid-container-->
	
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>设置</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	
	<div class="clearfix"></div>
	<footer>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</footer>
</body>
</html>