package kz.bitlab.servlets.ProjectJavaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.servlets.SessionTaskThree.Users;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/profile2")
public class Profile2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Polzovatel polzovatel = (Polzovatel) request.getSession().getAttribute("currentPolzovatel");
        if (polzovatel != null) {

            ArrayList<News> newsList = DBMyUtil.getNews();
            request.setAttribute("news", newsList);
            request.getRequestDispatcher("/ProjectJavaEE/profile2.jsp").forward(request, response);
        } else {
            response.sendRedirect("/avtorizServlet");
        }
    }
}

