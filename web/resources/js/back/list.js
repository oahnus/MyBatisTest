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

/**
 * 添加一个添加操作行在本页最后一条数据后，并设置提交函数
 * @param path
 */
function addData(path){
	console.log('123')
	var last = $("#body").children(':last');
	console.log(last);
	var newtr = $('<tr id="edit"><td>#</td><td>#</td><td><input type="text" id="comm" name="command" class="allInput" value=""/></td><td><input type="text" id="desc" name="description" class="allInput" value=""/></td><td><input type="text" id="cont" class="allInput" name="content" value="" /></td><td><a href="#" onclick=submitAdd("'+path+'")>提交</a>&nbsp;&nbsp;&nbsp;<a href="#" onclick=cancel()>取消</a></td></tr>');
	last.after(newtr);
}
/**
 * 将拼接好的url设置到提交的超链接属性上
 * @param path
 */
function submitAdd(path){
	var edit = $("#edit");
	request = path+'/servlet/add?command='+edit.find('#comm').val()+'&description='+edit.find('#desc').val()+'&content='+edit.find('#cont').val();
	edit.find('a').attr('href',request);
}

/**
 * 添加一个修改行在要修改的数据后面，并设置提交函数为submitUpdate
 * @param id
 * @param path
 */
function updateData(id, path){
	tid = "#"+id;

	var comm = $(tid).children(':first').next().next();
	var newtr = $('<tr id="edit"><td>#</td><td>#</td><td>'+comm.text()+'</td><td><input type="text" id="desc" name="description" class="allInput" value=""/></td><td><input type="text" id="cont" class="allInput" name="content" value="" /></td><td><a href="#" onclick=submitUpdate('+id+',"'+path+'")>提交</a>&nbsp;&nbsp;&nbsp;<a href="#" onclick=cancel()>取消</a></td></tr>');
	$(tid).after(newtr);
}

/**
 * 拼接修改的数据值，将拼接后的url设置为修改链接
 * @param id
 * @param path
 */
function submitUpdate(id, path){
	tid = "#"+id;
	var edit = $(tid).next()
	request = path+'?id='+id+'&description='+edit.find('#desc').val()+'&content='+edit.find('#cont').val();
	edit.find('a').attr('href',request);
}

/**
 * 取消操作，将修改行删去
 */
function cancel(){
	$("#edit").remove();
}