package kz.bitlab.servlets.task3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet( value = "/home10")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("zadachi", DBMyUtil.getTasks());
        request.getRequestDispatcher("ThirdTaskJSP/glavnStranica.jsp").forward(request, response);

    }

}
