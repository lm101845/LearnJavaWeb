<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" buffer="16kb" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--前缀名可以随便定义，我这里就定义为c--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    List list = new ArrayList();
    int i = 3 / 0;
  %>

  </body>
</html>
