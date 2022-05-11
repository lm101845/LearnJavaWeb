<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/11
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙.. .</h1>
    <%
        String message = exception.getMessage();
        //你必须要标注这个页面为错误页面:isErrorPage="true"才可以
        out.print(message);
    %>
</body>
</html>
