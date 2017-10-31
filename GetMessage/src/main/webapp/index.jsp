<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<script type="text/javascript">
</script>
</head>
<body>
    <% String message = (String)request.getAttribute("message"); %>
    <p><%=message%></p>
</body>
</html>
