package kz.bitlab.servlets.task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/home")
    public class HomeServlet extends HttpServlet {


        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ArrayList<Items>items=DBManager.getItems();
            request.setAttribute("tovary", items);
            request.getRequestDispatcher("/Spisok.jsp").forward(request,response);
        }
    }

