package kz.bitlab.servlets.JDBStask1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/DeleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String studentId = request.getParameter("id");
        Long id = Long.valueOf(0);

        try {
            id = Long.parseLong(studentId);
        } catch (Exception e) {

        }


        DBMyUtil.deleteStudent(id);
        response.sendRedirect("/");
    }
}