<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.SessionTaskThree.Users" %><%--
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
    <%@include file="navbar9.jsp"%>
</head>
<body>
   <% Users user = (Users) request.getSession().getAttribute("currentUser");
      if (user!=null){
    %>
       <p> Hi, <%=user.getFullname()%>  </p>
      <a href="/profile">Go to profile</a>
   <%
   } else {
   %>
  <%
      String UserError = request.getParameter("usererror");
  %>
   <%
       if (UserError!=null){
   %>
     <h3 style="color:red;">Incorrect email, user does not exist! </h3>
   <%
       }
   %>

   <%
       String passError = request.getParameter("passworderror");
   %>
   <%
       if (passError!=null){
   %>
   <h3 style="color:red;">Incorrect password, please try again! </h3>
   <%
       }
   %>

    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <form action="/home35" method="post">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="email" id="form2Example1" name="email" class="form-control" />
                        <label class="form-label" for="form2Example1">Email address</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <input type="password" id="form2Example2" name="password" class="form-control" />
                        <label class="form-label" for="form2Example2">Password</label>
                    </div>

                    <!-- Submit button -->
                    <button>Sign in</button>
            </form>
            <%
                }
            %>
    </div>
</div>
</body>
</html>