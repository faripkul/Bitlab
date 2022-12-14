package kz.bitlab.servlets.ProjectJavaEE;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/avtorizServlet")
public class AvtorizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ProjectJavaEE/strAvtor.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/avtorizServlet?polzovatelerror";
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Polzovatel x = DBMyUtil.getPolzovatelByLogin(login);
        if(x!=null){
            redirect = "/avtorizServlet?passworderror";
            if(x.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("currentPolzovatel", x);
                redirect = "/profile2";
            }
        }
        response.sendRedirect(redirect);
    }
}
