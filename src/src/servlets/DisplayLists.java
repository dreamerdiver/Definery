package src.servlets;

/**
 * Project: Definery
 * Class: Display Lists Servlet
 * Created by Meesh
 * 10/11/15
 */

import org.apache.log4j.Logger;
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

public class DisplayLists extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lists lists = new Lists();
        SortByer sortByer = new SortByer();
        HttpSession session = request.getSession();
            session.setAttribute("sortByer", sortByer);
        String sortParam = request.getParameter("sortByOptions");
        if (sortParam == null) {
                sortByer.setSortType("alphabetical");
            } else {
                sortByer.setSortType(sortParam);
            }
        logger.info("DisplayLists: sortParam was set to: " + sortByer.getSortType());
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
        logger.info("DisplayLists: " + sortByer.getSortedResults() + " was set as 'entries' attribute");

        String url = "/lists.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        logger.info("DisplayLists: dispatcher.forward() to url '" + url + "' completed successfully");
    }
}