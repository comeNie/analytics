define(function(require, exports, module) {
	var model = require("./model");
	var view = Backbone.View.extend({
		el: "body",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='init']":"initDatas",
			"click button[role='save']":"formSave",
			"click button[role='download']":"downloadFunction",
			"keyup .je" : "checkValues",
			"change #names" : "formQuery",
			"change #months" : "formQuery"
		},
		render:function(){
			this.formQuery();
//			this.initButton();
		//	this.clickFunction();
		},
		
//		initButton:function(){//隐藏保存按钮
//			$("#save").css("display","none");
//		},
		
		formQuery:function(){//查询
			var viewSelf = this;
			$.ajax({
				type:"post",
				url:"/analytics/fixedDataMng/queryDatas",
				beforeSend:function(){
					$(".tbody").remove();
					$(".t_dialog").css("display","block"); 
				},
				data:{
					indexId:$("#names").val(),
					fperiodnumber:$("#months").val()
				},
				dataType:"json",
				success:function(result){
					viewSelf.drawTables(result);
				},
				complete:function(result){
					if(result.responseJSON.data.length == 0){
						$(".t_dialog center").html("*没有符合条件的记录");
						$("#save").css("display","none");
					}else{
						$(".t_dialog").css("display","none");
						$("#save").removeAttr("style");
					}
				}
			});
		},
		checkValues:function(e){//检查数值是否合法
			var regx =/^[0-9]*\.?[0-9]{0,2}$/;
//			var regx =/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
			var regx1 =/^\-[0-9]*\.?[0-9]{0,2}$/;
		    if((regx.test(e.currentTarget.value)||regx1.test(e.currentTarget.value)) == false){
//			if(regx.test(e.currentTarget.value)==false){
				e.currentTarget.value="0";
				$("#"+e.currentTarget.id).css("border","1px solid #ff9933");
			}else{
				$("#"+e.currentTarget.id).css("border","1px solid #d5d5d5");
			}
			
		},
		formSave:function(){//保存
			
			$("#save").attr("disabled",true);//设置保存按钮禁用
			$("#save").html("保存中...");
			
			$(".t_dialog").css("display","black");
			var count =$("#tbl").find(".tbody tr").length;
			$("#tbl").find(".tbody tr").each(function(i){
				//保存数据
				if(i<count-1){
				$.ajax({
					type:"post",
					url:"/analytics/fixedDataMng/saveDatas",
					data:{
						indexId:$(this).children().eq(0).val(),//指标id
						detailNo:$(this).children().eq(1).val(),//指标详情id
						orgId:$(this).children().eq(2).val(),//机构id
						fperiodNumber:$(this).children().eq(3).val(),//月份
						je:$(this).children().slice(6,8).children().eq(0).val()==''?parseFloat('0.00'):$(this).children().slice(6,8).children().eq(0).val(),//数值金额
						memo:$(this).children().slice(6,8).children().eq(1).val()//数值金额
					},
					success:function(result){
						if(result.success == true){
							if((count--) == 2){
								bootbox.alert("保存成功！",function(){
									$("#save").html("保存");
									$("#save").attr("disabled",false);
								});
							}
						}
					}
				});
			}
			});
			
		},
		initDatas:function(){//初始化
			var viewSelf = this;
			$("#init").attr("disabled",true);//设置保存按钮禁用
			$("#init").html("初始化中...");
			$.ajax({
				type:"post",
				url:"/analytics/fixedDataMng/initDatas",
				beforeSend:function(){
					$(".tbody").remove();
					$(".t_dialog").css("display","block"); 
				},
				data:{
					iscopy:$("#iscopy").prop("checked"),
					indexId:$("#names").val(),
					fperiodnumber:$("#months").val()
				},
				dataType:"json",
				success:function(result){
					viewSelf.drawTables(result);
				},
				complete:function(){
					$(".t_dialog").css("display","none");
					$("#init").attr("disabled",false);//设置初始化按钮禁用
					$("#init").html("初始化");
				}
			});
			$("#save").removeAttr("style");
		},
		drawTables:function(result){//绘制表格
			var viewSelf = this;
			var str ="<tbody class='tbody'>";
			var sb ="";
//			console.log(result.data);
			$.each(result.data,function(i,item){
//				console.log(item[5]);
				sb+="<tr><input type='hidden' value='"+item[0]+"' id='indexId' class='indexId'/>" +
						"<input type='hidden' value='"+item[3]+"' id='detailNo' class='detailNo'/>" +
						"<input type='hidden' value='"+item[1]+"' id='orgId' class='orgId'/>" +
						"<input type='hidden' value='"+item[4]+"' id='fperiodNumber' class='fperiodNumber'/>" +
					"<td class='seqnum'>"+(i+1)+"</td>" +
					"<td class='orgname'>"+item[2]+"</td>" +
					"<td><input value='"+(item[5]==null?'0.00':item[5])+"' name='je' id='je_"+(i+1)+"' class='form-control je' type='text' maxlength='19'/></td>" +
					"<td><input value='"+(item[6]==null?'':item[6])+"' name='memo' id='memo' class='form-control memo' type='text' maxlength='66'/></td></tr>";
				    if(i+1==result.data.length){
				    	sb+="<tr>" +
				    			"<td class='seqnum'></td>" +
				    			"<td class='orgname'></td>" +
				    			"<td><input value='' name='je_sum' id='je_sum' class='form-control je' type='text' maxlength='19' style='color: red' /></td>" +
				    			"<td class='orgname'></td>"
				    		"</tr>";
				    }
			});
			$(str+sb+"</tbody>").appendTo("#tbl");
			pasteFunct();//触发粘贴事件
			
		},
		downloadFunction: function(){
			var viewSelf = this;
			var indexId=$("#names").val();
			var fperiodnumber=$("#months").val();
		    viewSelf.model.downloadReport("",indexId,fperiodnumber);
		}
		
		
	});
	module.exports = view;
})