<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task3.Tasks" %><%--
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
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container mt-3" >
    <div class="row-6">
    <a href="/ThirdTaskJSP/Addinform.jsp" class="btn btn-info btn-sm">+Добавить Задание</a>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Наименование</th>
            <th>Крайний срок</th>
            <th>Выполнено</th>
            <th>Детали</th>
        </tr>
        </thead>


        <tbody>

        <%
            ArrayList<Tasks> tasks = (ArrayList<Tasks>) request.getAttribute("zadachi");
            if (tasks != null) {
                for (Tasks tas : tasks) {
        %>
        <tr>
            <td>
                <%=tas.getId()%>
            </td>
            <td>
                <%=tas.getName()%>
            </td>
            <td>
                <%=tas.getDeadlineDate()%>
            </td>
            <td>
                <%=tas.getDescription()%>
            </td>
            <td>
                <a href="/Detailss?id=<%=tas.getId()%>" class="btn btn-info btn-sm">DETAILS</a>
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