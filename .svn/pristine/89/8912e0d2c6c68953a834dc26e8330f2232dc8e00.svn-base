define(function(require, exports, module) {
	var utils, _u;
	utils = _u = {};
	_u.str = {
		substringBefore: function(str, seperator) {
			return str.substring(0, str.indexOf(seperator));
		},
		substringBeforeLast: function(str, seperator) {
			return str.substring(0, str.lastIndexOf(seperator));
		},
		substringAfter: function(str, seperator) {
			return str.substring(str.indexOf(seperator) + seperator.length);
		},
		substringAfterLast: function(str, seperator) {
			return str.substring(str.lastIndexOf(seperator) + seperator.length);
		},
		contains: function(str, word) {
			return str.indexOf(word) > -1;
		},
		notContains: function(str, word) {
			return !this.contains(str, word);
		}
	};
	_u.fileupload = {
		init: function(fileUploadElementId, allow) {
			$("#" + fileUploadElementId).ace_file_input({
				no_file: "请上传文件..",
				btn_choose: "选择",
				btn_change: "重选",
				droppable: false,
				onchange: null,
				thumbnail: false,
				before_change: function(files, dropped) {
					return _u.fileupload._filter(files, allow);
				}
			});
		},
		_filter: function(files, allow) {
			var uploadFileName = files[0].name;
			var suffix = _u.str.substringAfterLast(uploadFileName, ".");
			if (_u.str.contains(uploadFileName, ".")) { // 判断是否包含.
				if (_u.str.contains(allow, suffix)) { // 判断是否在允许的后缀名范围内
					return true;
				} else {
					bootbox.alert("只允许上传后缀名为" + allow + "的文件！");
				}
			} else  {
				bootbox.alert("上传文件必须包含后缀名！");
			}
			return false;
		}
	};
	_u.dd = {
		initDataDict: function(codeTypes, callback) {
			$.post($$ctx + "loadDataDict", {codeTypes: codeTypes}, function(dataDict) {
				callback(dataDict);
			});
		},
		translateDict: function(codeType, codeValue, callback) {
			$.post($$ctx + "loadDataDict/translate", {codeType: codeType, codeValue: codeValue}, function(dictName) {
				callback(dictName);
			});
		}
	};
	_u.date = {
			format: function(date, pattern) {
				var o = {
					"M+": date.getMonth() + 1,
					"d+": date.getDate(),
					"H+": date.getHours(),
					"m+": date.getMinutes(),
					"s+": date.getSeconds()
				};
				if (/(y+)/.test(pattern)) {
					pattern = pattern.replace(RegExp.$1, (date.getFullYear() + "").substring(4 - RegExp.$1.length));
				}
				for (var k in o) {
					if (new RegExp("(" + k + ")").test(pattern)) {
						pattern = pattern.replace(RegExp.$1, (RegExp.$1.length == 1) ? 
							(o[k]) : (("00" + o[k]).substring(("" + o[k]).length)));
					}
				}
				return pattern;
			}
		};
	_u.select = {
			colAdd: function(pre,value,text) {
				var selObj = $("#"+pre);
				selObj.append("<option value='"+value+"'>"+text+"</option>");
			},
			colDelete: function(pre) {
				var selOpt = $("#"+pre+" option");
				selOpt.remove();
			}
		};
	_u.alert ={ 
			warn:function(content,callback){
				var _content = 
					'<span class="badge badge-transparent" >'+
					'<i class="ace-icon fa fa-exclamation-triangle orange" style="font-size: 400% !important;"></i>'+
					'</span>' + content;
				bootbox.alert(_content,callback);
			},
			suc:function(content,callback){
				var _content = 
					'<span class="badge badge-transparent" >'+
					'<i class="ace-icon fa fa-check-square green" style="font-size: 400% !important;"></i>'+
					'</span>' + content;
				bootbox.alert(_content,callback);
			},
			err:function(content,callback){
				var _content = 
					'<span class="badge badge-transparent" >'+
					'<i class="ace-icon fa fa-times-circle red" style="font-size: 400% !important;"></i>'+
					'</span>' + content;
				bootbox.alert(_content,callback);
			}
		}
	module.exports = utils;
});