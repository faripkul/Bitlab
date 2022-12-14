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
    <title>Home</title>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container mt-3" >
    <div class="row-6">



            <tbody>

            <%
                Tasks task = (Tasks) request.getAttribute("zadachi");
                if (task!=null){
            %>
            <div> Наименование:
                    <%=task.getName()%>
            </div>
            <div> Описание:
                    <%=task.getDescription()%>
            </div>
            <div> Крайний срок:
                    <%=task.getDeadlineDate()%>
            </div>
            <div> Выполнено:
                <div>
                    <input type="radio" id="contactChoice1"
                           name="contact" value="email">
                    <label for="contactChoice1">Да</label>

                    <input type="radio" id="contactChoice2"
                           name="contact" value="phone">
                    <label for="contactChoice2">Нет</label>
                </div>
            <%

                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>