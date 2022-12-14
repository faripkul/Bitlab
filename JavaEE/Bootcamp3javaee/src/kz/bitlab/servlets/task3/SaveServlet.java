package kz.bitlab.servlets.task3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SaveServlet", value = "/SaveServlet")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("id"));
    String name = request.getParameter("task_name2");
    String description=request.getParameter("task_opisanie");
    String deadLineDate=request.getParameter("task_data");

    Tasks task=new Tasks(id,name,description,deadLineDate);
    DBManager.SaveTask(task);
        response.sendRedirect("/");
    }
}
