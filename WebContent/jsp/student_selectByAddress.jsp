<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form class="form-horizontal" action="${pageContext.request.contextPath}/student?method=pageList" method="post">
		<c:forEach var="student" items="${list }">
		<div class="form-group">
			<label class="col-sm-2 control-label">id</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" value="${student.id }"
					readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.name }" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">年龄</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.age }" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.gender }" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.address }" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">生日</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.birthday }" readonly>
			</div>
		</div>
		</c:forEach>
		<button type="submit" class="a btn btn-default">返回学生列表主页</button>
	</form>




</body>
</html>