$(function(){
	$("#singleSignOut").click(function() {
		//window.open(location, '_self', '');
		window.close();
	});
	if ($.fn.dataTable) {
		$.extend(true, $.fn.dataTable.defaults, {
			serverSide: true,
			pagingType:"full_numbers",
			language: {
				info: "显示第 _START_ - _END_ 条记录，共 _TOTAL_ 条",
	            lengthMenu: "显示 _MENU_ 条记录",
	            zeroRecords: "没有符合条件的记录",
	            infoEmpty: " ",
	            emptyTable:"没有符合条件的记录",
	            search: "查询：",
	            paginate: {
	                first: "<<", last: ">>",previous: "<", next: ">"
	            }
	        }
		});
	}
	//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外 
	var banBackSpace = function(e){
	    var ev = e || window.event;//获取event对象   
	    var obj = ev.target || ev.srcElement;//获取事件源     
	    var t = obj.type || obj.getAttribute('type');//获取事件源类型     
	    //获取作为判断条件的事件类型 
	    var vReadOnly = obj.readOnly;
	    var vDisabled = obj.disabled;
	    //处理undefined值情况 
	    vReadOnly = (vReadOnly === undefined) ? false : vReadOnly;
	    vDisabled = (vDisabled === undefined) ? true : vDisabled;
	    //当敲Backspace键时，事件源类型为密码或单行、多行文本的，  
	    //并且readOnly属性为true或disabled属性为true的，则退格键失效  
	    var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (vReadOnly === true || vDisabled === true);
	    //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效    
	    var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea";
	    //判断    
	    if (flag2 || flag1) 
	        event.returnValue = false;//这里如果写 return false 无法实现效果 
	};
	document.onkeypress = banBackSpace;
	document.onkeydown = banBackSpace;
});