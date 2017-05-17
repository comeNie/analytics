define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el: "div .ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click #btn-add":"showAddDialog",
			"click button[role='update']":"showUpdateDialog",
			"click button[role='delete']":"deleteIndex",
			"click button[role='detail']":"showDetailDialog",
			//"blur #indexCode": "validateIndexCode",
			"blur #indexMeaning" :"validateIndexMeaning",
			"blur #indexName": "validateIndexName"
		},
		render:function(){
			var viewSelf=this;
			this.initDataTables();
			$("#indexId").val(1);
			this.initReportDatatables();
			$("#index-form").validate({
				rules:rm.rules,
				messages:rm.messages,
				submitHandler:function(form){
					var formSelf = $(form);
					console.log(formSelf.attr("action"));
					viewSelf.model.modifyRole(formSelf,function(result){
						if($("#flag").val()=="1"){
							if(result.success){
								bootbox.alert("<span style='font-size:16px;'>修改指标成功！</span>");
							}else{
								bootbox.alert("<span style='font-size:16px;>修改指标失败！</span>");
							}
						}else{
							if(result.success){
								bootbox.alert("<span style='font-size:16px;'>新增指标成功！</span>");
							}else{
								bootbox.alert("<span style='font-size:16px;'>新增指标失败！</span>");
							}
						}
						$("#updateOrAdd").modal("hide");
						viewSelf.dt.api().draw();
					});
				}
			});
		},
		validateIndexCode : function(){
			if($("#indexCode").val()!=""){
				$.ajax({
					type:"POST",
					url:$$ctx + "/statisticsIndex/validateIndexCode",
					data:{
						indexCode: $("#indexCode").val(),
						indexId: $("#indexId").val(),
						flag: $("#flag").val()
					},
					dataType:"json",
					success:function(result){
					    if(result){
					    	if($("#indexCode").val().length > 8){
					    		$("#indexCode").parent().parent().addClass("has-error");
					    		$("#indexCode").parent().after('<div class="help-block" for="indexCode">最多8个字！</div>');
					    		$("#btn-addIndex-submit").attr("type","button");
					    	}else{
					    		$("#indexCode").parent().next().remove();
					    		$("#indexCode").parent().parent().removeClass("has-error");
					    		var arr = $(".has-error");
					    		if(arr.length > 0){
					    			$("#btn-addIndex-submit").attr("type","button");
					    		}else{
					    			$("#btn-addIndex-submit").attr("type","submit");
					    		}
					    	}
					    }else{
					    		$("#indexCode").parent().parent().addClass("has-error");
					    		$("#indexCode").parent().after('<div class="help-block" for="indexCode">指标代码已存在！</div>');
					    		$("#btn-addIndex-submit").attr("type","button");
					    	}
					}
				});
			}
		},
		validateIndexMeaning : function(){
			var arr = $(".has-error");
    		if(arr.length > 0){
    			$("#btn-addIndex-submit").attr("type","button");
    		}else{
    			$("#btn-addIndex-submit").attr("type","submit");
    		}
		},
		validateIndexName : function(){
			if($("#indexName").val()!=""){
				$.ajax({
					type:"POST",
					url:$$ctx + "/statisticsIndex/validateIndexName",
					data:{
						indexName: $("#indexName").val(),
						indexId: $("#indexId").val(),
						flag: $("#flag").val()
					},
					dataType:"json",
					success:function(result){
					    if(result){
					    	if($("#indexName").val().length > 20){
					    		$("#indexName").parent().parent().addClass("has-error");
					    		$("#indexName").parent().parent().append('<div class="help-block" for="indexName">最多20个字！</div>');
					    		$("#btn-addIndex-submit").attr("type","button");
					    	}else{
					    		$("#indexName").parent().next().remove();
					    		$("#indexName").parent().parent().removeClass("has-error");
					    		var arr = $(".has-error");
					    		if(arr.length > 0){
					    			$("#btn-addIndex-submit").attr("type","button");
					    		}else{
					    			$("#btn-addIndex-submit").attr("type","submit");
					    		}
					    	}
					    }
					    else{
					    		$("#indexName").parent().parent().addClass("has-error");
					    		$("#indexName").parent().parent().append('<div class="help-block" for="indexName">指标名称已存在！</div>');
					    		$("#btn-addIndex-submit").attr("type","button");
					    	}
					}
				    
				});
			}
		},
		showDetailDialog: function(e){
			$("#detail").modal("show");
			$("#indexId").val(e.currentTarget.value);
			$("#report-tbl").dataTable().fnDestroy();  
		    this.initReportDatatables();
		},
		initReportDatatables: function(){
			var viewSelf=this;
			var rdt = $("#report-tbl").dataTable({
				bAutoWidth: false,
				pagingType:"full_numbers",
				searching: false, //初始化表格
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/statisticsIndex/findReportByIndexId",
					data:{
						indexId:$("#indexId").val()
					}
				},
				columns: [
				    {data: null},
				    {data: [0]}
			    ],
			    fnCreatedRow: function(nRow, aData, iDataIndex) {
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
			});
			viewSelf.rdt = rdt;
		},
		deleteIndex: function(e){
			var viewSelf=this;
				$.ajax({
					type: "POST",
					url: $$ctx + "/statisticsIndex/findCountIndex",
					data:{
						indexId: e.currentTarget.value
					},
					success:function(result){
						if(result.success){
							if(confirm("确定删除此指标吗？")){
							$.ajax({
								type:"POST",
								url:$$ctx + "/statisticsIndex/deleteIndex",
								data:{
									indexId: e.currentTarget.value
								},
								dataType:"json",
								success:function(result){
									if(result.success){
										bootbox.alert("<span style='font-size:16px;'>删除指标成功！</span>");
										viewSelf.dt.fnDraw();
									}else{
										bootbox.alert("<span style='font-size:16px;>删除指标失败！</span>");
									}
								}
							});
							}
						}else{
							bootbox.alert("<span style='font-size:16px;'>此指标被报表所引用，不能删除！</span>");
						}
					}
				});
		},
		showUpdateDialog:function(e){
			$(".help-block").remove();
			$(".has-error").removeClass("has-error");
			$("#updateOrAdd h4").html("<i class='glyphicon glyphicon-edit'></i> 统计指标修改");
			$("#updateOrAdd").modal("show");
			$.ajax({
				type:"POST",
				url:$$ctx + "/statisticsIndex/findIndexById",
				data:{
					indexId : e.currentTarget.value//指标id
				},
				dataType:"json",
				success:function(result){
					$("#indexCode").val(result.data.indexCode);
					$("#indexName").val(result.data.indexName);
					$("#indexMeaning").val(result.data.indexMeaning);
					$("#indexId").val(result.data.indexId);
					$("#flag").val("1");//标识是修改
				}
			});
		},
		initDataTables: function() {
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				bAutoWidth: false,
				pagingType:"full_numbers",
				searching: true, //初始化表格
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/statisticsIndex/findAllIndex"
				},
				columns: [
				    {data: null},
				    {data: "indexCodeStr"},
			        {data: "indexNameStr"},
			        {data: "indexMeaningStr"},
			        {data : null,render: function(data, type, row ) {
						return Mustache.render($("#dt-row-operation").html(), {id: row.indexId});
	                	}
			        }
			    ],
			    fnCreatedRow: function(nRow, aData, iDataIndex) {
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
			});
			viewSelf.dt = dt;
		},
		showAddDialog: function(e){
			$(".help-block").remove();
			$(".has-error").removeClass("has-error");
			$("#indexCode").val("");
			$("#indexName").val("");
			$("#indexMeaning").val("");
			$("#indexId").val("-1");
			$("#flag").val("0");//标识是增加
			$("#updateOrAdd h4").html("<i class='ace-icon fa fa-plus'></i> 统计指标增加");
			$("#updateOrAdd").modal("show");
		}
	});
	module.exports = view;
})