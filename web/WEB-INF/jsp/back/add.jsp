<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<% String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

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
	<script src="<%=basePath%>/resources/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">
		function submit(){
			var command = document.getElementById('command').value;
			var description = document.getElementById('description').value;

			if(!command&&!description){
				$("#mainForm").submit();
			}else{
				alert("命令与描述不能为空");
			}
		}
		function add(){
			var command = document.getElementById('command').value;
			var description = document.getElementById('description').value;

			if(!command&&!description){

				var num = $(".tab2 tr").filter(".row").size()+1;

				var tr = "<tr class='row' id='"+num+"'><td><input type='checkbox' name='id' value=''/></td>"
						+"<td>"+num+"</td>"
						+"<td>"+command+"</td>"
						+"<td>"+description+"</td>"
						+"<td><a href='#'>修改</a>&nbsp;&nbsp;&nbsp;"
						+"<a href='javascript:deleteElement("+num+")'>删除</a></td></tr>";
				num = num-1;
				var last = "#"+num;
				$(last).after(tr);
			}
		}

		function deleteElement(id){
			var target = "#"+id;
			$(target).remove();
		}
	</script>>
</head>

<% int id = 0;%>

<body style="background: #e1e9eb;">
<form action="<%=basePath%>/servlet/add" id="mainForm" method="get">
	<div class="right">
		<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
		<div class="rightCont">
			<p class="g_title fix">内容列表 <a class="btn03" href="javascript:submit()">提交</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="">删 除</a></p>
			<table class="tab1">
				<tbody>
				<tr id="head">
					<td width="90" align="right">指令：</td>
					<td>
						<input id="command" type="text" name="command" class="allInput" value=""/>
					</td>
					<td width="90" align="right">描述：</td>
					<td>
						<input id="description" type="text" name="description" class="allInput" value=""/>
					</td>
					<td width="90" align="right">内容：</td>
					<td>
						<input id="content" type="text" name="content" class="allInput" value=""/>
					</td>
					<td width="85" align="right"><input type="button" onclick="add()" class="tabSub" value="新 增" /></td>
				</tr>
				</tbody>
			</table>
			<div class="zixun fix">
				<table class="tab2" width="100%">
					<tbody>
					<tr>
						<th><input type="checkbox" id="all" onclick="#"/></th>
						<th>序号</th>
						<th>指令名称</th>
						<th>描述</th>
						<th>操作</th>
					</tr>
					<tr id='0' style="display: none"></tr>
					</tbody>
				</table>
				<div class='page fix'>
					共 <b><%=totalData%></b> 条
					<!-- <a href='###' class='first'>首页</a>
					<a href='###' class='pre'>上一页</a>
					当前第<span>1/1</span>页
					<a href='###' class='next'>下一页</a>
					<a href='###' class='last'>末页</a>
					跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
					<a href='###' class='go'>GO</a> -->
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>