<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	<jsp:include page="/WEB-INF/jsp/base/base.jsp"></jsp:include>
</head>

<body>
		<div class="container-fluid-full">
		<div class="row-fluid">
					
			<div class="row-fluid">
				<div class="login-box">
					<div class="icons">
						<a href="javascript:void(0)"><i class="halflings-icon home"></i></a>
						<a href="javascript:void(0)"><i class="halflings-icon cog"></i></a>
					</div>
					<h2>XXX系统后台登陆</h2>
					
					<spring:errors cssClass="btn btn-primary"  path="user.*" />	
					
					<form class="form-horizontal" action="<s:url value="/user/login.mvc"/>" method="post">
						<fieldset>
							<div class="input-prepend" title="Username">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="username" id="username" value="${user.username }" type="text" placeholder="type username"/>
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10" name="password" id="password" value="${user.password }"  type="password" placeholder="type password"/>
							</div>
							<div class="clearfix"></div>
							
							<label class="remember" for="remember"><input type="checkbox" id="remember" name="remember" />记住密码</label>

							<div class="button-login">	
								<button type="submit" class="btn btn-primary">登陆</button>
							</div>
							<div class="clearfix"></div>
					</form>
					<hr>
					<h3>忘记密码?</h3>
					<p>
						No problem, <a href="#">click here</a> to get a new password.
					</p>	
				</div><!--/span-->
			</div><!--/row-->
			

	</div>
	
		</div>
	

	
</body>
</html>
