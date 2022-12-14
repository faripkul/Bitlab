package kz.bitlab.servlets.SessionTaskTwo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/AddVKorzinuServlet")
public class AddVKorzinuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Tovars>tovary = (ArrayList<Tovars>) request.getSession().getAttribute("itemTovary");
        request.setAttribute("itemTovary", tovary);
        request.getRequestDispatcher("/SessionFirstTask/Korzina.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Tovars> korzina = new ArrayList<>();
        if (request.getSession().getAttribute("itemTovary")!=null) {
           korzina = (ArrayList<Tovars>) request.getSession().getAttribute("itemTovary");
            }
        Tovars tovar = ArrayTovars.getTovarById(Integer.parseInt(request.getParameter("id")));
        korzina.add(tovar);
        request.getSession().setAttribute("itemTovary", korzina);
        response.sendRedirect("/AddVKorzinuServlet");


    }
}

