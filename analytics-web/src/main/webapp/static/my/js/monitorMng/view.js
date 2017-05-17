define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='view']" : "showViewModal",//查看
			"click button[role='delete']" : "doDelete",//删除
			"click #btn-add" : "showAddModal",//新增窗口
			"click button[role='btn-doAdd']" : "doAdd",//新增
			"click button[role='btn-reset']":"formReset",//表单重置
			"click button[role='download']":"download"//查看下载
		},
		render:function(){
			this.initForm();//表单校验
			this.initDataTables();
		},
		doDelete:function(e){
			var viewSelf = this;
			var $btn = $(e.currentTarget);
			var id = $btn.data('id');
			bootbox.confirm("确定要删除这条数据吗？",function(res){
				if(res == true){
					$.ajax({
						type:'POST',
						url:$$ctx + "/monitorMng/deleteById",
						data:{
							id:id
						},
						success:function(result){
							viewSelf.dt.fnPageChange(0);
						}
					});
				}
			});
			
		},
		showViewModal:function(e){
			var viewSelf = this;
			var $btn=$(e.currentTarget);
			$("#type_view").val($btn.data('typename'));
			$("#theDate_view").val($btn.data('thedate'));
			$("#name_view").val($btn.data('name'));
			
			var date = new Date(parseInt($btn.data('uploadtime')));
    		var year = date.getFullYear();
    		var month = date.getMonth()+1;
    		month = month<10?(+"0"+month.toString()):month;
    		var day = date.getDate();
    		var hour = date.getHours();
    		var minute = date.getMinutes();
    		minute = minute<10?(+"0"+minute.toString()):minute;
    		var second = date.getSeconds();
    		second = second<10?(+"0"+second.toString()):second;
    		var uploadtime = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
			$("#uploadTime").val(uploadtime);
			$("#downloadFile").val($btn.data('filename'));
			$("#view-modal").modal("show");
			//下载
			$(document).on("click","#download",function(){
				window.location.href=$$ctx + "/monitorMng/download?link="+$btn.data('link');
			});
		},
		formReset:function(){
			$("#type").val("");
			$("#theDate").val("");
			$("#name").val("");
			$("#uploadFile").val("");
		},
		doAdd:function(){
			var viewSelf = this;
			if($("#add-form").valid()) {
				$("#add-form").ajaxSubmit(function(r){
					console.log(r);
					viewSelf.dt.api().draw();
					$("#add-modal").modal("hide");
				});
	        }
		},
		showAddModal:function(){
			var $addForm = $("#add-form");
			$addForm.resetForm();
			$("#add-modal").modal("show");
		},
		initDataTables:function(){
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				bServerSide: true, 
				bAutoWidth:false,
				searching: true,
			    ordering:  false,
			    lengthMenu : [ [ 10, 20, 50,100 ], [ 10, 20, 50, 100 ] ],// 每页显示多少条记录
				ajax: {
					type : "POST",
					url : $$ctx + "/monitorMng/findAll",
				},
				columns : [
				    {data : null },
				    {data : [4] },
				    {data : null,render:function(data,type,row){
				    	console.log(data);
				    	console.log(type);
				    	if(row[1]==null){
				    		return "";
				    	}else{
				    		var time = row[1].substring(0,4)+"-"+row[1].substring(4,6)+"-"+row[1].substring(6,8);
				    		return time;
				    	}
				    } },
				    {data : [2] },
				    {data : null,render:function(data,type,row){
				    	if(row[7]==null){
				    		return "";
				    	}else{
				    		var report = row[7].split(".");
				    		var finalReport = "";
				    		for(var i = 0;i<report.length-1;i++){
				    			finalReport += report[i]+".";
				    		}
				    		console.log(finalReport);
				    		return finalReport.substring(0, finalReport.length-1);
				    	}
				    } },
				    {data : null,render: function(data,type,row){
				    	if(row[5]==null){
				    		return "";
				    	}else{
				    		var date = new Date(parseInt(row[5]));
				    		var year = date.getFullYear();
				    		var month = date.getMonth()+1;
				    		month = month<10?(+"0"+month.toString()):month;
				    		var day = date.getDate();
				    		var hour = date.getHours();
				    		var minute = date.getMinutes();
				    		minute = minute<10?(+"0"+minute.toString()):minute;
				    		var second = date.getSeconds();
				    		second = second<10?(+"0"+second.toString()):second;
				    		return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
				    	}
				    } },
				    {data : "", render: function(data, type, row) {
			        	var div = $("<div class='btn-group'></div>");
			        	var button1 = $("<button role='view'" +
			        			" data-id='" + row[0]+ "' data-thedate='" + row[1] + "' data-name='" + row[2] + "'" +
			        			" data-type='" + row[3]+ "' data-typename='" + row[4] + "' data-uploadtime='" + row[5] + "'" + 
			        			" data-link='" + row[6]+  "' data-filename='" + row[7] + "'" +
			        		" class='btn btn-xs btn-info glyphicon glyphicon-eye-open' title='查看'></button>");
			        	var button2 = $("<button role='delete' data-id='"+row[0]+"' class='btn btn-xs btn-info glyphicon glyphicon-trash' title='删除'></button>");
				        div.append(button1).append(button2);
						return div[0].outerHTML;
	                }}
			    ],
			    fnCreatedRow : function(nRow, aData, iDataIndex) {//序号
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
			    
			});
			
			viewSelf.dt = dt;
		
		},
		initForm: function() {
			$("#add-form").validate({
				rules: rm.rules,
				messages: rm.messages
			});
		}
		
	});
	module.exports = view;
});