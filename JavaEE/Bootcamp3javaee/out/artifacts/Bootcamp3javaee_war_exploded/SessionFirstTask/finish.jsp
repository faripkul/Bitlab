<%@ page import="kz.bitlab.servlets.SessionTaskOne.ClientForm" %><%--
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
  <%
      ClientForm client = (ClientForm) request.getSession().getAttribute("CURRENT_SAVE_USER");
      if(client!=null){
  %>
     <h1>
         Name: <%=client.getName()%><br><br>
         Surname: <%=client.getSurname()%><br><br>
         Age: <%=client.getAge()%><br><br>
         City: <%=client.getCity()%><br><br>
         Address: <%=client.getAddress()%><br><br>
         Phone: <%=client.getPhone()%><br><br>
         University: <%=client.getUnivercity()%><br><br>
         Faculty: <%=client.getFaculty()%><br><br>
         Group: <%=client.getGroup()%><br><br>
     </h1>

  <%
      }
  %>
</body>
</html>
