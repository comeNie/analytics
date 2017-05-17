$.validator.addMethod("phone", function(value, element, param) {
	return this.optional(element) || /^1[2|3|5|7|8|9]\d{9}$/.test(value);
}, "无效的手机号码");
$.validator.addMethod("calcTextLength", function(value, element, param) {
	var length = value.replace(/[^\x00-\xff]/g,"aaa").length;
	return this.optional(element) || (param > length);
}, "输入值超出最大长度");
jQuery.validator.addMethod("numIsRight", function(value, element, param) {
	var num = /^[A-Z0-9]+$/;
	return this.optional(element) || (num.test(value));
}, "大写字母数字");
$.validator.addMethod("idCardIsRight", function(value, element, param) {
	return this.optional(element) || /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/.test(value);
}, "请输入有效的身份证号码");
jQuery.validator.addMethod("_numIsRight", function(value, element, param) {
	var num = /^([0-9.]+)$/;
	return this.optional(element) || (num.test(value));
}, "必须为数字");
jQuery.validator.addMethod("isEmail", function(value, element, param) {
	 return this.optional(element) || /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(value);  
}, "邮箱格式不正确。");
/**正整数或两位小数*/
jQuery.validator.addMethod("isPositiveNumberTwo", function(value, element) {       
     return this.optional(element) || /^[1-9]\d*$/.test(value) || /^\d+(\.\d{1,2})?$/.test(value);       
}, "正整数或两位小数.");