<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过EL获取数据(对象形式)</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("李四");
        user.setAge(28);
//        user.getBirthday(new Date());
        request.setAttribute("u",user);
    %>

<h3>使用EL获取对象中的值</h3>
${requestScope.u}
<%--domain.User@3e638a73--%>
<%--通过的是对象的属性来获取--%>
    <br>
    ${requestScope.u.name}<br>
    ${u.age}<br>
    ${u.birthday}<br>
    ${u.birthday.month}<br>

    ${u.birStr}<br>
</body>
</html>
