<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task3.Tasks" %>
<%@ page import="kz.bitlab.servlets.JDBStask1.Students" %><%--
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
    <%@include file="navbar2.jsp"%>
</head>
<body>
<div class="container mt-3" >
    <div class="row-6">
<%--        <a href="/FirstTaskJDBS/AddStudent.jsp" class="btn btn-info btn-sm">Добавить</a>--%>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Birthday</th>
                <th>City</th>
            </tr>
            </thead>


            <tbody>

            <%
                ArrayList<Students> students = (ArrayList<Students>) request.getAttribute("Spisok");
                if (students != null) {
                    for (Students stud : students) {
            %>
            <tr>
                <td>
                    <%=stud.getId()%>
                </td>
                <td>
                    <%=stud.getName()%>
                </td>
                <td>
                    <%=stud.getSurname()%>
                </td>
                <td>
                    <%=stud.getBirthdate()%>
                </td>
                <td>
                    <%=stud.getCity()%>
                </td>
                <td>
                    <a href="/DetailsStudServlet?id=<%=stud.getId()%>" class="btn btn-info btn-sm">DETAILS</a>
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