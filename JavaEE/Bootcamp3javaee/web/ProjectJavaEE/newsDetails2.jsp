<%@ page import="kz.bitlab.servlets.task1.Items" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.SessionTaskThree.Users" %>
<%@ page import="kz.bitlab.servlets.ProjectJavaEE.Polzovatel" %>
<%@ page import="kz.bitlab.servlets.ProjectJavaEE.News" %>
<%@ page import="kz.bitlab.servlets.ProjectJavaEE.Comment" %><%--
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
<body class="bbbb" style="background-image: url('/img/paris.jpg')" >
<div class="container mt-10">
    <div class="row">
            <article>
                <br>
<%--                <br>--%>
<%--                <header class="mb-4">--%>
<%--                    <h1 class="fw-bolder mb-1" style="color: firebrick">Добро пожаловать в Blog Post!</h1>--%>
<%--                </header>--%>
                <section class="mb-5" >
                    <div class="container  py-5" >
                        <div class="row d-flex justify-content-center" >
                            <div class="col-md-12 col-lg-10 col-xl-8">
                                <div class="card" style="background-color: rgba(255,250,250, 0.7)">
                                    <div class="card-body">
                 <%
                   News newz=(News) request.getAttribute("newz");
                   if(newz!=null){
                 %>
                    <h2 class="fw-bolder mb-4 mt-5"><%=newz.getTitle()%></h2>
                    <p class="fs-5 mb-4"><%=newz.getContent()%></p>
                    <div class="text-muted fst-italic mb-2"><%=newz.getPostDate()%></div>


                        <%
                         if(session.getAttribute("currentPolzovatel")!=null){
                        %>
<%--                         <form action="/addComment" method="post">--%>
<%--                          <input type="hidden" name="news_id" value="<%=newz.getId()%>">--%>
<%--                          <textarea style="width: 100%" name="comment"></textarea>--%>
<%--                          <button>ADD COMMENT</button>--%>
<%--                         </form>--%>
                     <form action="/addComment" method="post">
                    <div class="card-footer py-3 border-0" style="background-color: rgba(135,206,250, 0.5)" >
                        <div class="d-flex flex-start w-100">
                            <img class="rounded-circle shadow-1-strong me-3"
                                 src="/img/stone.jpg" alt="avatar" width="40"
                                 height="40" />
                            <div class="form-outline w-100">
                              <input type="hidden" name="news_id" value="<%=newz.getId()%>">
                                <textarea class="form-control" id="textAreaExample" rows="4" name="comment" style="background: #fff;" placeholder="Message..." ></textarea>
                                <div class="float-end mt-1 " >
                                    <button class="btn btn-light">Post comment</button>
                                </div>
                            </div>
                        </div>

                    </div>
                     </form>
<%--                         </form>--%>
                        <%
                            }
                        %>

                       <%
                        ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                        if(comments!=null){
                            for(Comment com:comments){
                    %>

<%--                    <h3><%=com.getUser().getName()%> at <%=com.getPostDate()%> </h3>--%>
<%--                    <h4><%=com.getComment()%></h4>--%>


                    <div class="d-flex flex-start align-items-center">
                        <img class="rounded-circle shadow-1-strong me-3"
                             src="/img/stone.jpg" alt="avatar" width="60"
                             height="60" />
                        <div>
                            <h6 class="fw-bold text-primary mb-1"><b><%=com.getUser().getName()%></b></h6>
                            <p class="text-dark small mb-0" >
                                 Shared publicly - <%=com.getPostDate()%>
                            </p>
                        </div>
                    </div>
                    <p class="mt-3 mb-4 pb-2">
                        <%=com.getComment()%>
                    </p>

                    <%
                        }
                     }
                    %>

                    <%
                        }
                    %>


                </section>
            </article>

        <!-- Side widgets-->
<%--        <div class="col-lg-4">--%>
<%--            Как прошел твой день? Какие новости?--%>
<%--            <form action="/addNews" method="post">--%>
<%--                <div class="card mb-4">--%>
<%--                    <div class="card-header">Заголовок</div>--%>
<%--                    <div class="card-body" style="background-color: lightskyblue">--%>
<%--                        <div class="row">--%>
<%--                            <input type="text" placeholder="Enter ..." name="title" />--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <!-- Categories widget-->--%>
<%--                <div class="card mb-4">--%>
<%--                    <div class="card-header" >Описание</div>--%>
<%--                    <div class="card-body" style="background-color: lightskyblue">--%>
<%--                        <div class="row">--%>
<%--                            <textarea name="content" ></textarea>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <!-- Side widget-->--%>
<%--                <button style="background-color: rgba(60,179,113, 0.3)">ADD</button>--%>
<%--            </form>--%>
<%--        </div>--%>
    </div>
</div>
</div>
</div>
</div>
</div>
</div>

<!-- Footer-->

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>

</body>
</html>