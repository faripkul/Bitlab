package kz.bitlab.servlets.SessionTaskOne;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/ThirdServlet")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/SessionFirstTask/stepThree.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     ClientForm client = (ClientForm) request.getSession().getAttribute("CURRENT_SAVE_USER");

      String univercity = request.getParameter("user_university");
      String faculty = request.getParameter("user_faculty");
      String group = request.getParameter("user_group");

      client.setUnivercity(univercity);
      client.setFaculty(faculty);
      client.setGroup(group);

      request.getSession().setAttribute("CURRENT_SAVE_USER", client);
      response.sendRedirect("/FinishServlet");

    }
}
