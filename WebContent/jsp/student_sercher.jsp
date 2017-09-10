<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css" />
<script
	src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
</head>
<body>


<!--头部导航条开始-->
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
					<a class="navbar-brand" href="#">教务管理系统</a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;学生管理 </a>
						</li>
						<li>
							<a href="#"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;班级管理</a>
						</li>
						<li>
							<a href="#"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理 </a>
						</li>
						<li>
							<a href="#"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;教务管理</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">

						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a href="#">Separated link</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!--头部导航条结束-->
		<div class="container">

			<div class="row">
				<div class="col-md-2">
					<div class="list-group">
						<a href="${pageContext.request.contextPath}/student?method=pageList" class="list-group-item ">
							学生管理
						</a>
						<a href="${pageContext.request.contextPath}/student?method=getSercherPage"" class="list-group-item active">学生搜索</a>
						<a href="${pageContext.request.contextPath}/student?method=getAddPage" class="list-group-item">学生添加</a>
					</div>
				</div>
				<div class="col-md-10">
					<div>

						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" >
								<a href="${pageContext.request.contextPath}/student?method=pageList" >学生列表</a>
							</li>
							<li role="presentation" class="active">
								<a href="${pageContext.request.contextPath}/student?method=getSercherPage" >学生搜索</a>
							</li>
							<li role="presentation">
								<a href="${pageContext.request.contextPath}/student?method=getAddPage" >学生添加</a>
							</li>
						</ul>
					</div>
					
					<form
		action="${pageContext.request.contextPath}/student?method=selectByCondition"
		method="post">
		<div class="col-lg-6">
			<div class="input-group" width="150">
				<input type="text" class="form-control" placeholder="学生id" name="id">
				<input type="text" class="form-control" placeholder="学生姓名"
					name="name"> <input type="text" class="form-control"
					placeholder="学生年龄" name="age"> </span> </span> <input type="text"
					class="form-control" placeholder="学生地址" name="address"> <span
					class="input-group-btn">
					<button class="btn btn-primary" type="submit">查询</button>
				</span>
			</div>
			<button class="btn btn-default dropdown-toggle" type="button"
				id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true">
				性别 <select name="gender">
					<option value="">不限
					<option value="男">男
					<option value="女">女
				</select>
			</button>
		</div>
	</form>
					
					
				</div>
			</div>
		</div>







	
</body>
</html>