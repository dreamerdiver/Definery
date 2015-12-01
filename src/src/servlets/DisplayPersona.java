package src.servlets;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/28/15
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

public class DisplayPersona extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lists lists = new Lists();
        Entry entry = new Entry();
        SortByer sortByer = new SortByer();
        HttpSession session = request.getSession();
        String currentUser = request.getRemoteUser();

        session.setAttribute("sortByer", sortByer);
        entry.setSubmitter(currentUser);
        logger.info("DisplayPersona: currentUser set to " + entry.getSubmitter());
            if (currentUser.length() < 0) {
                logger.info("DisplayPersona: The 'currentUser' attribute is set to " + entry.getSubmitter() + ", which is null or blank");
            } else {
                lists.displayPersonaData(entry, sortByer);
            }
        logger.info("DisplayPersona: lists.displayPersonsData(sortByer, entryTable) sent: " + sortByer + ", " + currentUser);

        ArrayList entries = sortByer.getSortedResults();
        session.setAttribute("entries", entries);
        logger.info("DisplayPersona: " + sortByer.getSortedResults() + " was set as 'entries' attribute");

        String url = "/persona.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        logger.info("DisplayPersona: dispatcher.forward() to '" + url + "' completed successfully");
    }
}
