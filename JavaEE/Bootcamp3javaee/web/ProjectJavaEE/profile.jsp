<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.SessionTaskThree.Users" %><%--
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
    <%@include file="navbar10.jsp"%>
</head>
<body>

    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <h1>Welcome
            <%
                Users currentUser = (Users) request.getSession().getAttribute("currentUser");
            %>
                <%=currentUser!=null?currentUser.getFullname():""%>
                <h1>
                <a href="/logout">Logout</a>
                </h1>
            <h1>
                <a href="/">Home page</a>
            </h1>
    </div>
</div>
</body>
</html>