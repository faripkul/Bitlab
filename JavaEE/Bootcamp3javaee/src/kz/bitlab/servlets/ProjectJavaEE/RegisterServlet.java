package kz.bitlab.servlets.ProjectJavaEE;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ProjectJavaEE/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String redirect = "/register?passworderror";

       String name = request.getParameter("name");
       String login = request.getParameter("login");
       String password = request.getParameter("password");
       String rePassword = request.getParameter("re_password");

       if(password.equals(rePassword)){
          redirect="/register?emailerror";
          Polzovatel user = DBMyUtil.getPolzovatelByLogin(login);
          if(user==null){
           Polzovatel newUser=new Polzovatel();
           newUser.setName(name);
           newUser.setLogin(login);
           newUser.setPassword(password);

           DBMyUtil.addNewUser(newUser);

           redirect="/register?success";
          }
       }
         response.sendRedirect(redirect);
            }
        }
