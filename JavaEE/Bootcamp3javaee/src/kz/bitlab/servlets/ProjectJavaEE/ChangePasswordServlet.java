package kz.bitlab.servlets.ProjectJavaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ProjectJavaEE/changePassword.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Polzovatel polzovatel = (Polzovatel) request.getSession().getAttribute("currentPolzovatel");
        String redirect = "/changePassword";

        if (polzovatel != null) {

            redirect = "/changePassword?oldpassworderror";

            String oldPassword = request.getParameter("old_password");
            String newPassword = request.getParameter("new_password");
            String reNewPassword = request.getParameter("re_new_password");

            if (polzovatel.getPassword().equals(oldPassword)) {

                redirect = "/changePassword?passworderror";

                if (newPassword.equals(reNewPassword)) {
                    polzovatel.setPassword(newPassword);
                    DBMyUtil.changePassword(polzovatel);

                    redirect = "/changePassword?passwordsuccess";
                }
            }
        }
        response.sendRedirect(redirect);
    }
}