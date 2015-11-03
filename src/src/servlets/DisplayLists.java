package src.servlets;

import java.io.*;
import java.util.*;
import src.lists.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.annotation.WebServlet;

/**
 * Project: Definery
 * Class: Display Lists Servlet
 * Created by Meesh
 * 10/11/15
 */

public class DisplayLists extends HttpServlet {
    Properties properties;
    SortByer sortByer;
    Lists lists;

    public DisplayLists() {

    }

    public DisplayLists(Properties properties) {
        this.properties = properties;
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lists = new Lists();
        sortByer = new SortByer();

        HttpSession session = request.getSession();
        String sortParam = (String)session.getAttribute("sortParam");
            if (sortParam == null) {
                sortByer.setSortType("newest");
            } else {
                sortByer.setSortType(sortParam);
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

        ArrayList entries = sortByer.getSortedResults();
            session.setAttribute("entries", entries);

        String url = "/lists.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }
}