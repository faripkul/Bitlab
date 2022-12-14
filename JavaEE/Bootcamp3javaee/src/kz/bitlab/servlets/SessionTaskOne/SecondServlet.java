package kz.bitlab.servlets.SessionTaskOne;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/SecondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/SessionFirstTask/stepTwo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     ClientForm client = (ClientForm) request.getSession().getAttribute("CURRENT_SAVE_USER");

      String city = request.getParameter("user_city");
      String address = request.getParameter("user_address");
      String phone = request.getParameter("user_phone");

      client.setCity(city);
      client.setAddress(address);
      client.setPhone(phone);

      request.getSession().setAttribute("CURRENT_SAVE_USER", client);
      response.sendRedirect("/ThirdServlet");

    }
}
