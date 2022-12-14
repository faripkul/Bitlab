package kz.bitlab.servlets.JDBStask1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/HomeJDBS_1")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("Spisok", DBMyUtil.getStudents());
        request.getRequestDispatcher("FirstTaskJDBS/FirstStr.jsp").forward(request, response);

    }

}
