<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>登录系统</title>
	<!-- 引用WarJar中的静态资源-->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
	<script type="text/javascript" src="/webjars/jquery/jquery.js"></script>
	<script type="text/javascript" src="/webjars/popper.js/umd/popper.min.js"></script>
	<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<img src="/logo.png"
		 class="rounded mx-auto d-block"><h4>用户登录</h4>
	<c:if test="${error != null}">
	<div class="alert alert-danger">${error}</div>
	</c:if>
	<form method="post" action="/login">
		<div class="form-group row">
			<label for="username" class="col-sm-3 col-form-label">用户名：</label>
			<div class="col-sm-9">
				<input type="text" id="username" name="username"
					   class="form-control" placeholder="输入用户名">
			</div>
		</div>
		<div class="form-group row">
			<label for="pass" class="col-sm-3 col-form-label">密码：</label>
			<div class="col-sm-9">
				<input type="password" id="pass" name="pass"
					   class="form-control" placeholder="输入密码">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-6 text-right">
				<button type="submit" class="btn btn-primary">登录</button>
			</div>
			<div class="col-sm-6">
				<button type="reset" class="btn btn-danger">重设</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>
