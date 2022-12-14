package kz.bitlab.servlets.JDBStask3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.servlets.JDBStask1.Students;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/DetailsStudServlet2")
public class DetailsStudServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     Long id = Long.parseLong(request.getParameter("id"));
     String idString = request.getParameter("id");
     Long id = Long.valueOf(0);
     try{
         id = Long.parseLong(idString);

     }catch (Exception e){

     }


     Students2 student = DBMyUtil.getStudent2(id);
     request.setAttribute("ssstudent", student);

        ArrayList<Cities> citiz = DBMyUtil.getCityess();
        request.setAttribute("strany", citiz);

     request.getRequestDispatcher("/ThirdTaskJDBS/DetailsStud2.jsp").forward(request,response);

    }
}
