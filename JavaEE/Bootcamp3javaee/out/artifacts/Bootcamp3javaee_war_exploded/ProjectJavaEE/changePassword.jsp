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
<% Polzovatel polzovatel = (Polzovatel) request.getSession().getAttribute("currentPolzovatel");
    if (polzovatel!=null){
%>
 <%
    String passwordSuccess=request.getParameter("passwordsuccess");
    if(passwordSuccess!=null){
 %>
    <strong style="color: green;"> Password update succesfully!</strong>

 <%
      }
 %>

 <%
    String passwordError=request.getParameter("passworderror");
    if(passwordError!=null){
 %>
   <strong style="color: red;"> New passwords are not same!</strong>

 <%
    }
 %>

 <%
    String oldpasswordError=request.getParameter("oldpassworderror");
    if(oldpasswordError!=null){
 %>
 <strong style="color: red;"> Old password is not correct </strong>

 <%
    }
 %>

<div class="container">
  <div class="row">
    <form class="row g-3" action="/changePassword" method="post">
      <div>
      <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Старый пароль</label>
        <input type="password" class="form-control" id="inputEmail4" name="old_password">
      </div>
      </div>
      <div>
      <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Новый пароль</label>
        <input type="password" class="form-control" id="inputPassword4" name="new_password">
      </div>
      </div>
      <div>
        <div class="col-md-6">
          <label for="inputPassword4" class="form-label">Повторите новый пароль</label>
          <input type="password" class="form-control" id="inputPassword42" name="re_new_password">
        </div>
      </div>
      <div class="col-12">
        <button style="color: dodgerblue">Сменить пароль</button>
      </div>
    </form>
  </div>
</div>
<%
    }
%>
</body>
</html>
