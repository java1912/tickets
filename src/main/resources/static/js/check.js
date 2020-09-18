/*
校验JS
*/
// 字符串长度校验
function strLenCheck(str, minLen, maxLen){
	if(str == null || str == undefined || str == ""){
		return false;
	}
	console.log(typeof minLen );
	if(!isNumber(minLen)){
		return false;
	}
	if(!isNumber(maxLen)){
		return false;
	}
	if(minLen > maxLen || minLen == 0 || maxLen == 0){
		return false;
	}
	
	
	if( str.length < minLen || str.length > maxLen){
		return false;
	}
	
	return true;
}

//判断是否数值
function isNumber(num){
	if(typeof num == "number"){
		return true;
	}
	return false;
}

