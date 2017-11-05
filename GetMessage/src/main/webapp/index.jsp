<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<script type="text/javascript">
function execClick(){
    document.execCommand("copy");
}

function execCopy(event,thisDiv){
    if(isIE()){
        if(window.clipboardData){
            window.clipboardData.setData("Text", thisDiv.textContent);
            alert("已复制到剪切板");
        }
    }else{
        event.preventDefault();
        if (event.clipboardData) {
            event.clipboardData.setData("text/plain", thisDiv.textContent);
            alert(event.clipboardData.getData("text"));
        }
    }
}

function isIE(){
    var input = window.document.createElement ("input");
    //"!window.ActiveXObject" is evaluated to true in IE11
    if (window.ActiveXObject === undefined) return null;
    if (!window.XMLHttpRequest) return 6;
    if (!window.document.querySelector) return 7;
    if (!window.document.addEventListener) return 8;
    if (!window.atob) return 9;
    //"!window.document.body.dataset" is faster but the body is null when the DOM is not
    //ready. Anyway, an input tag needs to be created to check if IE is being
    //emulated
    if (!input.dataset) return 10;
    return 11;
}
</script>
</head>
<body>
    <% String message = (String)request.getAttribute("message"); %>
    <% String randomMessage = (String)request.getAttribute("randomMessage"); %>
    <p onclick="execClick();" oncopy="execCopy(event,this);"><%=message%></p>
    <p onclick="execClick();" oncopy="execCopy(event,this);"><%=randomMessage%></p>
</body>
</html>
