package kz.bitlab.servlets.SessionTaskThree;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/home35")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/SessionThirdTask/AvtorizStr.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/home35?usererror";
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users x = DBMyUtil.getUserByEmail(email);
        if (x != null) {
            redirect = "/home35?passworderror";
            if (x.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", x);
                redirect = "/profile";
            }
        }
        response.sendRedirect(redirect);
    }
}
