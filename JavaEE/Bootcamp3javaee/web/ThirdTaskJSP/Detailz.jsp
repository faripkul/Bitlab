<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task3.Tasks" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.11.2022
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container mt-3">
    <%
        Tasks task = (Tasks) request.getAttribute("task");
        if (task != null) {
    %>

    <form action="/Detailss?taskid=<%=task.getId()%>" method="post">
      <div class="form-group">
        <div class="form-row mt-4">
            <div class="col-12">
                        <label>Наименование : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <%=task.getName()%>

                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Описание : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div>
                        <%=task.getDescription()%>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Крайний срок : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <%=task.getDeadlineDate()%>
                    </div>
                </div>

          <%

              }
          %>

          <div class="row mt-3">
              <div class="col-12">
                  <label>Выполнено: </label>
              </div>
          </div>
          <div class="row mt-2">
              <div>
                  <input type="radio" id="contactChoice1"
                         name="contact" value="email">
                  <label for="contactChoice1">Да</label>

                  <input type="radio" id="contactChoice2"
                         name="contact" value="phone">
                  <label for="contactChoice2">Нет</label>

              </div>
          </div>
          <div class="row mt-3">
              <div class="col-12">
                  <a href="/SaveServlet" class="btn btn-info btn-sm">Сохранить</a>
              </div>
              <div class="row mt-3">
                  <div class="col-12">
                      <a href="/DeleteServlet" class="btn btn-info btn-sm">Удалить</a>
                  </div>
              </div>
          </div>
                    </div>
                </div>
                </div>
            </form>
        </div>
    </body>
</html>