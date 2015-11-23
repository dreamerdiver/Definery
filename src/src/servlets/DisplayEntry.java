package src.servlets;

/**
 * Project: Definery
 * Class: DisplayEntry
 * Created by Meesh
 * 10/12/15
 */

import org.apache.log4j.Logger;
import src.lists.Entry;
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

public class DisplayEntry extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lists lists = new Lists();
        Entry entry = new Entry();
        SortByer sortByer = new SortByer();
        HttpSession session = request.getSession();
        String entryLabel = request.getParameter("entryLabel").replace("\'", "");

        session.setAttribute("sortByer", sortByer);
        entry.setWord(entryLabel);
        logger.info("DisplayEntry: entryLabel set to " + entry.getWord());
        if (entryLabel.length() < 0) {
            logger.info("yuh fucked up");
        } else {
            lists.displayEntryTable(entry, sortByer);
        }
        logger.info("DisplayEntry: lists.displayEntryTable(sortByer, entryTable) sent: " + sortByer + ", " + entryLabel);

        ArrayList entries = sortByer.getSortedResults();
        session.setAttribute("entries", entries);
        logger.info("DisplayEntry: " + sortByer.getSortedResults() + " was set as 'entries' attribute");

        String url = "/entry.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        logger.info("DisplayEntry: dispatcher.forward() to '" + url + "' completed successfully");
    }
}