<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/11
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域中的数据</title>
</head>
<body>
    <%
    //在域中存储数据
        request.setAttribute("name","李明");
        request.setAttribute("age","28");
        session.setAttribute("name","李白");
    %>

<h3>EL来获取值</h3>
<%--写法1——${域名称.键名}--%>
${requestScope.name}
${requestScope.age}
${requestScope.haha}
<%--写法2——表示依次从最小的域中查找是否有该键对应的值，直到找到为止--%>
    <hr>
${name}
</body>
</html>
