<%--
  Created by IntelliJ IDEA.
  User: wayss
  Date: 2017/11/9
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<html>
<head>
    <script type="text/javascript">
        function reloadCode() {
            console.log("reload");
            var time = new Date().getTime();
            document.getElementById("imagecode").src = "<%=request.getContextPath()%>/servlet/ImageServlet?d=" + time;
        }
    </script>
</head>
<body>
<form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="get">
    <h2>Java验证码测试</h2>
    验证码:<input type="text" name="checkcode"/>
    <img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/servlet/ImageServlet"/>
    <a href="javascript:reloadCode();">看不清楚</a>
    <br/>
    <input type="submit" value="提交"/>
</form>
<br/>
</body>
</html>