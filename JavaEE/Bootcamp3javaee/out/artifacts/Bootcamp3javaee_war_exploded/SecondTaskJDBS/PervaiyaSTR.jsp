<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task3.Tasks" %>
<%@ page import="kz.bitlab.servlets.JDBStask1.Students" %>
<%@ page import="kz.bitlab.servlets.JDBStask2.Items2" %><%--
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
<%
    ArrayList<Items2> items = (ArrayList<Items2>) request.getAttribute("Tovars");
    if (items != null) {
        for (Items2 it : items) {
%>
<div class="container mt-3" >
    <div class="card" style="width: 18rem;">
        <h5 class="card-title"> <%=it.getName()%> </h5>
        <div class="card-body">
            <h5 class="card-title">$ <%=it.getPrice()%> </h5>
            <p class="card-text"><%=it.getDescription()%></p>
            <a href="/SecondTaskJDBS/Buy.jsp" class="btn btn-primary">By now</a>
        </div>
    </div>
    <%
            }
        }
    %>

</body>
</html>

