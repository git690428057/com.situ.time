<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css" />
<script src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
	function selectall() {
		$("input[name=selectIds]").prop("checked",$("#selectAll").is(":checked"));
	}
	function deleteAll() {
		$("#mainForm").attr("action","${pageContext.request.contextPath}/student?method=deleteAll");
		$("#mainForm").submit();
	}
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
						class="list-group-item active"> 学生管理 
					</a> 
				    <a href="${pageContext.request.contextPath}/student?method=getAddPage"
						class="list-group-item">学生添加
				    </a>
				</div>
			</div>
			<div class="col-md-10">
				<div>
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
						   <a href="${pageContext.request.contextPath}/student?method=pageList">学生列表
						   </a>
						</li>
						<li role="presentation">
						   <a href="${pageContext.request.contextPath}/student?method=getAddPage">学生添加
						   </a>
						</li>
					</ul>
				</div>
				
					<!-- 多条件查询  -->
					<form action="${pageContext.request.contextPath}/student?method=selectByCondition" method="post">
						<div class="col-lg-6">
							<div class="input-group" width="150">
								<input type="text" class="form-control" placeholder="学生id" name="id">
							    <input type="text" class="form-control" placeholder="学生姓名" name="name">
							    <input type="text" class="form-control" placeholder="学生年龄" name="age"> 
							    <input type="text" class="form-control" placeholder="学生地址" name="address">
							    <input type="text" class="form-control" placeholder="出生日期区间开始" name="startBirthday">
							    <input type="text" class="form-control" placeholder="出生日期区间结束" name="endBirthday">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="submit">查询</button>
								</span>
							</div>
							<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
								性别 <select name="gender">
									  <option value="">不限
									  <option value="男">男
									  <option value="女">女
								   </select>
							</button>
							<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
								班级 <select name="gender">
									  <option value="">不限
									  <option value="1">JAVA
									  <option value="2">HTML
									  <option value="3">UI
								   </select>
							</button>
						</div>
					</form>

                
	                 
	                 
				<!-- bootstrap列表展示数据库所有学生信息 -附删除(直接执行deleteStudent方法)和修改(提取当前id的学生信息转发到jsp页面toUpdateStudent)按钮 -->
				<form id="mainForm" action="" method="post">
					<table class="table table-hover table-bordered">
						<tr>
							<td>
							    <input type="checkbox" onclick="selectall();" id="selectAll">
							</td>
							<td>编号</td>
							<td>姓名</td>
							<td>年龄</td>
							<td>性别</td>
							<td>地址</td>
							<td>生日</td>
							<td>班级</td>
							<td colspan="2">操作选择</td>
						</tr>
						<c:forEach var="student" items="${list }">
							<tr>
								<td><input type="checkbox" name="selectIds"
									value="${student.id }"></td>
								<td>${student.id }</td>
								<td>${student.name }</td>
								<td>${student.age }</td>
								<td>${student.gender }</td>
								<td>${student.address }</td>
								<td>${student.birthday }</td>
								<td>${student.className }</td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=deleteStudent&id=${student.id }"><input
										type="button" value="删除" class="btn btn-danger"></a></td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=toUpdateStudent&id=${student.id }"><input
										type="button" value="修改" class="btn btn-info"></a></td>
							</tr>
						</c:forEach>
					</table>
				</form>

                <!-- 批量删除学生按钮 执行JS:deleteAll()方法-->
	                 <button onclick="deleteAll();" class="btn btn-primary">批量删除</button>
				<!-- 分页开始 -->
			<nav aria-label="Page navigation">
				<ul class="pagination pagination-lg">
					<li>
					    <c:if test="${pageBean.pageIndex==1}">
							<li class="disabled">
							    <a href="javascript:void(0);" aria-label="Previous"> 
								     <span aria-hidden="true">&laquo;
								     </span>
							    </a>
							</li>
						</c:if> 
						<c:if test="${pageBean.pageIndex!=1}">
							<a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${pageBean.pageIndex -1 }" aria-label="Previous"> 
								 <span aria-hidden="true">&laquo;
								 </span>
							</a>
						</c:if>
					</li>
					<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
						<c:if test="${pageBean.pageIndex!=page }">
							<li>
							   <a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${page }">${page }</a>
							</li>
						</c:if>
						<c:if test="${pageBean.pageIndex==page }">
							<li class="active">
							   <a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${page }">${page }</a>
							</li>
						</c:if>
					</c:forEach>
					<li>
					    <c:if test="${pageBean.pageIndex==pageBean.totalPage}">
							<li class="disabled">
							    <a href="javascript:void(0);"
								aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
							    </a>
							</li>
						</c:if> <c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
							<a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${pageBean.pageIndex +1 }" aria-label="Next"> 
								<span aria-hidden="true">&raquo;
								</span>
							</a>
						</c:if>
					</li>
				</ul>
			</nav>
				<!-- 分页结束 -->
			</div>
		</div>
	</div>
</body>
</html>