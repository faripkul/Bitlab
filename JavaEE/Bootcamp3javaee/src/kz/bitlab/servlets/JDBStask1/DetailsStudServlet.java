package kz.bitlab.servlets.JDBStask1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/DetailsStudServlet")
public class DetailsStudServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     Long id = Long.parseLong(request.getParameter("id"));
     String idString = request.getParameter("id");
     Long id = Long.valueOf(0);
     try{
         id = Long.parseLong(idString);

     }catch (Exception e){

     }


     Students student = DBMyUtil.getStudent(id);
     request.setAttribute("student", student);
     request.getRequestDispatcher("/FirstTaskJDBS/DetailsStud.jsp").forward(request,response);

    }
}
