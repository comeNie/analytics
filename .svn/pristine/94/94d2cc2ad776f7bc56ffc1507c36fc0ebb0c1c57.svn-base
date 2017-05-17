define(function(require, exports, module) {
	var model = require("./model");
	var utils = require("utils");
	var view = Backbone.View.extend({
		el: "body",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='download']":"fnCreateReport"
		},
		render:function(){
			
		},
		fnCreateReport:function(){
			var viewSelf=this;
			var orgCd=$("#orgCd").val();
			var year=$("#year").val();
			var month=$("#month").val();
			month=(month<10?('0'+month):(month+''));
            var data={'orgCd':orgCd,'year':year,'month':month};
			viewSelf.model.createReport(data,function(r_data){
				if(r_data&&r_data.success){
					var $progress= $('#progressDiv').modal('show');
					var $progressBar=$progress.find("div[role='progressbar']");
					var timer1 = setInterval(function() {
						var toData = {progressRatio: $progressBar.attr('aria-valuenow'), pageStep: $("#pageStep").val()};
						$.post($$ctx+'/bizReport/getProgress',toData,function(r_data2){
							if(r_data2&&r_data2.success&&r_data2.data){
								var msg=r_data2.data;
								var aria_valuenow=Number(r_data2.data.progressRatio);
								$progressBar.attr('aria-valuenow', aria_valuenow);
								$progressBar.css('width',aria_valuenow+ '%');
								$progressBar.find('span').html(msg.content+'(已完成'+aria_valuenow+'%)');
								$("#pageStep").val(r_data2.data.pageStep);
								if(r_data2.data.over && r_data2.success){// && r_data2.success
									clearInterval(timer1);
									viewSelf.model.downloadFile($$ctx+'/bizReport/download');
									$progress.modal('hide');
									$progressBar.attr('aria-valuenow', 0);
									$progressBar.css('width', 0+ '%');
									$progressBar.find('span').html(0);
								}
							}else{
								if(r_data2&&!r_data2.success){//错误提示
									clearInterval(timer1);
									utils.alert.err(r_data2.msg,function(){
										$progress.modal('hide');
										$progressBar.attr('aria-valuenow', 0);
										$progressBar.css('width', 0+ '%');
										$progressBar.find('span').html(0);
									})
								}
							}
						}).error(function() { alert("服务出现异常，请稍后重试");}) 
					}, 3000);
				}
			})
			/*viewSelf.model.downloadFile($$ctx+'/bizReport/downloadReport?'+$("#cr_form").serialize());*/
		},
		fnProgressStart:function(){
			var viewSelf=this;
			var $progress= $('#progressDiv').modal('show');
			var $progressBar=$progress.find("div[role='progressbar']");
			var timer1 = setInterval(function() {
				var aria_valuenow=$progressBar.attr('aria-valuenow')*1;
				if(aria_valuenow < 100) {
					aria_valuenow+=0.29;
					if(aria_valuenow<100){
						aria_valuenow=Math.round(aria_valuenow*100)/100;
					}else{
						aria_valuenow=100;
					}
					$progressBar.attr('aria-valuenow', aria_valuenow);
					$progressBar.css('width',aria_valuenow+ '%');
					$progressBar.find('span').html(aria_valuenow);
				}else{
					viewSelf.fnProgressOver();
				}
			}, 1000);
			viewSelf.progressTimer=timer1;
		},fnProgressOver:function(){
			var viewSelf=this;
			var $progress= $('#progressDiv');
			var $progressBar=$progress.find("div[role='progressbar']");
			if(viewSelf.progressTimer){
				clearInterval(viewSelf.progressTimer);
				$progress.modal('hide');
				$progressBar.attr('aria-valuenow', 0);
				$progressBar.css('width', 0+ '%');
				$progressBar.find('span').html(0);
			}
		}
	});
	module.exports = view;
})