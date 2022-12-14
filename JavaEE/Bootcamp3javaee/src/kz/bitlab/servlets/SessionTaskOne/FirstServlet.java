package kz.bitlab.servlets.SessionTaskOne;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/SessionFirstTask/stepOne.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     ClientForm client = new ClientForm();

      String name = request.getParameter("user_name");
      String surname = request.getParameter("user_surname");
      String age = request.getParameter("user_age");

      client.setName(name);
      client.setSurname(surname);
      client.setAge(age);

      request.getSession().setAttribute("CURRENT_SAVE_USER", client);
      response.sendRedirect("/SecondServlet");

    }
}
