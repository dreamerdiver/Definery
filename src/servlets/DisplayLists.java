package servlets;

import java.util.*;
import src.lists.*;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project: Definery
 * Class: Display Lists Servlet
 * Created by Meesh
 * 10/11/15
 */

public class DisplayLists extends HttpServlet {
    Properties properties;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        sortByer.setSortType(sortParam);
        System.out.println("sortbyer.gettype: " + sortByer.getSortType());
        System.out.println("sortparam: " + sortParam);

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