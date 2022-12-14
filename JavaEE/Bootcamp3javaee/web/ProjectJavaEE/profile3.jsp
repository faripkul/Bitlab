<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.SessionTaskThree.Users" %>
<%@ page import="kz.bitlab.servlets.ProjectJavaEE.Polzovatel" %>
<%@ page import="kz.bitlab.servlets.ProjectJavaEE.News" %><%--
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
    <%@include file="navbar10.jsp"%>
</head>
<body class="bbbb" style="background-image: url('/img/ccc.jpg')">
<div class="container mt-5">
    <div class="row">
        <div class="col-lg-8">
            <article>
                <br>
                <header class="mb-4">
                    <h1 class="fw-bolder mb-1" style="color: firebrick">Добро пожаловать в Blog Post!</h1>
                </header>
                <section class="mb-5" style="background-color: rgba(255,250,250, 0.5)">
                    <%
                        ArrayList<News>news=(ArrayList<News>) request.getAttribute("news");
                        if(news!=null){
                            for(News n: news){
                    %>
                    <h2 class="fw-bolder mb-4 mt-5"><%=n.getTitle()%></h2>
                    <p class="fs-5 mb-4"><%=n.getContent()%></p>
                    <div class="text-muted fst-italic mb-2"><%=n.getPostDate()%> <a href="/detailsss?id=<%=n.getId()%>">комментарий</a></div>

                    <%
                            }
                        }
                    %>
                </section>
            </article>
        </div>
        <div class="col-lg-4">
            <br>
            Как прошел твой день? Какие новости?
            <form action="/addNews" method="post">
                <div class="card mb-4">
                    <div class="card-header">Заголовок</div>
                    <div class="card-body" style="background-color: lightskyblue">
                        <div class="row">
                            <input type="text" placeholder="Enter ..." name="title" />
                        </div>
                    </div>
                </div>
                <div class="card mb-4" >
                    <div class="card-header" >Описание</div>
                    <div class="card-body" style="background-color: lightskyblue">
                        <div class="row">
                                <textarea name="content" ></textarea>
                        </div>
                    </div>
                </div>
                <button style="background-color: rgba(60,179,113, 0.3)">ADD</button>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>
       </body>
     </html>