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
  <title>Home</title>
  <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container mt-3">
  <div class="row">
    <div class="col-6 mx-auto">
      <form action="/addinfo" method="post">
        <div class="row">
          <div class="col-12">
            <label>Наименование : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <input type="text" class="form-control" placeholder="Наименование..." name="task_name">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Описание : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div>
            <input type="text" class="form-control" placeholder="Описание..." name="task_opisanie">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Крайний срок : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <input type="date" class="form-control" placeholder="mm/dd/yyyy" name="task_data">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <a href="/" class="btn btn-info btn-sm">Закрыть</a>
          </div>
          <div class="row mt-3">
            <div class="col-12">
              <button class="btn btn-success">Добавить</button>
            </div>
        </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>