package kz.bitlab.servlets.ProjectJavaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/addNews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Polzovatel polzovatel = (Polzovatel) request.getSession().getAttribute("currentPolzovatel");
        if (polzovatel != null) {
           String title = request.getParameter("title");
           String content = request.getParameter("content");

           News news = new News();
           news.setTitle(title);
           news.setContent(content);
           news.setUser(polzovatel);

           DBMyUtil.addNews(news);
           response.sendRedirect("/profile2");

        } else {
            response.sendRedirect("/avtorizServlet");
        }
    }
}

