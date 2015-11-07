package src.servlets;

import src.lists.Lists;
import src.lists.SortByer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
//import javax.servlet.annotation.WebServlet;

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
        SortByer sortByer = new SortByer();
        Lists lists = new Lists();
        HttpSession session = request.getSession();
            session.setAttribute("sortByer", sortByer);
        String sortParam = request.getParameter("sortByOptions");
            if (sortParam == null) {
                sortByer.setSortType("alphabetical");
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

        ArrayList entries = sortByer.getSortedResults();
            session.setAttribute("entries", entries);

        String url = "/lists.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }
}