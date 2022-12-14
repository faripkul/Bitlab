<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task3.Tasks" %>
<%@ page import="kz.bitlab.servlets.JDBStask1.Students" %>
<%@ page import="kz.bitlab.servlets.JDBStask3.Students2" %>
<%@ page import="kz.bitlab.servlets.JDBStask3.Cities" %><%--
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
<div class="container mt-3" >
  <div class="row-6">
    <a href="/AddCityServlet" class="btn btn-info btn-sm">Добавить</a>
    <table class="table table-striped table-hover">
      <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Code</th>
        <th>Details</th>
      </tr>
      </thead>


      <tbody>

      <%
        ArrayList<Cities> cities = (ArrayList<Cities>) request.getAttribute("goroda");
        if (cities != null) {
          for (Cities cit : cities) {
      %>
      <tr>
        <td>
          <%=cit.getId()%>
        </td>
        <td>
          <%=cit.getName()%>
        </td>
        <td>
          <%=cit.getCode()%>
        </td>

        <td>
          <a href="/DetailsCityServlet?id=<%=cit.getId()%>" class="btn btn-info btn-sm">DETAILS</a>
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