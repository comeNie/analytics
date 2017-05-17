define(function(require, exports, module) {
	var model = require("./model");
	var view = Backbone.View.extend({
		el: "div .ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='edit']" : "modifyUserDialog",
			"click #btn-modifyuser" : "modifyUserSubmit"
		},
		render:function(){
			this.initDataTables();
		},
		modifyUserDialog: function(e){// 修改用户弹出框
			var viewSelf = this;
			$("#modify-user").modal("show");
			$("#user_id").val(e.currentTarget.id);
			$("#user_name").val(e.currentTarget.name);
			viewSelf.loadRoles(e.currentTarget.value);
		},
		modifyUserSubmit :function(){//修改用户
			var viewSelf = this;
			$.ajax({
				type:"POST",
				url: $$ctx + "/userMng/modifyUserSsoRole",
				data:{roleId:$("#user_role").val()+',',ssoId:$("#user_id").val()+","},
				dataType:"json",
				success:function(result){
					if(result.success == true){
						bootbox.alert("<span style='font-size:16px;'>分配角色成功！</span>");
						$("#modify-user").modal("hide");
						viewSelf.dt.api().draw();
					}else{
						bootbox.alert("<span style='font-size:16px;'>分配角色失败！</span>");
					}
				}
			});
		},
		loadRoles:function(roleId){// 加载所有角色 
			var viewSelf = this;
			$.ajax({
				type:"POST",
				url: $$ctx + "/roleMng/findAllRole",
				dataType:"json",
				success:function(result){
					if(result.success == true){
						var rid=[];
						var roleStr = roleId.split(",");
						$(".role-select").html("");
						$.each(result.data,function(i,item){
							$("<option value ='"+item.id+"'>"+item.name+"</option>").appendTo(".role-select");
							for(var i=0;i<roleStr.length;i++){
								if(item.id == roleStr[i]){
									rid.push(item.id);
								}
							}
						});
						
						var config = {
								'.role-select'					 : {},
								'.role-select-deselect'	: {allow_single_deselect:true},
								'.role-select-no-single' : {disable_search_threshold:10},
								'.role-select-no-results': {no_results_text:'没有数据!'},
								'.role-select-width'		 : {width:"100%"}
							}
							for (var selector in config) {
								$(selector).chosen(config[selector]);
							}
						
						$('.role-select').addClass('tag-input-style');
						$('.role-select').val(rid);
						$('#role_id').val(rid);
						$('.role-select').trigger("chosen:updated");
					}
					
				}
			});
			
		},
		initDataTables: function() {//初始化用户列表
			var viewSelf = this;
			var dt = $("#tbl").dataTable({
				searching: true, // 开启dataTables自带的查询框
			    ordering:  false,
				ajax: {
					type: "POST",
					url: $$ctx + "/userMng/findUserSsoInfo",
					beforeSend:function(){
						$(".t_dialog").css("display","block"); 
					},
					complete:function(){
						$(".t_dialog").css("display","none");
					}
				},
				columns: [
				    {data:null},
					{data: [1]},
			        {data: [2]},
			        {data: [3]},
			        {data: null, render: function(data, type, row ) {
						return Mustache.render($("#dt-row-operation").html(), {uid: row[0],uname:row[1],rname:row[4]});
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