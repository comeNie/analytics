define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
			
		},
		getPersons: function(callback) {
			$.post($$ctx + "/todoList/getPersons/", function(r) {
				callback(r);
			});
		},
		registration: function($form, callback){
			$form.ajaxSubmit(function(r){
				callback(r);
			});
		},
		verifyPermission: function(pram, pram2, callback){
			$.post($$ctx + "/todoList/verifyPermission/" + pram + "/" + pram2, function(r) {
				callback(r);
			});
		},
		isMultiple: function(callback){
			$.post($$ctx + "/todoList/isMultiple", function(r) {
				callback(r);
			});
		},
		isRegist: function(callback){
			$.post($$ctx + "/todoList/isRegist", function(r) {
				callback(r);
			});
		},
		verifyidentity: function(pram, callback){
			$.post($$ctx + "/unified/verifyidentity", {logname: pram}, function(r) {
				callback(r);
			});
		}
	});
	module.exports = model;
});