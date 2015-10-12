package servlets;

import src.lists.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project:
 * Class:
 * Created by Meesh
 * 10/12/15
 */

public class DisplayEntry extends HttpServlet {
    Properties properties;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        String sortParam = request.getParameter("sortParam");
        Lists lists = (Lists)context.getAttribute("list");

        String url = "/lists.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}