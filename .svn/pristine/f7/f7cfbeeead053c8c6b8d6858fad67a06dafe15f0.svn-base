
	function getClipboard() {
		if (window.clipboardData) {
			return (window.clipboardData.getData('Text'));
		} else if (window.netscape) {
			netscape.security.PrivilegeManager
					.enablePrivilege('UniversalXPConnect');
			var clip = Components.classes['@mozilla.org/widget/clipboard;1']
					.createInstance(Components.interfaces.nsIClipboard);
			if (!clip)
				return;
			var trans = Components.classes['@mozilla.org/widget/transferable;1']
					.createInstance(Components.interfaces.nsITransferable);
			if (!trans)
				return;
			trans.addDataFlavor('text/unicode');
			clip.getData(trans, clip.kGlobalClipboard);
			var str = new Object();
			var len = new Object();
			try {
				trans.getTransferData('text/unicode', str, len);
			} catch (error) {
				return null;
			}
			if (str) {
				if (Components.interfaces.nsISupportsWString)
					str = str.value
							.QueryInterface(Components.interfaces.nsISupportsWString);
				else if (Components.interfaces.nsISupportsString)
					str = str.value
							.QueryInterface(Components.interfaces.nsISupportsString);
				else
					str = null;
			}
			if (str) {
				return (str.data.substring(0, len.value / 2));
			}
		}
		return null;
	}

	// 读取剪切板数据，并将剪切板数据存放于各table cell中
	function readClipboardData() {
		var str = getClipboard(); // 获取剪切板数据
		var len = str.split("\n");// 获取行数
		// 处理双引号问题：从Excel中的数据，复制到粘贴板之后可能会加上引号，会导致换行，所以需要处理
		for (var m = 0; m < len.length - 1; m++) {
			var strRow = len[m];
			
			// 如果双引号导致的换行，通常都是一个"+"\t"，而且是紧挨在一起的
			var itemIndex = strRow.indexOf("\"");
			var spaceIndex = strRow.indexOf("\t");
			if (itemIndex == 0 && spaceIndex == 1) {
				len[m - 1] = len[m - 1] + len[m];// 将换行后的数据追加到前一行
			}
		}
		var tdIndex = $(this).parent().parent().index(); // 获取当前text控件的父元素td的索引
		var trIndex = $(this).parent().parent().parent().index(); // 获取当前text控件的父元素的父元素tr的索引
		var trStr;
		var $trp = $(this).parent().parent().parent().parent();

		if (len.length == 1) {
			$(this).val(len);
			return false;
		}

		// 从excle表格中复制的数据，最后一行为空行，因此无需对len数组中最后的元素进行处理
		var str = "";
		for (var i = 0; i < len.length - 1; i++) {
			// excel表格同一行的多个cell是以空格 分割的，此处以空格为单位对字符串做 拆分操作。。
			trStr = len[i].split("\t");
			var itemIndex = len[i].indexOf("\"");
			var spaceIndex = len[i].indexOf("\t");
			var inputId;
			if (jQuery.trim(trStr) != "\"") {// 数据只是换行后的双引号
				if (itemIndex == 0 && spaceIndex == 1) {// 数据只是换行后的双引号和其他数据
				} else {
					for (var j = 0; j <= trStr.length - 1; j++) { // 将excel中的一行数据存放在table中的一行cell中
						str += trStr[j] + ",";
					}
				}
			}
		}
		$("#hideText").val(str);
		return false; // 防止onpaste事件起泡
	};

	// 粘贴事件监控
	function pasteFunct(){
		$.fn.pasteEvents = function(delay) {
			if (delay == undefined)
				delay = 10;
			return $(this).each(function() {
				var $el = $(this);
				$el.on("paste", function() {
					$el.trigger("prepaste");
					setTimeout(function() {
						$el.trigger("postpaste");
					}, delay);
				});
			});
		};

		// 使用
		$("input[name='je']")
				.on("postpaste",
						function(e) {
							readClipboardData(); // 获取剪切板数据
							var earray = $("#hideText").val().split(",");
							var k = 0;
							var index = e.currentTarget.id.split("_")[1];
							var je_sum= 0;
							for (var i = index; i < (parseInt(index)+earray.length)-1; i++) {
								if(checknumber(earray[k])){
									$("#je_" + i).val($.trim(earray[k])).css("border","1px solid #d5d5d5");
									je_sum = parseInt(je_sum) + parseInt($("#je_" + i).val());
								}else{
									$("#je_" + i).val("").css("border","1px solid #ff9933");
								}
								k++;
							}
							document.getElementById("je_sum").value=je_sum;
		}).pasteEvents();
	}
	
	//把科学计数法转换成数字
	function convertNUM(obj){  
	    var val=$.trim($(obj).val());  
	    if ((val.indexOf('E') != -1) || (val.indexOf('e') != -1)){  
	            val=val.toUpperCase();  
	            var a=val.substring(0,val.indexOf('E'));  
	            var b=val.substring(val.indexOf('E')+1,val.length);  
	            val=a*Math.pow(10,b);  
	            $(obj).val(val);  
	    }  
	    return val  ;
	}  
	
	//检查数字是否合法
	function checknumber(ole){
		var ss=false; 
//		var regx =/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
		var regx =/^[0-9]*\.?[0-9]{0,2}$/;
		var regx1 =/^\-[0-9]*\.?[0-9]{0,2}$/;
		if(!isNaN(ole) && (regx.test(parseFloat(ole))||regx1.test(parseFloat(ole)))){
//		if(!isNaN(ole) && regx.test(parseFloat(ole))){
			ss = true;
		}
		return ss;
	}

