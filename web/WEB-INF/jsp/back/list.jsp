<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<% String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String updatePath = basePath+"/servlet/UpdateData.action";
%>

<% int totalData = 0;%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
	<title>内容列表页面</title>
	<link href="<%=basePath%>/resources/css/all.css" rel="stylesheet" type="text/css" />
	<!--引用jquery和list.js-->
	<script src="<%=basePath%>/resources/js/common/jquery-1.8.0.min.js"></script>
	<script src="<%=basePath%>/resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="<%=basePath%>/servlet/list" id="mainForm" method="get">
	<input name="currentPage" type="hidden" id="currentPage" value="${page.currentPage}"/>
	<div class="right">
		<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
		<div class="rightCont">
			<p class="g_title fix">内容列表 <a class="btn03" href="javascript:addData('<%=basePath%>')">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:deleteBatch('<%=basePath%>')">删 除</a></p>
			<table class="tab1">
				<tbody>
				<tr>
					<td width="90" align="right">指令：</td>
					<td>
						<input type="text" name="command" class="allInput" value="${command}"/>
					</td>
					<td width="90" align="right">描述：</td>
					<td>
						<input type="text" name="description" class="allInput" value="${description}"/>
					</td>
					<td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
				</tr>
				</tbody>
			</table>
			<div class="zixun fix">
				<table class="tab2" width="100%">
					<tbody id='body'>
					<tr>
						<th><input type="checkbox" id="all" onclick=""/></th>
						<th>序号</th>
						<th>指令名称</th>
						<th>描述</th>
						<th>内容</th>
						<th>操作</th>
					</tr>

					<c:forEach items="${messages}" var="message" varStatus="status">
						<tr id="${message.id}" <c:if test="${status.index%2==1}">style="background-color:#ECF6EE;"</c:if>
						>
							<td><input type="checkbox" name="id" value="${message.id}"/></td>
							<td>${status.index+1}</td>
							<td>${message.command}</td>
							<td>${message.description}</td>
							<td>${message.content}</td>
							<td>
								<!-- <%=basePath%>/servlet/UpdateData.action?id=${message.id} -->
								<a href="javascript:updateData('${message.id}','<%=updatePath %>')">修改</a>&nbsp;&nbsp;&nbsp;
								<a href="<%=basePath%>/servlet/deleteOne?id=${message.id}">删除</a>
							</td>
						</tr>
						<% totalData++; %>
					</c:forEach>
					</tbody>
				</table>
				<div class='page fix'>
					共 <b>${page.totalNumber}</b> 条
					<c:if test="${page.currentPage!=1}">
						<a href='javascript:changePage("1")' class='first'>首页</a>
						<a href='javascript:changePage(${page.currentPage-1})' class='pre'>上一页</a>
					</c:if>
					当前第<span>${page.currentPage}/${page.totalPage}</span>页
					<c:if test="${page.currentPage!=page.totalPage}">
						<a href='javascript:changePage(${page.currentPage+1})' class='next'>下一页</a>
						<a href='javascript:changePage(${page.totalPage})' class='last'>末页</a>
					</c:if>
					跳至&nbsp;<input id="current" type='text' value='${page.currentPage}' class='allInput w28' />&nbsp;页&nbsp;
					<a href='javascript:changePage($("#current").val())' class='go'>GO</a>
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>