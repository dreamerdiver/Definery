package src.servlets;

import java.io.*;
import java.util.*;
import src.lists.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Project: Definery
 * Class: Display Lists Servlet
 * Created by Meesh
 * 10/11/15
 */

public class DisplayLists extends HttpServlet {

    Properties properties;

    public DisplayLists() {

    }

    public DisplayLists(Properties properties) {
        this.properties = properties;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Welcome '" + request.getRemoteUser() + "'");

        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        String sortParam = request.getParameter("sortParam");
        System.out.println(sortParam);
        Lists lists = (Lists)context.getAttribute("list");

        Enumeration options = request.getParameterNames();
            while (options.hasMoreElements()) {
                Object object = options.nextElement();
                String value = request.getParameter((String)object);
            }

        SortByer sortByer = new SortByer();
            if (sortParam == null) {
                sortByer.setSortType("newest");
            } else {
                sortByer.setSortType(sortParam);
                System.out.println("sortbyer.gettype: " + sortByer.getSortType());
                System.out.println("sortparam: " + sortParam);
            }
            switch (sortByer.getSortType()) {
                case "newest" :
                    lists.sortListsByNewest(sortByer);
                    break;
                case "oldest" :
                    lists.sortListsByOldest(sortByer);
                    break;
                case "voteCount" :
                    lists.sortListsByVoteCount(sortByer);
                    break;
                case "alphabetical" :
                    lists.sortListsByAlphabetical(sortByer);
                    break;
            }
            session.setAttribute("searchInstance", sortByer);

        List<Entry> entries = sortByer.getSortedResults();
            session.setAttribute("entries", entries);

        String url = "/lists.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }
}