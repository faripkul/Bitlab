package kz.bitlab.servlets.JDBStask3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/DetailsCityServlet")
public class DetailsCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     Long id = Long.parseLong(request.getParameter("id"));
     String idString = request.getParameter("id");
     Long id = Long.valueOf(0);
     try{
         id = Long.parseLong(idString);

     }catch (Exception e){

     }


     Cities citi=DBMyUtil.getCity(id);
     request.setAttribute("citty", citi);
     request.getRequestDispatcher("/ThirdTaskJDBS/DetailsCity.jsp").forward(request,response);

    }
}
