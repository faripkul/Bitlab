
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Navbar</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
  <nav class="navbar navbar-expand-lg navbar-black navbar-custom fixed-top">
    <div class="container px-5">
      <a class="navbar-brand" style="color: darkseagreen"  href="/"><b>Главная страница</b></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item"><a class="nav-link" href="/profile2" style="color: darkseagreen"><b>Публикаций</b></a></li>
          <li class="nav-item"><a class="nav-link" href="/avtorizServlet" style="color: darkseagreen"><b>Вход</b></a></li>
          <li class="nav-item"><a class="nav-link" href="/logout2" style="color: darkseagreen"><b>Выход</b></a></li>
          <li class="nav-item"><a class="nav-link" href="/changePassword" style="color: darkseagreen"><b>Сменить пароль</b></a></li>
        </ul>
      </div>
    </div>
  </nav>
</div>