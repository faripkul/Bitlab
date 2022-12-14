package kz.bitlab.servlets.JDBStask3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/AddCityServlet")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/ThirdTaskJDBS/AddCity.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("cit_name");
      String code = request.getParameter("cit_code");


        Cities citty = new Cities();
        citty.setName(name);
        citty.setCode(code);

        DBMyUtil.addCitiez(citty);
        response.sendRedirect("/CitiesServlet");
    }
}
