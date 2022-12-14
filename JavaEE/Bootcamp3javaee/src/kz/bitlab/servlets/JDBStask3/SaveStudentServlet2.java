package kz.bitlab.servlets.JDBStask3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.servlets.JDBStask1.Students;

import java.io.IOException;

@WebServlet(value = "/saveStudent2")
public class SaveStudentServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("stud_name");
        String surname = request.getParameter("stud_surname");
        String birthdate = request.getParameter("stud_birthdate");
        int cityID = Integer.parseInt(request.getParameter("stud_city"));

        String studentId=request.getParameter("id");
        Long id = Long.valueOf(0);

        try{
          id=Long.parseLong(studentId);
        }catch (Exception e) {

        }

        Students2 student= kz.bitlab.servlets.JDBStask3.DBMyUtil.getStudent2(id);
        Cities citiz = DBMyUtil.getCiti((long) cityID);

        if(student!=null) {
            student.setName(name);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(citiz);

            DBMyUtil.upDateStudentt(student);

            response.sendRedirect("/DetailsStudServlet2?id="+id);
        }else{
            response.sendRedirect("/");
        }
    }
}
