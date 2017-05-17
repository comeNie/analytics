define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
			// do nothing
		},
		createReport:function(data,callback){
			$.post($$ctx+'/bizReport/createReport',data,function(r_data){
				callback(r_data);
			});
		},
		saveFunction: function(roleNum,id) {
			$.post($$ctx + "/roleMng/saveRoleFunction",{roleId:roleNum,functionId:id},function(result){
				if(result.success == true){
					bootbox.alert({
						buttons:{
							ok:{
								label:"确定"
							}
						},
						message:"<span style='font-size:16px;'>保存成功！</span>"
					});
				}
			});
		},
		downloadFile:function(url){
			window.location.href=url;
			//var gotoLink = document.createElement('a');
			//gotoLink.style.display = 'none';
			//gotoLink.href = url;
		    //document.body.appendChild(gotoLink);
		    //document.body.removeChild(gotoLink);
		    //console.log(gotoLink);
		    //gotoLink.click();
		}
	});
	module.exports=model;
})