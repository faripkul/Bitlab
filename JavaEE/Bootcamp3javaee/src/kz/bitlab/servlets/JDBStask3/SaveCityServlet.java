package kz.bitlab.servlets.JDBStask3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/saveCity")
public class SaveCityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("cit_name");
        String surname = request.getParameter("cit_code");

        String cityId=request.getParameter("id");
        Long id = Long.valueOf(0);

        try{
          id=Long.parseLong(cityId);
        }catch (Exception e) {

        }


        Cities citiss = DBMyUtil.getCity(id);

        if(citiss!=null) {
            citiss.setName(name);
            citiss.setCode(surname);

            DBMyUtil.upDateCity(citiss);

            response.sendRedirect("/DetailsCityServlet?id="+id);
        }else{
            response.sendRedirect("/");
        }
    }
}
