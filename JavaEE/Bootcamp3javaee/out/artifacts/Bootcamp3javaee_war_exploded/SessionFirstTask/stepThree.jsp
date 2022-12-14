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
<form action="/ThirdServlet" method="post">
  Univercity: <input type="text" name="user_univercity">
  Faculty: <input type="text" name="user_faculty">
  Group: <input type="number" name="user_group">
  <button>SEND</button>
</form>
</body>
</html>
