package kz.bitlab.servlets.JDBStask3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.servlets.JDBStask1.Students;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Cities> citiz = DBMyUtil.getCityess();
        request.setAttribute("strany", citiz);
        request.getRequestDispatcher("/ThirdTaskJDBS/AddStudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("stud_name");
      String surname = request.getParameter("stud_surname");
      String birthdate = request.getParameter("stud_birthdate");
      int cityID = Integer.parseInt(request.getParameter("stud_city"));

        Cities citiz = DBMyUtil.getCiti((long) cityID);

        Students2 student = new Students2();
        student.setName(name);
        student.setSurname(surname);
        student.setBirthdate(birthdate);
        student.setCity(citiz);



        DBMyUtil.addStudentz(student);
        response.sendRedirect("/");
    }
}
