<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
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
    <%@include file="navbar5.jsp"%>
</head>
<body>
<div class="container mt-3">
    <%
        String success = request.getParameter("success");
        if (success!=null) {
    %>
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">Well done!</h4>
        <p>Красавчик!</p>
        <hr>
        <p class="mb-0">XOXOXO</p>
    </div>
    <%
        }
    %>
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/AddItemServlet" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" placeholder="Name..." name="item_name">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Price : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div>
                        <input type="text" class="form-control" placeholder="Price..." name="item_price">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Description : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="date" class="form-control" placeholder="mm/dd/yyyy" name="item_description">
                    </div>
                </div>

<%--                <div class="row mt-2">--%>
<%--                    <div class="col-12">--%>
<%--                        <select class="form-select" name="stud_city">--%>
<%--                        <%--%>
<%--                          ArrayList<Cities> citiz = (ArrayList<Cities>) request.getAttribute("strany");--%>
<%--                          if(citiz!=null){--%>
<%--                              for(Cities ct: citiz){--%>

<%--                        %>--%>
<%--                            <option value="<%=ct.getId()%>">--%>
<%--                                <%=ct.getName() + "/"+ ct.getCode() %>--%>
<%--                            </option>--%>
<%--                        <%--%>
<%--                            }--%>
<%--                            } else {--%>
<%--                         %>--%>
<%--                            <option value="">--%>
<%--                                fvghjkl;--%>
<%--                            </option>--%>
<%--                            <%--%>
<%--                                }--%>
<%--                            %>--%>
<%--                        </select>--%>
<%--                </div>--%>
<%--                </div>--%>
                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">ADD STUDENT</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>