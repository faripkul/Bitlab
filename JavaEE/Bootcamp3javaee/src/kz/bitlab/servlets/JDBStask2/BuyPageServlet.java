package kz.bitlab.servlets.JDBStask2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/BuyPageServlet")
public class BuyPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/SecondTaskJDBS/Buy.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String email = request.getParameter("email");
     String password =  request.getParameter("password");
     request.setAttribute("userz", DBMyUtil.Sravnit(email,password));


     String x= String.valueOf(DBMyUtil.Sravnit(email,password));
     if (x!=null){
         request.getRequestDispatcher("/SecondTaskJDBS/Sovpadaet.jsp").forward(request,response);
     }
     else {
         request.getRequestDispatcher("/SecondTaskJDBS/Error.jsp").forward(request,response);
     }
    }
}
