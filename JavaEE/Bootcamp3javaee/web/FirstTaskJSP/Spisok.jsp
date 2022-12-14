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
  <title>Home2</title>
  <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container mt-3" >
  <table class="table table-striped table-hover">
    <thead>
    <tr>
      <th>ID</th>
      <th>NAME</th>
      <th>PRICE</th>
      <th>AMOUNT</th>
      <th>DETAILS</th>
    </tr>
    </thead>


    <tbody>

    <%
      ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("tovary");
      if (items != null) {
        for (Items it : items) {
    %>
    <tr>
      <td>
        <%=it.getId()%>
      </td>
      <td>
        <%=it.getName()%>
      </td>
      <td>
        <%=it.getPrice()%> KZT
      </td>
      <td>
        <%=it.getAmount()%>
      </td>
      <td>
        <a href="/FirstTask/details.jspetails.jsp" class="btn btn-info btn-sm">DETAILS</a>
      </td>
    </tr>
    <%
        }
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>