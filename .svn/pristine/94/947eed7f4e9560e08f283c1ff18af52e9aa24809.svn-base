define(function(require, exports, module) {
	var model = require("./model");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click #btn-saveRoleFunction":"downloadExcel",
			"click button[role='query']":"formQuery",
			"click button[role='reset']":"formReset",
			"click button[role='detail']":"dateSubmitDetailDialog"
		},
		render:function(){
			
			this.initDate();
			this.initDataTables();
		},
		downloadExcel:function(){
			$.get($$ctx+"/submitDetailQuery/fileIsExists?fileName="+$("#realPath").val(),function(message){
				if (message == "") {
					window.location.href = $$ctx+"/submitDetailQuery/download?fileName="+$("#realPath").val();
				} else {
					bootbox.alert(message);
				}
			});	
		},
		dateSubmitDetailDialog:function(e){
			$("#dateDetail").modal("show");
			$.ajax({
				type:"POST",
				url:$$ctx + "/dateSubmitQuery/findTemplateById",
				data:{
					id : e.currentTarget.value,//当前角色id
					submitId: e.currentTarget.name
				},
				dataType:"json",
				success:function(result){
					$("#dateNo").val(result.data.no);
					$("#dateName").val(result.data.name);
					$("#dateCycle").val(result.data.cycleStr);
					$("#dateTimeLimit").val(result.data.timeLimit);
					$("#dateSubmitOrg").val(result.data.submitOrg);
					$("#dateCheckRole").val(result.data.checkRole);
					$("#dateSubType").val(result.data.sumTypeStr);
					$("#datePath").val(result.data.path);
					$("#realPath").val(result.data.createPeople);
					$("#id").val(result.data.id);
					var datePath = $("#datePath").val();
					if(datePath == null || datePath == ""){
						$("#btn-saveRoleFunction").css("display","none");
					}else if(datePath != null){
						$("#btn-saveRoleFunction").css("display","");
					}
				}
			});
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
		//	var sta = $("#submitState").val();
			var dt = $("#tbl").dataTable({
				pagingType:"full_numbers",
				searching: false, //初始化表格
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/dateSubmitQuery/findDateSubmitList",
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
			        {data: "startTimeStr"},
			        {data: "endTimeStr"},
			        {data: "subTimeStr"},
			        {data: "orgName"},
			        {data: "createPeople"},
//			        {data: "submitStateStr"},
			        {data : null,render: function(data, type, row ) {
			        	if(row.submitState=='0'){
			        		return "未报送";
			        	}
			        	if(row.submitState=='1'){
			        		return "已报送";
			        	}
			        	if(row.submitState=='2'){
			        		return "已延迟";
			        	}
			        	if(row.submitState=='3'){
			        		return "已退回";
			        	}
//			        	}else{
//			        		return row.submitStateStr;
//			        	}
	                }},
			        {data : null,render: function(data, type, row ) {
						return Mustache.render($("#dt-row-operation").html(), {id: row.id,submitId: row.submitId});
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
			oSearchData.startDateStr=$("#startDate").val();
			oSearchData.endDateStr=$("#endDate").val();
			oSearchData.submitState=$("#submitState").val();
			oSearchData.name = $("#name").val();
			oSearchData.cycle = $("#cycle").val();
			viewSelf.dt.oSearchData=oSearchData;//查询条件
			viewSelf.dt.fnPageChange(0);
		},
		formReset:function(){//表单重置
			var viewSelf = this;
			viewSelf.dt.oSearchData=null;
			viewSelf.dt.fnPageChange(0);
		}
	});
	module.exports = view;
})