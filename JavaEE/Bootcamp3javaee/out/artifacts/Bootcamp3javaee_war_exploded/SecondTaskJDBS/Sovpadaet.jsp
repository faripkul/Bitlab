
<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.JDBStask2.Users" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2022
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
  <%@include file="navbar3.jsp"%>
</head>
<body>
<div>
  <%
    Users user = (Users) request.getAttribute("userz");
  %>
   Hello <%=user.getFullName()%> !
  </div>
</body>
</html>