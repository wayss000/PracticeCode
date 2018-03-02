//Java Map对象的String字符串转换为Json
function map2Json(mapStr){
    var subStr = mapStr.substring(1,mapStr.length-1);
    var arr = subStr.split(",");
    var newJson = {};
    for(var i in arr){
        var tmpObj = arr[i].split("=");
        newJson[$.trim(tmpObj[0])] = tmpObj[1];
    }
    return newJson;
}