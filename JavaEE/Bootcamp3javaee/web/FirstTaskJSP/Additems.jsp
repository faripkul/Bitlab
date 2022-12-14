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
      <form action="/additem" method="post">
        <div class="row">
          <div class="col-12">
            <label>NAME : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <input type="text" class="form-control" placeholder="NAME" name="item_name">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>PRICE : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div>
            <input type="number" class="form-control" placeholder="price" name="item_price">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>AMOUNT : </label>
          </div>
        </div>
        <div class="row mt-2">
          <div class="col-12">
            <input type="number" class="form-control" placeholder="amount" name="item_amount">
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <button class="btn btn-success">ADD ITEM</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>