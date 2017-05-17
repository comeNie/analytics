define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		uploadSubmitForm : function($form, callback) {
			$form.ajaxSubmit(function(result) {
				callback(result);
			});
		},
		downloadReport : function(fileName) {//下载
			window.location.href = $$ctx + "/dataEntry/download?fileName="
					+ fileName;
		},
		fileUpload : function($form, callback) {//上传
			$form.ajaxSubmit(function(result) {
				callback(result);
			});
		}
	});
	module.exports = model;
})