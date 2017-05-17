define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
		},
		downloadReport:function(fileName){
			$.get($$ctx+"/submitDetailQuery/fileIsExists?fileName="+fileName,function(r_data){
				if (r_data == "") {
					window.location.href = $$ctx+"/submitDetailQuery/download?fileName="+fileName;
				} else {
					bootbox.alert({
						buttons:{
							ok:{
								label:"确定"
							}
						},
						message:r_data
					});
				}
			});
		}
	});
	module.exports=model;
})