define(function(require, exports, module) {
	var model = require("./model");
	var utils = require("utils");

	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
//			"click button[role='detail']":"detail",//
			"click #btn-search":"search",
			"click button[role='create']":"reportCreate",
			"click button[role='edit']":"reportEdit",//templateEdit
			"click #btn-doSearch": "doEdit",
			"click button[role='delete']":"delReport"//删除
		},
		render:function(){
			this.initDataTables();
		},
		delReport: function(e){
			var viewSelf = this;
			var $btn=$(e.currentTarget);
			var id = $btn.data('id');
			bootbox.confirm("确定要删除这条数据吗？",function(res){
				if(res == true){
					$.ajax({
						type:'POST',
						url:$$ctx + "/mobileReport/delReportById",
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
		reportEdit: function(e) {
			var viewSelf = this;
			var $btn=$(e.currentTarget);
			var desc = $btn.data('desc');
			var id = $btn.data('id');
			
			$("#description").val(desc);
			$("#mobileId").val(id);
			
			$("#condition-win").modal("show");
		},
		doEdit: function() {
			var viewSelf = this;
			var description = $("#description").val();
			var mobileId = $("#mobileId").val();
			$.ajax({
		        type:'POST',
		        url:$$ctx + "/mobileReport/saveDesc",  //JS访问Controller中方法,有返回值
		        data:{
		        	description:description,
		        	mobileId:mobileId
		        },
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        success:function(result){
		            bootbox.alert("<span style='font-size:16px;'>保存成功.</span>",function(){
		            	viewSelf.dt.fnPageChange(0);
		            });
		        }
		    });
			this.dt.api().draw();
			$("#condition-win").modal("hide");
		},
		reportCreate: function() {
			var viewSelf = this;
			var self = $(this);
			window.location.href = $$ctx + "/main#mobileReport/reportCreate?type=mobileReportCreate";
		},
		search:function(){
			var viewSelf = this;
			var oSearchData = {};
			oSearchData.year = $("#year").val();
			oSearchData.month = $("#month").val();
			oSearchData.tenDays = $("#tenDays").val();
			oSearchData.reportName = $("#reportName").val();
			oSearchData.submitPersonName = $("#submitPersonName").val();
			viewSelf.dt.oSearchData=oSearchData;//查询条件
			viewSelf.dt.fnPageChange(0);
		},
		initDataTables:function(){
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				bServerSide: true, 
				bAutoWidth:false,
				searching: false,
			    ordering:  false,
			    lengthMenu : [ [ 10, 20, 50,100 ], [ 10, 20, 50, 100 ] ],// 每页显示多少条记录
				ajax: {
					type : "POST",
					url : $$ctx + "/mobileReport/queryReports",
					data :function(params) {
						if(viewSelf.dt&&viewSelf.dt.oSearchData) {//循环遍历查询条件
							 for(var key in viewSelf.dt.oSearchData) {
								 params[key]=viewSelf.dt.oSearchData[key];
					         }
						}
					}
				},
				columns : [
				    {data : null },
				    {data : [1] },
				    {data : null,render : function(data,type,row){
				    	if(row[2]==null){
				    		return "";
				    	}else{
				    		var year = row[2].substring(0,4);
				    		var month = row[2].substring(4,5)=="0"?row[2].substring(5,6):row[2].substring(4,6);
				    		var tenDays = row[2].substring(6,8);
				    		if(tenDays=="00"){
				    			return year+"年"+month+"月";
				    		}else if(tenDays=="01"){
				    			return year+"年"+month+"月上旬";
				    		}else if(tenDays=="02"){
				    			return year+"年"+month+"月中旬";
				    		}else if(tenDays=="03"){
				    			return year+"年"+month+"月下旬";
				    		}
				    	}
				    }},
			        {data : [3] },
			        {data : [4] },
			        {data : [5] },
			        {data : null ,render : function(data,type,row) {
			        	if(row[6]==null){
			        		return "";
			        	}else{
			        		var date = new Date(parseInt(row[6]));//.toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
				        	var year = date.getFullYear();
			        		var month = date.getMonth()+1;
				        	var day = date.getDate();
				        	var time = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
//				        	return year+"年"+(month<10?(+"0"+month.toString()):month)+"月"+day+"日";
				        	return year+"年"+month+"月"+day+"日 "+time;
			        	}
			        } },
			        {data : "", render: function(data, type, row) {
			        	var div = $("<div class='btn-group'></div>");
			        	var button1 = $("<button role='edit' data-id='"+row[0]+"' data-desc='"+row[7]+"' class='btn btn-xs btn-info glyphicon glyphicon-edit' title='修改摘要'></button>");
			        	var button2 = $("<button role='delete' data-id='"+row[0]+"' class='btn btn-xs btn-info glyphicon glyphicon-trash' title='删除数据'></button>");
				        div.append(button1).append(button2);
						return div[0].outerHTML;
	                }}
			    ],
			    fnCreatedRow : function(nRow, aData, iDataIndex) {//序号
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
			});
			
			viewSelf.dt = dt;
		}
	});
	module.exports = view;
});