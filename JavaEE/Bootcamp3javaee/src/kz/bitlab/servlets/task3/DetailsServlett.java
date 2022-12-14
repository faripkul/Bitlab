package kz.bitlab.servlets.task3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/Detailss")
public class DetailsServlett extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Tasks task = DBManager.getTask(id);

        if (task != null) {
            request.setAttribute("task", task);
            request.getRequestDispatcher("/ThirdTaskJSP/Detailz.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("/404.jsp").forward(request,response);
        }
    }
}

