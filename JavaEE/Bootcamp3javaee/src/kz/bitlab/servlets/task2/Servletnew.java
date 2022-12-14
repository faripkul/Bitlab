package kz.bitlab.servlets.task2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servletnew", value = "/Servletnew")
public class Servletnew extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("newnovosty", ArrayNovostei.getOdnucategory(request.getParameter("category")));
       request.getRequestDispatcher("SecondTaskJSP/glavnStranica.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
