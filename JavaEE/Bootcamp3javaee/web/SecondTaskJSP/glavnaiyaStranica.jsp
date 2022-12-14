 <%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.task2.News" %><%--
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
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container mt-3" >
    <%@include file="navbar.jsp"%>
    <div class="container">
        <%
            if (request.getAttribute("newnovosty")==null){
            ArrayList<News> novosti = (ArrayList<News>) request.getAttribute("texty");
            if (novosti != null) {
                for (News newz : novosti) {
        %>
            <div class="card" style="width: 100%;">
                <div> <h5 class="card-title"><%=newz.getTitle()%></h5> </div>
                <div>  <p class="card-text"> <%=newz.getContent()%></p> </div>
                <div>  <h6 class="card-subtitle mb-2 text-muted">Author: <%=newz.getAuthor()%></h6> </div>
            </div>
        <%
                }
            }
            } else {
                ArrayList<News> novosti2 = (ArrayList<News>) request.getAttribute("newnovosty");

                for (News newz : novosti2) {
        %>
        <div class="card" style="width: 100%">

            <div> <h5 class="card-title"><%=newz.getTitle()%></h5> </div>
            <div>  <p class="card-text"> <%=newz.getContent()%></p> </div>
            <div>  <h6 class="card-subtitle mb-2 text-muted">Author: <%=newz.getAuthor()%></h6> </div>
        </div>

                    <%
                                }

                        }
                    %>

        </tbody>
    </div>
</div>
</body>
</html>