package kz.bitlab.servlets.JDBStask1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.servlets.JDBStask1.DBMyUtil;
import kz.bitlab.servlets.JDBStask1.Students;

import java.io.IOException;

@WebServlet(value = "/saveStudent")
public class SaveStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("stud_name");
        String surname = request.getParameter("stud_surname");
        String birthdate = request.getParameter("stud_birthdate");
        String city = request.getParameter("stud_city");

        String studentId=request.getParameter("id");
        Long id = Long.valueOf(0);

        try{
          id=Long.parseLong(studentId);
        }catch (Exception e) {

        }

        Students student=DBMyUtil.getStudent(id);

        if(student!=null) {
            student.setName(name);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(city);

            DBMyUtil.upDateStudent(student);

            response.sendRedirect("/DetailsStudServlet?id="+id);
        }else{
            response.sendRedirect("/");
        }
    }
}
