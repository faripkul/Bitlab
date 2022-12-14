<%@ page import="kz.bitlab.servlets.ProjectJavaEE.Polzovatel" %>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Home</title>
    <%@include file="navbar10.jsp" %>
</head>
<body class="aaaa" style="background-image: url('/img/ccc.jpg')">

<br> <br> <br>

<% Polzovatel polzovatel = (Polzovatel) request.getSession().getAttribute("currentPolzovatel");
    if (polzovatel != null) {
%>
<p> Hi, <%=polzovatel.getName()%>
</p>
<a href="/profile2">Go to profile</a>
<%
} else {
%>
<%
    String UserError = request.getParameter("polzovatelerror");
%>
<%
    if (UserError != null) {
%>
<h3 style="color:red;">Incorrect email, user does not exist! </h3>
<%
    }
%>

<%
    String passError = request.getParameter("passworderror");
%>
<%
    if (passError != null) {
%>
<h3 style="color:red;">Incorrect password, please try again! </h3>
<%
    }
%>

<div class="container">
    <div class="row">
        <form class="row g-3" action="/avtorizServlet" method="post">
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
            <div class="col-12">
                <button style="color: dodgerblue">Войти</button>
                <button type="button"><a href="/register" style="text-decoration: none">Добавить пользователя</a>
                </button>
            </div>
    </form>
    <%
        }
    %>
</div>
</div>
</body>
</html>
