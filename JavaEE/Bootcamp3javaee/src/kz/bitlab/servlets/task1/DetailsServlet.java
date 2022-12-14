package kz.bitlab.servlets.task1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/detailss")
public class DetailsServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Long id = Long.parseLong(request.getParameter("id"));
    Items item=DBManager.getItem(id);

    if(item!=null){
        request.setAttribute("item",item);
        request.getRequestDispatcher("/Details.jsp").forward(request, response);
    }
       else {
           request.getRequestDispatcher("404.jsp");
    }
    }
}