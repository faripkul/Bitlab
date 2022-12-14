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
  <%@include file="navbar7.jsp"%>
</head>
<body>
<div class="container mt-3" >
  <div class="row-6">
    <table class="table table-striped table-hover">
      <thead>
      <tr>
        <th>ID</th>
        <th>Brand</th>
        <th>Price</th>
      </tr>
      </thead>
      <%
        ArrayList<Tovars> tovary = (ArrayList<Tovars>) request.getAttribute("itemTovary");
        if (tovary != null) {
          for (Tovars tv : tovary) {
      %>

      <tbody>

      <tr>
        <td>
           <%=tv.getId()%>
        </td>
        <td>
           <%=tv.getBrand()%>
        </td>
        <td>
           <%=tv.getPrice()%>

        </td>
      </tr>
      </tbody>
      <%
          }
        }
      %>
    </table>
  </div>
</div>
</body>
</html>