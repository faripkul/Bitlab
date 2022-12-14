package kz.bitlab.servlets.task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/additem")
public class addItemServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("item_name");
        String country = request.getParameter("item_country");
        String price = request.getParameter("item_price");
        String amount = request.getParameter("item_amount");

        Items item = new Items();
        item.setName(name);
        item.setPrice(Double.parseDouble(price));
        item.setAmount(Integer.parseInt(amount));

        DBManager.addItem(item);

        response.sendRedirect("/");

    }
}
