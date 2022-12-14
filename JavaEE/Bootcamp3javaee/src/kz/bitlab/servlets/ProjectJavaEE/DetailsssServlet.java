package kz.bitlab.servlets.ProjectJavaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/detailsss")
public class DetailsssServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Long id = Long.parseLong(request.getParameter("id"));
            News news = DBMyUtil.getNews(id);
            if(news!=null) {
            request.setAttribute("newz", news);
            ArrayList<Comment> comments = DBMyUtil.getComment(news.getId());
            request.setAttribute("comments", comments);
            }
            request.getRequestDispatcher("/ProjectJavaEE/newsDetails2.jsp").forward(request, response);
    }
}
