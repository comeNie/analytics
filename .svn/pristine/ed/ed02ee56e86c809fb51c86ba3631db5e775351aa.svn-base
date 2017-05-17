define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el: "div .ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click #btn-add":"addRoleDialog",
			//"click #btn-addRole-submit":"addRoleSubmit",
			//"click #btn-modifyRole-submit":"modifyRoleSubmit",
			"click button[role='ruser']":"allotUserDialog",
			"click #allot-user-role":"allotUerRoleSubmit",
			"click button[role='edit']":"modifyRoleDialog",//修改角色
			"click button[role='right']":"permissionAllotDialog",//分配权限
			"click #btn-saveRoleFunction":"saveFunction"
		},
		render:function(){
			var viewSelf=this;
			this.initUserTables();
			this.initDataTables();
			this.initTree();
			$("#role-form").validate({
				rules:rm.rules,
				messages:rm.messages,
				submitHandler:function(form){
					var formSelf = $(form);
					console.log(formSelf.attr("action"));
					viewSelf.model.modifyRole(formSelf,function(result){
						if($("#flag").val()=="1"){
							if(result.success){
								bootbox.alert("<span style='font-size:16px;'>修改角色成功！</span>");
							}else{
								bootbox.alert("<span style='font-size:16px;>修改角色失败！</span>");
							}
						}else{
							if(result.success){
								bootbox.alert("<span style='font-size:16px;'>新增角色成功！</span>");
							}else{
								bootbox.alert("<span style='font-size:16px;'>新增角色失败！</span>");
							}
						}
						$("#role-add").modal("hide");
						viewSelf.dt.api().draw();
					});
				}
			});
		},
		allotUserDialog:function(e){//分配用户弹出框
			$("#ruser-form").modal("show");
			$.ajax({
				type:"POST",
				url:$$ctx + "/roleMng/findRoleById",
				data:{
					id : e.currentTarget.value//当前角色id
				},
				dataType:"json",
				success:function(result){
					$("#hidden_role_id").val(result.data.id);
					$("#currentRole").html("当前角色："+result.data.name);
				}
			});
		},
		allotUerRoleSubmit:function(){//保存分配用户角色
			var viewSelf = this;
			var ssoid = "";
			var arrays = $("input:checkbox[name^='check']:checked");
			if(arrays.length == 0){//如果一个用户都没选
				bootbox.alert({
					buttons:{
						ok:{
							label:"确定"
						}
					},
					message:"<span style='font-size:16px;'>请选择要分配角色的用户！</span>"
				});
			}else{//循环保存
				for(var i =0 ; i< arrays.length ; i++){
					ssoid= arrays[i].value+","+ssoid;
				}
				$.ajax({
					type:"POST",
					url:$$ctx + "/userMng/modifyUserSsoRole",
					data:{
						roleId : $("#hidden_role_id").val(),//当前角色id
						ssoId :ssoid
					},
					dataType:"json",
					success:function(result){
						if(result.success ==true){
							bootbox.alert({
								buttons:{
									ok:{
										label:"确定"
									}
								},
								message:"<span style='font-size:16px;'>保存成功！</span>"
							});
							$("#ruser-form").modal("hide");
							viewSelf.ut.api().draw();
						}else{
							bootbox.alert({
								buttons:{
									ok:{
										label:"确定"
									}
								},
								message:"<span style='font-size:16px;'>保存失败！</span>"
							});
						}
					}
				});
			}
		},
		addRoleDialog:function(){//新增角色弹出框
			var $roleForm = $("#role-form");
			$roleForm.resetForm();
			//$("#role-form").attr("action",$$ctx +"/roleMng/add");
			$("#role-add div.modal-header h4").html("<i class='ace-icon fa fa-plus'></i> 新增角色");
			//$("#role-add div.modal-footer").find("button[type='submit']").attr("id","btn-addRole-submit");
			$("#flag").val("0");//标记为修改状态。默认是新增状态。
			//$("#roleID").val("");
			$("#id").val("-1");
			$(".help-block").remove();
			$(".has-error").removeClass("has-error");
			$("#role-add").modal("show");
		},
		modifyRoleDialog:function(e){//修改角色弹出框，加载默认数据
			var $roleForm = $("#role-form");
			$roleForm.resetForm();
			//$("#role-form").attr("action",$$ctx +"/roleMng/modify");
			$("#role-add div.modal-header h4").html("<i class='ace-icon fa fa-plus'></i> 修改角色");
			//$("#role-add div.modal-footer").find("button[type='submit']").attr("id","btn-modifyRole-submit");
			$("#flag").val("1");//标记为修改状态。默认是新增状态。
			$("#id").val(e.currentTarget.value);//设置角色Id值
			$(".help-block").remove();
			$(".has-error").removeClass("has-error");
			$.ajax({
				type:"POST",
				url:$$ctx + "/roleMng/findRoleById",
				data:{
					id : e.currentTarget.value//当前角色id
				},
				dataType:"json",
				success:function(result){
					$("#name").val(result.data.name);
					$("#status").val(result.data.status.trim());
				}
			});
			$("#role-add").modal("show");
		},
		addRoleSubmit:function(){//新增角色提交表单
			alert(1);
			var viewSelf = this;
			//$("#role-form").attr("action",$$ctx +"/roleMng/add");
			$("#tbl").dataTable().fnDestroy();  
			this.initDataTables();
			/*$("#role-form").validate({
				rules:rm.rules,
				messages:rm.messages,
				submitHandler:function(form){
					alert(2);
					var formSelf = $(form);
					viewSelf.model.addRole(formSelf,function(result){
						if($("#flag").val()=="1"){
							if(result.success){
								bootbox.alert("<span style='font-size:16px;''>修改角色成功！</span>");
							}else{
								bootbox.alert("<span style='font-size:16px;'>修改角色失败！</span>");
							}
						}else{
							if(result.success){
								bootbox.alert("<span style='font-size:16px;'>新增角色成功！</span>");
							}else{
								bootbox.alert("<span style='font-size:16px;'>新增角色失败！</span>");
							}
						}
						$("#role-add").modal("hide");
						viewSelf.dt.api().draw();
					});
				}
			});*/
		},
		modifyRoleSubmit:function(){//修改角色提交表单
			var viewSelf = this;
			$("#role-form").attr("action",$$ctx +"/roleMng/modify");
			$("#tbl").dataTable().fnDestroy();
			this.initDataTables();
		},
		//TODO 权限分配弹出层
		permissionAllotDialog:function(e){
			var viewSelf = this;
			$("#roleId").val(e.currentTarget.value);//设置角色Id值
			$("#right-form").modal("show");
			
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getNodes();
			$.ajax({//查找对应roleId下的所有权限
				type:"POST",
				url:$$ctx + "/menuMng/findAllFunctionId",
				data:{
					roleId : e.currentTarget.value//当前角色id
				},
				dataType:"json",
				success:function(result){
					//先设置所有的结束状态为未选中
					$.each(treeObj.transformToArray(nodes), function(i, node) {
						treeObj.checkNode(node,false);
					});
					$.each(treeObj.transformToArray(nodes), function(i, node) {
						$.each(result.data,function(index,menu){
							if(menu.id == node.id){
								treeObj.checkNode(node,true);
							}
						});
					});
					
					treeObj.updateNode(nodes);
					treeObj.expandAll(false);
				}
			});
			
			var treeObj_dashboard = $.fn.zTree.getZTreeObj("treeDemo_dashboard");
			var nodes_dashboard = treeObj_dashboard.getNodes();
			$.ajax({//查找对应roleId下的所有权限 
				type:"POST",
				url:$$ctx + "/menuMng/findAllDashboardId",
				data:{
					roleId : e.currentTarget.value//当前角色id
				},
				dataType:"json",
				success:function(result){
//					if(result.data == null){
						//先设置所有的结束状态为未选中
						$.each(treeObj_dashboard.transformToArray(nodes_dashboard), function(i, node) {
							treeObj_dashboard.checkNode(node,false);
						});
//					}else{
						$.each(treeObj_dashboard.transformToArray(nodes_dashboard), function(i, node) {
							$.each(result.data,function(index,menu){
								if(menu.id == node.id){
									treeObj_dashboard.checkNode(node,true);
								} 
							});
						});
//					}
					
					treeObj_dashboard.updateNode(nodes_dashboard);
				}
			});
			
			$.ajax({//动态回显
				type:"POST",
				url:$$ctx + "/roleMng/findRoleById",
				data:{
					id : e.currentTarget.value//当前角色id
				},
				dataType:"json",
				success:function(result){
					$("#roleName").val(result.data.name);
				}
			});
			
			//@add by wangxy 20151013 查阅角色
			$.ajax({
				type:"POST",
				url:$$ctx + "/roleMng/findCheckRoleById",
				data:{
					id : e.currentTarget.value,
//					ifCheckRole : $("input[name='checkRole']:checked").val()
				},
				success:function(result){
					var b = result.data.ifCheckRole;
					if(b=="1"){
						$("#checkRole1").prop("checked",true);
						$("#checkRole0").prop("checked","");
					}
					if(b=="0" || b==null){
						$("#checkRole0").prop("checked",true);
						$("#checkRole1").prop("checked","");
					}
					
//					var ifCheckRole = $("input[name='checkRole']:checked").val();
//					var id = e.currentTarget.value;
//					window.location.href=$$ctx + "/roleMng/setIfCheckRole?ifCheckRole=" + ifCheckRole +"&id=" + id;
				}
			});
			
		},
		initTree: function() {//初始化权限
			var viewSelf = this;
			$.fn.zTree.init($("#treeDemo"), {
				async: {
					enable: true,
					url:$$ctx + "/menuMng/findFirstMenuList"
				},
				data: {
					simpleData: { enable: true, idKey: "id", pIdKey: "pid"},
					key: { name: "name" }
				},
				check: { enable: true, chkStyle: "checkbox",chkboxType:{ "Y" : "ps", "N" : "ps" }},
				callback: {
					onAsyncSuccess: function() {
						var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
//						treeObj.expandAll(true);//全不展开
					}
				}
			});
			
			
			
			
			$.fn.zTree.init($("#treeDemo_dashboard"), {
				async: {
					enable: true,
					url:$$ctx + "/menuMng/findDashboardMenuList"
				},
				data: {
					simpleData: { enable: true, idKey: "id", pIdKey: "pid"},
					key: { name: "name" }
				},
				check: { enable: true, chkStyle: "checkbox",chkboxType:{ "Y" : "ps", "N" : "ps" }},
				callback: {
					onAsyncSuccess: function() {
						var treeObj = $.fn.zTree.getZTreeObj("treeDemo_dashboard");
//						treeObj.expandAll(true);//全不展开
					}
				}
			});
			
		},
		//TODO 分配权限"保存"
		saveFunction:function(){
			//设置是否为查阅角色
			$.ajax({
				type:"POST",
				url:$$ctx + "/roleMng/setIfCheckRole",
				data:{
					ifCheckRole : $("input[name='checkRole']:checked").val(),
					id : $("#roleId").val()
				},
				dataType:"json",
				success:function(result){
					
				}
			});
			
			this.saveDashboardRoleFunction();
			this.saveRoleFunction();
		},
		
		saveRoleFunction: function() {//保存分配的权限
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var nodes = treeObj.getCheckedNodes();
//			var treeObj_dashboard = $.fn.zTree.getZTreeObj("treeDemo_dashboard");
//			var nodes_dashboard = treeObj_dashboard.getCheckedNodes();
			var viewSelf = this;
			var roleNum = $("#roleId").val();
			
			
//			if(nodes_dashboard.length == 0) {
////				viewSelf.model.deleteDashboardFunction(roleNum);
//			}
//			else {
//				var id="";
//				$.each(nodes_dashboard, function(i, node) {
//					id=node.id+","+id;
//				});
//				viewSelf.model.saveDashboardFunction(roleNum,id);
//			}
//			
			
			if (nodes.length == 0) {
				viewSelf.model.deleteFunction(roleNum);
				$("#right-form").modal("hide");
			} else {
				var id="";
				$.each(nodes, function(i, node) {
					id=node.id+","+id;
				});
				viewSelf.model.saveFunction(roleNum,id);
				$("#right-form").modal("hide");
			}
		},
		
		
		
		
		
		
		saveDashboardRoleFunction: function() {//保存分配的权限
//			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
//			var nodes = treeObj.getCheckedNodes();
			var treeObj_dashboard = $.fn.zTree.getZTreeObj("treeDemo_dashboard");
			var nodes_dashboard = treeObj_dashboard.getCheckedNodes();
			var viewSelf = this;
			var roleNum = $("#roleId").val();
			
			
			if(nodes_dashboard.length == 0) {
				viewSelf.model.deleteDashboardFunction(roleNum);
			}
			else {
				var id="";
				$.each(nodes_dashboard, function(i, node) {
					id=node.id+","+id;
				});
				viewSelf.model.saveDashboardFunction(roleNum,id);
			}
			
			
//			if (nodes.length == 0) {
//				viewSelf.model.deleteFunction(roleNum);
//				$("#right-form").modal("hide");
//			} else {
//				var id="";
//				$.each(nodes, function(i, node) {
//					id=node.id+","+id;
//				});
//				viewSelf.model.saveFunction(roleNum,id);
//				$("#right-form").modal("hide");
//			}
		},
		
		
		
		
		
		initUserTables: function(){//初始化用户列表
			var viewSelf = this;
			var ut = $("#user-tbl").dataTable({
				searching:true,
				ordering: false,
				ajax:{
					type:"POST",
					url: $$ctx + "/userMng/findAllUser"
				},
				columns:[
				      {data:null},
				      {data:[2]},
				      {data: "operation", render: function(data, type, row ) {
							return Mustache.render($("#dt-user-operation").html(), {id: row[1]});
		                }}
				],
				fnCreatedRow: function(nRow, aData, iDataIndex) {
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
		       
			});
			viewSelf.ut = ut;
		},
		initDataTables: function() {
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				bAutoWidth: false,
				searching: true, // 开启dataTables自带的查询框
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/roleMng/findAll",
					beforeSend:function(){
						$(".t_dialog").css("display","block"); 
					},
					complete:function(){
						$(".t_dialog").css("display","none");
					}
				},
				columns: [
				    {data:null},
					{data: "id"},
			        {data: "name"},
			        {data: "status",render:function(data,type,row){
			        	if($.trim(row.status) == '1'){
			        		return '启用';
			        	}else{
			        		return '禁用';
			        	}
			        }},
			        {data: "operation", render: function(data, type, row ) {
						return Mustache.render($("#dt-row-operation").html(), {id: row.id});
	                }}
			    ],
			    fnCreatedRow: function(nRow, aData, iDataIndex) {
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        },
		        "deferRender": true
			});
			viewSelf.dt = dt;
		}
	});
	module.exports = view;
})