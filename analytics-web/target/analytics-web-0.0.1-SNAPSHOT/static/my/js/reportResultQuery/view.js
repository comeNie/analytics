define(function(require, exports, module) {
	var model = require("./model");
	var utils = require("utils");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click #btn-search":"search",
			"click button[role='download']":"download",
			"click button[role='pass']":"showPassModel",//传阅
//			"click button[role='saveFunction']":"saveFunction"
		},
		render:function(){
			this.initDataTables();
		},
		download:function(e){
			var fileName = e.currentTarget.value;
				$.get($$ctx+"/submitDetailQuery/fileIsExists?fileName="+fileName,function(message){
					if (message == "") {
						window.location.href = $$ctx+"/submitDetailQuery/download?fileName="+fileName;
					}else {
						bootbox.alert({
							buttons:{
								ok:{
									label:"确定"
								}
							},
							message:message
						});
					}
				});
		},
		search:function(){
			var viewSelf = this;
			var oSearchData = {};
			oSearchData.reportCycle = $("#report-cycle option:selected").val();
			oSearchData.sumTimeBegin = $("#sum-time-begin").val();
			oSearchData.sumTimeEnd = $("#sum-time-end").val();
			oSearchData.sumPeople = $("#sum-people").val();
			oSearchData.reportName = $("#report-name").val();
			viewSelf.dt.oSearchData=oSearchData;//查询条件
			viewSelf.dt.fnPageChange(0);
		},
		initDataTables:function(){
			var viewSelf = this;
			var dt = $("#tb_r").dataTable({
				searching: false,
			    ordering:  false,
			    lengthMenu : [ [ 10, 20, 50, 100 ], [ 10, 20, 50, 100 ] ],// 每页显示多少条记录
				ajax: {
					type : "POST",
					url : $$ctx + "/reportResultQuery/queryReportResult",
					data :function(params) {
						if(viewSelf.dt&&viewSelf.dt.oSearchData) {//循环遍历查询条件
							 for(var key in viewSelf.dt.oSearchData) {
								 params[key]=viewSelf.dt.oSearchData[key];
					         }
						}
					}
				},
				columns : [
				    {data : null },
				    {data : [1] },
			        {data : null ,render : function(data,type,row) {
			        	if(row[2]==1){
			        		return "一次性填报";
			        	} else if(row[2]==2){
			        		return "年报";
			        	} else if(row[2]==3){
			        		return "半年报";
			        	} else if(row[2]==4){
			        		return "季报";
			        	} else if(row[2]==5){
			        		return "月报";
			        	} else if(row[2]==6){
			        		return "旬报";
			        	} else if(row[2]==7){
			        		return "周报";
			        	} else {
			        		return "无";
			        	}
			        }},
			        {data : null ,render : function(data,type,row) {
			        	if(row[3]==null){
			        		return "";
			        	}else{
			        		var date = new Date(parseInt(row[3]));//.toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
			        		var day = date.getDate();
				        	var month = date.getMonth()+1;
				        	return date.getFullYear()+"-"+(month<10?(+"0"+month.toString()):month)+"-"+(day<10?(+"0"+day.toString()):day);
			        	}
			        } },
			        {data : [4] },
			        {data : null, render: function(data, type, row ) {
			        	var loginName = $("#loginName").val();
//			        	var operation = "<div class='btn-group'>";
//			        		operation += "<button role='download' value='" + row[5] + "' name='download'  class='btn btn-xs btn-info glyphicon glyphicon-save' title='下载'></button>";
//			        		operation += "</div>";
//						return operation;
						var div = $("<div class='btn-group'></div>");
			        	var button1 = $("<button role='download' value='" + row[5] + "' name='download'  class='btn btn-xs btn-info glyphicon glyphicon-save' title='下载'></button>");
			        	var button2 = $("<button role='pass' name='edit' " +
			        					"data-templatename='"+ row[1] + "' " +
			        					"data-reportsumid='" + row[0] + "' " +
			        					"data-cycle='" + row[2] + "' " +
			        					"data-sumpeople='" + row[4] + "' " +
			        					"class='btn btn-xs btn-info glyphicon glyphicon-edit' title='传阅'></button>");
//			        	if(row[4]!=null){
			        		if(row[4]!=loginName&&row[6]=='1'){//已汇总但登录人不是汇总人时不能下载
			        			button1.attr("disabled", true);
				    		}
//			        	}
			        	if($("#ifPassRole").val()=="no"){
			        		button2.attr("disabled",true);
			        	}
				        div.append(button1).append(button2);
						return div[0].outerHTML;
	                }}
			    ],
			    fnCreatedRow : function(nRow, aData, iDataIndex) {
		    		$('td:eq(0)', nRow).html(iDataIndex + 1);
		        }
			});
			viewSelf.dt = dt;
		},
		//TODO
		showPassModel : function(e){
			var viewSelf = this;//获取按钮对象，不能直接取到当前操作按钮，需要转换。
		    var $btn=$(e.currentTarget);  //获得当前操作按钮
		    var templateName = $btn.data('templatename');
		    var reportSumId = $btn.data('reportsumid');
		    
		    $.ajax({
		    	type:"POST",
		    	url:$$ctx + "/reportResultQuery/queryUsersByRoleId",
		    	data:{
		    		roleId:"480"
		    	},
		    	success:function(result){
		    		$("#div-passName").html("");
				    var htmlContent = "";
				    $.each(result.data,function(i,item){
				    	htmlContent += '<input name="checkedUser" type="checkbox" value="'+item.ssoId+'" />'+"&nbsp;&nbsp;"+item.userName+'</br>';
				    });
				    $(htmlContent).appendTo($("#div-passName"));
		    	}
		    });
		    
		    $("#passModal").modal("show");

		    viewSelf.saveFunction(templateName,reportSumId);
		    
		},
		saveFunction : function(templateName,reportSumId){
			$("button[role='saveFunction']").click(function(){
				var str1 = "";
				$("input[name='checkedUser']:checked").each(function(){
					str1 += $(this).val()+",";
				});
				$.ajax({
					type:"POST",
					url:$$ctx + "/reportResultQuery/savePassUser",
					data:{
						readUserId:str1.substring(0, str1.length-1),
						templateName:templateName,
						reportSumId:reportSumId
					},
					success:function(result){
						$("button[role='saveFunction']").unbind("click");//防止多次弹出
//						bootbox.alert("<span style='font-size:16px;'>"+result.msg+"</span>");
					}
				});
				
				$("#passModal").modal("hide");
			});
			
		}
	});
	module.exports = view;
});