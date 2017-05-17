define(function(require, exports, module) {
	var model = require("./model");
	var utils = require("utils");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='query']":"formQuery",
			"click button[role='reset']":"formReset"
		},
		render:function(){
			this.initDatepicker();
			this.initDataTables();
		},
		formQuery:function(){
			var viewSelf = this;
			var oSearchData={};
			oSearchData.startDateStr=$("#startTime").val();
			oSearchData.endDateStr=$("#endTime").val();
			oSearchData.reportName = $("#reportName").val();
			oSearchData.orgName = $("#orgName").val();
			viewSelf.dt.oSearchData=oSearchData;//查询条件
			viewSelf.dt.fnPageChange(0);
		},
		formReset:function(){
			var viewSelf = this;
			viewSelf.dt.oSearchData=null;
			viewSelf.dt.fnPageChange(0);
		},
		initDatepicker:function(){
			$("#startTime").datepicker({
				minView : "month", //选择日期后，不会再跳转去选择时分秒 
				format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
				language : 'zh-CN', //汉化 
				autoclose : true //选择日期后自动关闭 
			});
			$("#endTime").datepicker({
				minView : "month", //选择日期后，不会再跳转去选择时分秒 
				format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
				language : 'zh-CN', //汉化 
				autoclose : true //选择日期后自动关闭 
			});
		},
		initDataTables:function(){
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				pagingType:"full_numbers",
				searching: false, //初始化表格
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/reportSumQuery/findSumDetailList",
					data: function(params) {
						if(viewSelf.dt&&viewSelf.dt.oSearchData){//循环遍历查询条件
							 for(var key in viewSelf.dt.oSearchData){
								 params[key]=viewSelf.dt.oSearchData[key];
					         }
						}
					}
				},
				columns: [
					{data: "orgName"},
					{data: "reportName"},
			        {data: "releaseTimeStr"},
			        {data: "firstSubTimeStr"},
			        {data: "subTimeStr"},
			        {data: "totalSubTimes"},
			        {data: "lateDays"},
			        {data: "subPeople"},
			        {data: "examinePeople"}
			    ],
//			    fnCreatedRow: function(nRow, aData, iDataIndex) {//序号
//		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
//		        }
			});
			viewSelf.dt = dt;
		
		}
	});
	module.exports = view;
});