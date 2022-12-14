package kz.bitlab.servlets.JDBStask4;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Items> itemz = DBMyUtil.getItems();
        request.setAttribute("goroda", itemz);
        request.getRequestDispatcher("/JDBS4/AddItem.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String name = request.getParameter("item_name");
     String description = request.getParameter("item_description");
     Double price = Double.valueOf(request.getParameter("item_price"));
     int brandID = Integer.parseInt(request.getParameter("item_brand"));

     Items item = new Items();
     item.setName(name);
     item.setDescription(description);
     item.setPrice(price);
//     item.setBrand(brandID);

     DBMyUtil.addItems(item);
     response.sendRedirect("/AddItemServlet");

    }
}
