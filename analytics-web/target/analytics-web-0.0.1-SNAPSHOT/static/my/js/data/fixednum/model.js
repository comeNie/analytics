define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
			// do nothing
		},
		downloadReport:function(fileName,indexId,fperiodnumber){
		    window.location.href = $$ctx+"/fixedDataMng/download?fileName="+fileName+"&indexId="+indexId+"&fperiodnumber="+fperiodnumber;
		},
		downloadFile:function(url){
			var gotoLink = document.createElement('a');
			gotoLink.style.display = 'none';
			gotoLink.href = url;
		    document.body.appendChild(gotoLink);
		    document.body.removeChild(gotoLink);
		    gotoLink.click();
		}
	});
	module.exports=model;
});