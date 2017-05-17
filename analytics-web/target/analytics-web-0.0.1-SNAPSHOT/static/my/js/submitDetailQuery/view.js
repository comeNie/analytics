define(function(require, exports, module) {
	var model = require("./model");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='query']":"formQuery",
			"click button[role='reset']":"formReset",
			"click button[role='detail']":"submitDetailQueryDialog"
		},
		render:function(){
			this.initDate();
			this.initDataTables();
			$("#id").val(5);
			$("workflowId").val(5);
			this.initSubmitDetailData();
			this.clickFunction();
		},
		submitDetailQueryDialog:function(e){
			var viewSelf = this;
			$("#submitDetail").modal("show");
			$("#id").val(e.currentTarget.value);
			$("#workflowId").val(e.currentTarget.name);
			$.ajax({
				type:"POST",
				url:$$ctx + "/dateSubmitQuery/findDateSubmitById",
				data:{
					id : e.currentTarget.value,//当前角色id
					workflowId: e.currentTarget.name
				},
				dataType:"json",
				success:function(result){
					$("#detailNo").val(result.data.no);
					$("#detailName").val(result.data.name);
					$("#detailCycle").val(result.data.cycleStr);
					if(result.data.minDateStr!=null||result.data.maxDateStr!=null){
						$("#detailTime").val(result.data.minDateStr+"至"+result.data.maxDateStr);
					}else{
						$("#detailTime").val("无");
					}
				}
			});
			
			//if($("#detail-tbl tbody").length >= 0){//先判断表格是否有子节点，没有则重新加载表格。
			  // $("#detail-tbl").fnClearTable();  
			    $("#detail-tbl").dataTable().fnDestroy();  
			    this.initSubmitDetailData();
			//}
		},
		initSubmitDetailData:function() {
			var viewSelf = this;
			var ut = $("#detail-tbl").dataTable({
				bAutoWidth: false,
				searching: false, //初始化表格
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/submitDetailQuery/findDetailList",
					data: {
						id:$("#id").val(),
						workflowId:$("#workflowId").val()
					}
				},
				columns: [
				    {data: null},
				    {data: "orgId"},
			        {data: "submitStateStr"},
			        {data: "subTimeStr"},
			        {data : null,render: function(data, type, row ) {
			        	if(row.submitState == '1'){
			        		return Mustache.render($("#dt-row-detail-operation").html(),  {filePath: row.path});
			        	}else{
			        		return "";
			        	}
	                	}
			        }
			    ],
			    fnCreatedRow: function(nRow, aData, iDataIndex) {
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
			});
			viewSelf.ut = ut;
		},
		initDate:function(){
			$('#startTime').datepicker({
				format : 'yyyy-mm-dd',
				clearBtn:true,
				autoclose:true
			}).on("changeDate",function(ev){
				$("#endDate").datepicker("setStartTime",ev.date?ev.date:"");
				
			});
			$('#endTime').datepicker({
				format : 'yyyy-mm-dd',
				clearBtn:true,
				autoclose:true
			}).on("changeDate",function(ev){
				$("#startDate").datepicker("setEndTime",ev.date?ev.date:"");
				
			});
		},
		initDataTables: function() {
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				pagingType:"full_numbers",
				searching: false, //初始化表格
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/submitDetailQuery/findSubmitDetailList",
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
					{data: "name"},
			        {data: "cycleStr"},
			        {data: "templateStartTimeStr"},
			        {data: "templateEndTimeStr"},
			        {data: "sumStateStr"},
			        {data: "createPeople"},
			        {data: "accept"},
			        {data: null,render: function(data, type, row ) {
						return Mustache.render($("#dt-row-operation").html(), {id: row.id,workflowId: row.workflowId});
			        	}
                	}
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
			oSearchData.startDateStr=$("#startTime").val();
			oSearchData.endDateStr=$("#endTime").val();
			oSearchData.sumState=$("#sumState").val();
			oSearchData.name = $("#name").val();
			oSearchData.cycle = $("#cycle").val();
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
			$("#detail-tbl").on("click", "button[role='download']", function(e) {
				var btnSelf=$(this);
				viewSelf.model.downloadReport(btnSelf.data("file-path"));
			});
		}
	});
	module.exports = view;
})