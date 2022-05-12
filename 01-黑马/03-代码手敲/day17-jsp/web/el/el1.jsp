<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式1</title>
</head>
<body>
    ${3 > 4}
    \${3 > 4}
<%--jsp默认是支持EL解析的--%>
<%--使用isELIgnore="true"则不会解析EL表达式--%>
<%--你想有些EL解析，有些不解析，则在不想解析的EL表达式前面加\即可--%>
    <hr>
    <h3>算数运算符</h3>
    ${3+4}<br>
    ${3/4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}<br>

    <h3>逻辑运算符</h3>
    ${3 > 4  && 3 < 4}<br>
    ${3 > 4  and 3 < 4}<br>


    <h4>empty运算符——判断字符串，集合，数组对象是否为null并且长度是否为0</h4>
    <%

        String str = "";
        request.setAttribute("str",str);

        List list = new ArrayList();
        request.setAttribute("list",list);

    %>
    ${not empty str}

    ${not empty list}
</body>
</html>
