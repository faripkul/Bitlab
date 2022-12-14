<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.12.2022
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/SecondServlet" method="post">
  City: <input type="text" name="user_city">
  Address: <input type="text" name="user_address">
  Phone: <input type="number" name="user_phone">
  <button>SEND</button>
</form>

</body>
</html>
