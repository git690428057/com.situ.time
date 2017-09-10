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
	<script type="text/javascript">
	function refreshImg() {
		$("#codeImg").attr("src","${pageContext.request.contextPath}/checkImg?"+Math.random());
	}
	</script>
</head>
<body>

	<form class="form-horizontal" action="/qw/loginServlet" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label">用户名:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" 
					placeholder="account" name="userName">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password" name="password">
			</div>
		</div>
		<label class="col-sm-2 control-label">验证码:</label>
		<input type="text" name="checkCode"> 
		<img id="codeImg" alt="" src="${pageContext.request.contextPath}/checkImg" onclick="refreshImg();">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> 记住用户
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
		
		
<!-- 		
	</form>
	<form action="/qw/loginServlet" method="post">
		用户名:<input type="text" name="userName"> 密码:<input
			type="password" name="password"><br>
		<button type="submit" class="btn btn-success">登陆</button>
	</form> -->
</body>
</html>