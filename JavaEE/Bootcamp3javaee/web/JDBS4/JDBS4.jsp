<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task3.Tasks" %>
<%@ page import="kz.bitlab.servlets.JDBStask1.Students" %>
<%@ page import="kz.bitlab.servlets.JDBStask3.Students2" %><%--
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
    <%@include file="navbar5.jsp"%>
</head>
<body>
<div class="container mt-3" >
    <div class="row-6">
        <a href="/JDBS4/AddItem.jsp" class="btn btn-info btn-sm">+ADD NEW</a>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price($)</th>
                <th>Description</th>
                <th>Details</th>
            </tr>
            </thead>


            <tbody>

            <%
                ArrayList<kz.bitlab.servlets.JDBStask4.Items> items = (ArrayList<kz.bitlab.servlets.JDBStask4.Items>) request.getAttribute("phones");
                if (items != null) {
                    for (kz.bitlab.servlets.JDBStask4.Items it : items) {
            %>
            <tr>
                <td>
                    <%=it.getId()%>
                </td>
                <td>
                    <%=it.getName()%>
                </td>
                <td>
                    <%=it.getPrice()%>
                </td>
                <td>
                    <%=it.getDescription()%>
                </td>
                <td>
                    <a href="/" class="btn btn-info btn-sm">DETAILS</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>