package kz.bitlab.servlets.ProjectJavaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/addComment")
public class AddCommentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Polzovatel polzovatel = (Polzovatel) request.getSession().getAttribute("currentPolzovatel");
        if (polzovatel != null) {
           String comment = request.getParameter("comment");
           Long newsId = Long.parseLong(request.getParameter("news_id"));
           News news = DBMyUtil.getNews(newsId);

           if(news!=null){
               Comment commentObj = new Comment();
               commentObj.setUser(polzovatel);
               commentObj.setComment(comment);
               commentObj.setNews(news);

           DBMyUtil.addComment(commentObj);
           response.sendRedirect("/detailsss?id="+newsId);
           }

        } else {
            response.sendRedirect("/avtorizServlet");
        }
    }
}

