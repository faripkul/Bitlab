package kz.bitlab.servlets.JDBStask1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/addstudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/FirstTaskJDBS/AddStudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("stud_name");
        String surname = request.getParameter("stud_surname");
        String birthdate = request.getParameter("stud_birthdate");
        String city = request.getParameter("stud_city");



        Students student = new Students();
        student.setName(name);
        student.setSurname(surname);
        student.setBirthdate(birthdate);
        student.setCity(city);

        DBMyUtil.addStudent(student);
        response.sendRedirect("/addstudent?success");

    }
}
