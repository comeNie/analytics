define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='uploadExcel']":"uploadExcel",//上传文件
//			"click button[role='importDatas']":"importDatas",//更新录入
			"click button[role='exportExcel']":"exportExcel",//导出数据
			"click button[role='edit']":"editWindow",
			"click button[role='btn-doEdit']":"doEdit",
			"click button[role='delete']":"doDelete",
			"click #btn-add":"addWindow",
			"click button[role='btn-doAdd']":"doAdd"
		},
		render:function(){
			this.initForm();//表单校验
			this.initDataTables();
		},
		exportExcel:function(){
			var viewSelf = this;
			$("#progressDiv").modal('show');
			$.ajax({
				type:'GET',
				url:$$ctx + "/updateDatas/exportExcel",
				success:function(result){
					if(result == "false"){
						$("#progressDiv").modal('hide');
						bootbox.alert("<span style='font-size:16px;'>数据库中没有数据！</span>");
					}else{
						$("#progressDiv").modal('hide');
						window.location.href=$$ctx + "/updateDatas/download?outFileName="+result;
					}
				}
			});
			
		},
		doAdd:function(){//TODO 新增
			var viewSelf = this;
			if($("#add-form").valid()){
				$.ajax({
					type:'POST',
					url:$$ctx + "/updateDatas/doAdd",
					async:false,
					data:{
//						rowNum: $("#rowNum_add").val(),
			        	orgId: $("#orgName_add").val(),
			        	orgName: $("#orgName_add").find("option:selected").text(),
			        	lendForm: $("#lendForm_add").val(),
			        	lendAmt: $("#lendAmt_add").val(),
			        	lengBalance: $("#lengBalance_add").val(),
			        	financingForm: $("#financingForm_add").val(),
			        	platformInstitution: $("#platformInstitution_add").val(),
			        	cashSourceName: $("#cashSourceName_add").val(),
			        	beginDate: $("#beginDate_add").val(),
			        	arriveDate: $("#arriveDate_add").val(),
			        	contractTerm: $("#contractTerm_add").val(),
			        	contractRate: $("#contractRate_add").val(),
			        	incomeExpense: $("#incomeExpense_add").val(),
			        	fundingSources: $("#fundingSources_add").val(),
			        	guaranteeMode: $("#guaranteeMode_add").val(),
			        	guarantor: $("#guarantor_add").val(),
			        	memo: $("#memo_add").val()
					},
					contentType: "application/x-www-form-urlencoded; charset=utf-8",
					success:function(result){
			        	console.log(result.msg);
			        	if(result.msg === "OK"){
			        		bootbox.alert("<span style='font-size:16px;'>保存成功.</span>",function(){
				            	viewSelf.dt.fnPageChange(0);
				            });
			        	}else{
			        		bootbox.alert("<span style='font-size:16px;'>"+result.msg+"</span>");
			        	}
			        },
			        error:function(){
			        	bootbox.alert("请求失败，请检查数据类型是否正确！");
			        }
				});
				this.dt.api().draw();
				$("#add-user").modal("hide");
			}
			
		},
		addWindow:function(){
			var $addForm = $("#add-form");
			$addForm.resetForm();
			$("#add-user").modal("show");
		},
		doDelete:function(e) {
			var viewSelf = this;
			var $btn=$(e.currentTarget);
			bootbox.confirm("确定要删除这条数据吗？",function(res){
				if(res == true){
					$.ajax({
						type:'POST',
						url:$$ctx + "/updateDatas/doDelete",
						data:{
							rowNum: $btn.data('rownum')
						},
						success:function(result){
							viewSelf.dt.fnPageChange(0);
						}
					});
				}
			});
		},
		doEdit:function() {//TODO 修改
			var viewSelf = this;
			if($("#user-form").valid()){//验证
				$.ajax({
			        type:'POST',
			        url:$$ctx + "/updateDatas/editDatas",
			        async:false,
			        data:{
			        	rowNum: $("#rowNum").val(),
//			        	orgId: $("#orgId").val(),
			        	orgId: $("#orgName").find("option:selected").val(),
			        	orgName: $("#orgName").find("option:selected").text(),
			        	lendForm: $("#lendForm").val(),
			        	lendAmt: $("#lendAmt").val(),
			        	lengBalance: $("#lengBalance").val(),
			        	financingForm: $("#financingForm").val(),
			        	platformInstitution: $("#platformInstitution").val(),
			        	cashSourceName: $("#cashSourceName").val(),
			        	beginDate: $("#beginDate").val(),
			        	arriveDate: $("#arriveDate").val(),
			        	contractTerm: $("#contractTerm").val(),
			        	contractRate: $("#contractRate").val(),
			        	incomeExpense: $("#incomeExpense").val(),
			        	fundingSources: $("#fundingSources").val(),
			        	guaranteeMode: $("#guaranteeMode").val(),
			        	guarantor: $("#guarantor").val(),
			        	memo: $("#memo").val(),
			        	operateTime: $("#operateTime").val()
			        },
			        contentType: "application/x-www-form-urlencoded; charset=utf-8",
			        success:function(result){
			        	console.log(result.msg);
			        	if(result.msg === "OK"){
			        		bootbox.alert("<span style='font-size:16px;'>保存成功.</span>",function(){
				            	viewSelf.dt.fnPageChange(0);
				            });
			        	}else{
			        		bootbox.alert("<span style='font-size:16px;'>"+result.msg+"</span>");
			        	}
			        },
			        error:function(){
			        	bootbox.alert("请求失败，请检查数据类型是否正确！");
			        }
			    });
				this.dt.api().draw();
				$("#modify-user").modal("hide");
			}
		},
		editWindow: function(e) {
			var viewSelf = this;
			var $userForm = $("#user-form");
			$userForm.resetForm();
			var $btn=$(e.currentTarget);
			$("#rowNum").val($btn.data('rownum'));
			$("#orgId").val($btn.data('orgid'));
			$("#orgName").val($btn.data('orgid'));
//			$("#orgName").find("option:selected").text($btn.data('orgname'));
			$("#lendForm").val($btn.data('lendform'));
			$("#lendAmt").val($btn.data('lendamt'));
			$("#lengBalance").val($btn.data('lengbalance'));
			$("#financingForm").val($btn.data('financingform'));
			$("#platformInstitution").val($btn.data('platforminstitution'));
			$("#cashSourceName").val($btn.data('cashsourcename'));
			if($btn.data('begindate') == null){
				$("#beginDate").val();
			}else{
				var bDate = new Date(parseInt($btn.data('begindate')));
				var bMonth = bDate.getMonth()+1;
				$("#beginDate").val(bDate.getFullYear()+"-"+(bMonth<10?(+"0"+bMonth.toString()):bMonth)+"-"+bDate.getDate());
			}
			if($btn.data('arrivedate') == null){
				$("#arriveDate").val();
			}else{
				var aDate = new Date(parseInt($btn.data('arrivedate')));
				var aMonth = aDate.getMonth()+1;
				$("#arriveDate").val(aDate.getFullYear()+"-"+(aMonth<10?(+"0"+aMonth.toString()):aMonth)+"-"+aDate.getDate());
			}
			if($btn.data('operatetime') == null){
				$("#operateTime").val();
			}else{
				var cDate = new Date(parseInt($btn.data('operatetime')));
				var cMonth = cDate.getMonth()+1;
				$("#operateTime").val(cDate.getFullYear()+"-"+(cMonth<10?(+"0"+cMonth.toString()):cMonth)+"-"+cDate.getDate());
			}
			$("#contractTerm").val($btn.data('contractterm'));
			$("#contractRate").val($btn.data('contractrate'));
			$("#incomeExpense").val($btn.data('incomeexpense'));
			$("#fundingSources").val($btn.data('fundingsources'));
			$("#guaranteeMode").val($btn.data('guaranteemode'));
			$("#guarantor").val($btn.data('guarantor'));
			$("#memo").val($btn.data('memo'));
			$("#modify-user").modal("show");
		},
		initForm: function() {
			$("#reportForm").validate({
				rules: rm.rules,
				messages: rm.messages
			});
			$("#user-form").validate({
				rules: rm.rules,
				messages: rm.messages
			});
			$("#add-form").validate({
				rules: rm.rules,
				messages: rm.messages
			});
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
					url : $$ctx + "/updateDatas/findAllDatas",
					data :{
						
					}
				},
				columns : [
				    {data : [0] },
				    {data : [2] },
				    {data : [4] },
				    {data : [5] },
				    {data : [8] },
				    {data : [6] },
				    {data : "",render: function(data,type,row){
				    	var bDate = new Date(parseInt(row[18]));
						var bMonth = bDate.getMonth()+1;
						return bDate.getFullYear()+"-"+(bMonth<10?(+"0"+bMonth.toString()):bMonth)+"-"+bDate.getDate();
				    }},
				    {data : "", render: function(data, type, row) {
			        	var div = $("<div class='btn-group'></div>");
			        	var button1 = $("<button role='edit'" +
			        						" data-rownum='" + row[0]+ "' data-orgid='" + row[1] + "' data-orgname='" + row[2] + "'" +
			        						" data-lendform='" + row[3]+ "' data-lendamt='" + row[4] + "' data-lengbalance='" + row[5] + "'" + 
			        						" data-financingform='" + row[6]+ "' data-platforminstitution='" + row[7] + "' data-cashsourcename='" + row[8] + "'" +
			        						" data-begindate='" + row[9]+ "' data-arrivedate='" + row[10] + "' data-contractterm='" + row[11] + "'" +
			        						" data-contractrate='" + row[12]+ "' data-incomeexpense='" + row[13] + "' data-fundingsources='" + row[14] + "'" +
			        						" data-guaranteemode='" + row[15]+ "' data-guarantor='" + row[16] + "' data-memo='" + row[17] + "' data-operatetime=" + row[18] +"'"+
			        				" class='btn btn-xs btn-info glyphicon glyphicon-edit' title='修改'></button>");
			        	var button2 = $("<button role='delete' data-rownum='"+row[0]+"' class='btn btn-xs btn-info glyphicon glyphicon-trash' title='删除'></button>");
				        div.append(button1).append(button2);
						return div[0].outerHTML;
	                }}
			    ]
			    
			});
			
			viewSelf.dt = dt;
		},
		uploadExcel:function(){
			var viewSelf = this;
			if($("#reportForm").valid()) {
				bootbox.confirm("确定要更新数据吗？",function(res){
					if(res==true){
						$("#progressDiv").modal('show');
						$("#reportForm").ajaxSubmit(function(r){
							if(r.msg=="OK"){
								viewSelf.dt.fnPageChange(0);
								$("#progressDiv").modal('hide');
								bootbox.alert("录入数据成功！");
							}else{
								bootbox.alert(r.msg);
							}
						});
					}
				});
			}
//			if($("#reportForm").valid()) {
//				$("#reportForm").ajaxSubmit(function(r){
//					bootbox.alert(r.msg);
//				});
//	        }
		},
		importDatas:function(){
			var viewSelf = this;
			bootbox.confirm("确定要更新数据吗？",function(res){
				if(res == true){
					$.ajax({
						type:'POST',
						url:$$ctx + "/updateDatas/importDatas",
						success:function(result){
							if(result === "OK"){
								bootbox.alert("更新成功！");
								viewSelf.dt.fnPageChange(0);
							}else{
								bootbox.alert(result);
							}
						}
					});
				}
			});
		}
		
	});
	module.exports = view;
});