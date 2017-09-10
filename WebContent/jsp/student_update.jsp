<%@page import="java.util.List"%>
<%@page import="POJO.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.css" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.a {
	position: relative;
	top: -150px;
	left: 80px;
}
</style>
</head>
<body>

	<%-- 	</form>
	<%
		List<Student> list = (List<Student>) request.getAttribute("student");
	%>
	<form action="/qw/updateStudent.do" method="post">
		<%
			for (Student student : list) {
		%>
		id<input type="text" value="<%=student.getId()%>" name="id"><br>
		姓名<input type="text" value="<%=student.getAge()%>" name="name"><br>
		年龄<input type="text" value="<%=student.getAge()%>" name="age"><br>
		性别<input type="text" value="<%=student.getGender()%>" name="gender"><br>
		地址<input type="text" value="<%=student.getAddress()%>" name="address"><br>
		生日<input type="text" value="<%=student.getBirthday()%>"
			name="birthday"><br>
		<%
			}
		%>
		<input type="submit" value="确认修改">
	</form> --%>



	<%-- <%
		List<Student> list = (List<Student>) request.getAttribute("list");
	%> --%>



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
						<a href="${pageContext.request.contextPath}/student?method=getSercherPage" class="list-group-item">学生搜索</a>
						<a href="${pageContext.request.contextPath}/student?method=getAddPage" class="list-group-item">学生添加</a>
					</div>
				</div>
				<div class="col-md-10">
					<div>

						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active">
								<a href="${pageContext.request.contextPath}/student?method=pageList">学生列表</a>
							</li>
							<li role="presentation">
								<a href="${pageContext.request.contextPath}/student?method=getSercherPage">学生搜索</a>
							</li>
							<li role="presentation">
								<a href="${pageContext.request.contextPath}/student?method=getAddPage">学生添加</a>
							</li>
						</ul>
					</div>










	<form class="form-horizontal" action="${pageContext.request.contextPath}/student?method=updateStudent"
		method="post">
		<%-- <%
			for (Student student : list) {
		%> --%>
		<c:forEach items="${list }" var="student">
	
		<div class="form-group">
			<label class="col-sm-2 control-label">id</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" value="${student.id }"
					name="id" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.name }" name="name">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">年龄</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.age }" name="age">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.gender }" name="gender">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.address }" name="address">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">生日</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.birthday }" name="birthday">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">班级</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.className }" name="className">
			</div>
		</div>
		</c:forEach>
		<%-- <%
			}
		%> --%>
		<button type="submit" >确认修改</button>
	</form>

</div>
			</div>
		</div>



</body>
</html>