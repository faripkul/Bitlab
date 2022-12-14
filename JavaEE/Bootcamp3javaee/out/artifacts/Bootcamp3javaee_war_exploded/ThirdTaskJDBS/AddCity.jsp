<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <%@include file="navbar4.jsp"%>
</head>
<body>
<div class="container mt-3">
    <%
        String success = request.getParameter("success");
        if (success!=null) {
    %>
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">Well done!</h4>
        <p>Красавчик!</p>
        <hr>
        <p class="mb-0">XOXOXO</p>
    </div>
    <%
        }
    %>
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/AddCityServlet" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" placeholder="Name..." name="cit_name">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>CODE : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div>
                        <input type="text" class="form-control" placeholder="Surname..." name="cit_code">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button type="submit" class="btn btn-success" >ADD CITY</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>