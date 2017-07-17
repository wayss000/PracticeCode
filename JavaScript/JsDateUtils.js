function getAllDateTime(date) {
	var date = new Date();
	console.log(date);
	var str = date.getFullYear() + "-" + repairZero(date.getMonth()+1) + "-" + repairZero(date.getDate()) + " " + repairZero(date.getHours()) + ":" + repairZero(date.getMinutes()) + ":" + repairZero(date.getSeconds());
	console.log(str);
	alert(str);
}

function repairZero(num){
	if(num < 10){
		num = "0" + num;
	}
	return num;
}