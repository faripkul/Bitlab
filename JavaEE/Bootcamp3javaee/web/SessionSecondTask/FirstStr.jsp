<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task3.Tasks" %>
<%@ page import="kz.bitlab.servlets.JDBStask1.Students" %>
<%@ page import="kz.bitlab.servlets.JDBStask3.Students2" %>
<%@ page import="kz.bitlab.servlets.SessionTaskTwo.Tovars" %><%--
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<%@include file="navbar7.jsp"%>
<form action="/AddVKorzinuServlet" method="post">
<div class="container mt-3" >
    <div class="row-6">
        <%
            ArrayList<Tovars> tovary = (ArrayList<Tovars>) request.getAttribute("tovarr");
            if (tovary != null) {
                for (Tovars tov : tovary) {
        %>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <input type="hidden" name="id" value="<%=tov.getId()%>">
                <h5 class="card-title"><%=tov.getBrand()%></h5>
                <p class="card-text"><%=tov.getPrice()%></p>
                <button class="btn btn-success">ADD Tovar</button>
            </div>
        </div>

            <%
                    }
                }
            %>
    </div>
</div>
</form>
</body>
</html>