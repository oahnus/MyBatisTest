/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

function updateData(id, path){
	tid = "#"+id;

	var comm = $(tid).children(':first').next().next();
	var newtr = $('<tr id="edit"><td>#</td><td>#</td><td>'+comm.text()+'</td><td><input type="text" id="desc" name="description" class="allInput" value=""/></td><td><input type="text" id="cont" class="allInput" name="content" value="" /></td><td><a href="#" onclick=submit('+id+',"'+path+'")>提交</a></td></tr>');
	$(tid).after(newtr);
	// console.log(path);
	// var edit = $(tid).next()
	// request = path+'?id='+id+'&description='+edit.find('#desc').text()+'&content='+edit.find('#cont').text();
	// edit.find('a').attr('href',request);

	// console.log($(tid).find('a').attr('href'));
	// = path+'?id='+id+'description='+$(tid).find('#desc')+'&content='+$(tid).find('#cont');
	// $("#id").after('<tr id="edit"><td>#</td><td>#</td><td>命令</td><td>描述</td><td>内容</td><td><a href="#">提交</a></td></tr>');
}

function submit(id, path){
	tid = "#"+id;
	var edit = $(tid).next()
	request = path+'?id='+id+'&description='+edit.find('#desc').val()+'&content='+edit.find('#cont').val();
	edit.find('a').attr('href',request);
}