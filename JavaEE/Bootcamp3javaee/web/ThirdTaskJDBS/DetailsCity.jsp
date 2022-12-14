<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.JDBStask1.Students" %>
<%@ page import="kz.bitlab.servlets.JDBStask3.Students2" %>
<%@ page import="kz.bitlab.servlets.JDBStask3.Cities" %><%--
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
    <%@include file="navbar4.jsp"%>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <%
                Cities cittyy = (Cities) request.getAttribute("citty");
                if (cittyy!=null){
            %>
            <form action="/saveCity" method="post">
                <input type="hidden" name="id" value="<%=cittyy.getId()%>">
                <div class="row">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" placeholder="Name..." name="cit_name"
                               value="<%=cittyy.getName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>SURNAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div>
                        <input type="text" class="form-control" placeholder="Surname..." name="cit_code"
                               value="<%=cittyy.getCode()%>">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">Save</button>
                    </div>
                </div>
                <div>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                        DELETE
                    </button>
                </div>
            </form>
            <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/DeleteStudent" method="post">
                            <input type="hidden" name="id" value="<%=cittyy.getId()%>">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Confirm Delete</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                            <button class="btn btn-primary">YES</button>
                        </div>
                       </form>
                    </div>
                </div>
            </div>

            <%
                }else{
            %>
             <h1 class="text-center">404 STUDENT NOT FOUND</h1>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>