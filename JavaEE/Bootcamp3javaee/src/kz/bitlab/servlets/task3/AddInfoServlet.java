package kz.bitlab.servlets.task3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/addinfo")
public class AddInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("task_name");
    String description = request.getParameter("task_opisanie");
    String deadlineDate = request.getParameter("task_data");




    Tasks task = new Tasks();
    task.setName(name);
    task.setDescription(description);
    task.setDeadlineDate(deadlineDate);

    DBManager.addTask(task);
    response.sendRedirect("/");

    }
}
