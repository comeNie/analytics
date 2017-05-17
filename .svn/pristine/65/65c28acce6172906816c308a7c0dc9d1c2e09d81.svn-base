define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
			// do nothing
		},
		downloadReport:function(fileName){
			$.get($$ctx+"/historyReport/fileIsExists?fileName="+fileName,function(r_data){
				if (r_data == "") {
					window.location.href = $$ctx+"/historyReport/download?fileName="+fileName;
				} else {
					alert(r_data);
				}
			});
			//this.downloadFile($$ctx+"/historyReport/download?fileName="+fileName);
		},
		downloadFile:function(url){
			var gotoLink = document.createElement('a');
			gotoLink.style.display = 'none';
			gotoLink.href = url;
		    document.body.appendChild(gotoLink);
		    //document.body.removeChild(gotoLink);
		    gotoLink.click();
		}
	});
	module.exports=model;
})