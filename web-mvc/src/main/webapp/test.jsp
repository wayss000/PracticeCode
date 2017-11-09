<%--
  Created by IntelliJ IDEA.
  User: shiyongmou
  Date: 2017/11/9
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <script type="text/javascript">
        function reloadCode() {
            console.log("reload");
            var time = new Date().getTime();
            document.getElementById("imagecode").src = "<%=request.getContextPath()%>/verify/code/img?d=" + time;
        }
    </script>
</head>
<body>
<form action="<%=request.getContextPath()%>/verify/code/verify" method="get">
    <h2>Java验证码测试</h2>
    验证码:<input type="text" name="verifyCode"/>
    <img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/verify/code/img"/>
    <a href="javascript:reloadCode();">看不清楚</a>
    <br/>
    <input type="submit" value="提交"/>
</form>
<br/>
</body>
</html>