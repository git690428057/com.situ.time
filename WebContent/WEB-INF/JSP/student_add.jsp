<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css" />
<script
	src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	
</script>
</head>
<body>


	<!--头部导航条开始-->
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">教务管理系统</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active">
				    <a href="${pageContext.request.contextPath}/student?method=pageList">
				       <span class="glyphicon glyphicon-user">
				       </span>&nbsp;&nbsp;学生管理 
				    </a>
				</li>
				<li>
				    <a href="${pageContext.request.contextPath}/student?method=getClassInformation">
				      <span class="glyphicon glyphicon-home">
				      </span>&nbsp;&nbsp;班级管理
				    </a>
				</li>
				<li>
				     <a href="${pageContext.request.contextPath}/student?method=getClass_CourseInformation">
				       <span class="glyphicon glyphicon-list-alt">
				       </span>&nbsp;&nbsp;课程管理
				     </a>
			    </li>
				<li>
				      <a href="#">
				           <span class="glyphicon glyphicon-tags">
				           </span>&nbsp;&nbsp;教务管理
				      </a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin 
				      <span class="caret"></span>
				    </a>
					<ul class="dropdown-menu">
						<li><a href="#">修改密码</a></li>
						<li><a href="#">回到主页</a></li>
						<li><a href="#">回到主页</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">联系我们</a></li>
					</ul>
				</li>
				<li>
				     <a href="${pageContext.request.contextPath}/loginOutServlet">
				          <span class="glyphicon glyphicon-off">
				          </span>&nbsp;&nbsp;退出
				     </a>
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
					<a href="${pageContext.request.contextPath}/student?method=pageList"
						class="list-group-item "> 学生管理 
					</a> 
				    <a href="${pageContext.request.contextPath}/student?method=getAddPage"
						class="list-group-item active">学生添加
				    </a>
				</div>
			</div>
			<div class="col-md-10">
				<div>
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation">
						   <a href="${pageContext.request.contextPath}/student?method=pageList">学生列表
						   </a>
						</li>
						<li role="presentation" class="active">
						   <a href="${pageContext.request.contextPath}/student?method=getAddPage">学生添加
						   </a>
						</li>
					</ul>
				</div>
				<form class="form-horizontal" action="/qw/student?method=addStudent"
					method="post">
					<div class="form-group">
						<label class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="name" id="name">
							<span id="nameInfo"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">年龄</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="age">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">性别</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="gender">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">地址</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="address">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">生日</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="birthday">
						</div>
					</div>
					<input type="submit" value="添加">
			</div>
			</form>
		</div>
   	</div>
  </div>
</body>
</html>