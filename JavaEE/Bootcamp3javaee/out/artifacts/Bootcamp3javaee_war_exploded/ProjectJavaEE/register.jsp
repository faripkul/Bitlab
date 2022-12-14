<%@ page import="kz.bitlab.servlets.ProjectJavaEE.Polzovatel" %>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>Home</title>
    <%@include file="navbar10.jsp"%>
</head>
<body class="aaaa" style="background-image: url('/img/ccc.jpg')">

<br> <br> <br>

 <%
    String emailError = request.getParameter("emailerror");
 %>
  <%
    if (emailError!=null){
  %>
    <h3 style="color:red;">Email is busy!</h3>
  <%
    }
  %>

  <%
    String passwordError = request.getParameter("passworderror");
  %>
   <%
    if (passwordError!=null){
   %>
     <h3 style="color:red;">Passwords are not same!</h3>
   <%
    }
   %>

<%
    String success = request.getParameter("success");
%>
<%
    if (success!=null){
%>
<h3 style="color:green;">Account created successfully!</h3>
<%
    }
%>

<div class="container">
  <div class="row">
    <form class="row g-3" action="/register" method="post">
      <div>
        <div class="col-md-6">
          <label for="inputEmail4" class="form-label">Имя пользователя</label>
          <input type="text" class="form-control" id="inputEmail44" name="name">
        </div>
      </div>
      <div>
      <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Email</label>
        <input type="email" class="form-control" id="inputEmail4" name="login">
      </div>
      </div>
      <div>
      <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Пароль</label>
        <input type="password" class="form-control" id="inputPassword4" name="password">
      </div>
      </div>
      <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Повторите пароль</label>
        <input type="password" class="form-control" id="inputPassword42" name="re_password">
      </div>
    <div>
      <div class="col-12">
        <button style="color: dodgerblue">Зарегистрироваться</button>
      </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
