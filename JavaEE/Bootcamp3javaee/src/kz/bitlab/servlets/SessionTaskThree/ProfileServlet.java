package kz.bitlab.servlets.SessionTaskThree;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("currentUser");
        if (user != null) {
            request.getRequestDispatcher("/SessionThirdTask/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("/home35");
        }
    }
}

