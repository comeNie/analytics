define(function(require, exports, module) {
	var model = require("./model");
	var view = Backbone.View.extend({
		el: "body",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='query']":"formQuery",
			"click button[role='reset']":"formReset"
		},
		render:function(){
			this.initDate();
			this.initDataTables();
			this.clickFunction();
		},
		initDate:function(){
			$('#startDate').datepicker({
				format : 'yyyy-mm-dd',
				clearBtn:true,
				autoclose:true
			}).on("changeDate",function(ev){
				$("#endDate").datepicker("setStartDate",ev.date?ev.date:"");
				
			});
			$('#endDate').datepicker({
				format : 'yyyy-mm-dd',
				clearBtn:true,
				autoclose:true
			}).on("changeDate",function(ev){
				$("#startDate").datepicker("setEndDate",ev.date?ev.date:"");
				
			});
		},
		initDataTables: function() {
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				searching: false, //初始化表格
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/historyReport/findList",
					data: function(params) {
						if(viewSelf.dt&&viewSelf.dt.oSearchData){//循环遍历查询条件
							 for(var key in viewSelf.dt.oSearchData){
								 params[key]=viewSelf.dt.oSearchData[key];
					         }
						}
					}
				},
				columns: [
					{data: null},
					{data: "orgName"},
			        {data: "reportName"},
			        {data: "reportDateStr"},
			        {data: "reportType"},
			        {data: "buildDateStr"},
			        {data: null, render: function(data, type, row ) {
						return Mustache.render($("#dt-row-operation").html(), {filePath: row.filePathName});
	                }}
			    ],
			    fnCreatedRow: function(nRow, aData, iDataIndex) {
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
			});
			viewSelf.dt = dt;
		},
		formQuery:function(){//查询
			var viewSelf = this;
			var oSearchData={};
			oSearchData.reportType=$("#reportType").val();
			oSearchData.startDateStr=$("#startDate").val();
			oSearchData.endDateStr=$("#endDate").val();
			oSearchData.orgId = $("#orgId").val();
			viewSelf.dt.oSearchData=oSearchData;//查询条件
			viewSelf.dt.fnPageChange(0);
		},
		formReset:function(){//表单重置
			var viewSelf = this;
			viewSelf.dt.oSearchData=null;
			viewSelf.dt.fnPageChange(0);
		},
		clickFunction: function() {
			var viewSelf = this;
			$("#tbl").on("click", "button[role='download']", function(e) {
				var btnSelf=$(this);
				viewSelf.model.downloadReport(btnSelf.data("file-path"));
			});
		}
	});
	module.exports = view;
})