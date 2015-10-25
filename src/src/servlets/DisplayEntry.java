package src.servlets;

import src.lists.*;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Project:
 * Class:
 * Created by Meesh
 * 10/12/15
 */

public class DisplayEntry extends HttpServlet {
    Properties properties;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/entry.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}