package src.servlets;

import org.apache.log4j.Logger;
import src.lists.Entry;
import src.lists.Lists;
import src.lists.SortByer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 12/6/15
 */

public class SendVoteRequest extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lists lists = new Lists();
        Entry entry = new Entry();
        SortByer sortByer = new SortByer();
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        String entryLabel = request.getParameter("entryLabel").replace("\'", "");
            logger.info("SendVoteRequest: session.getSession() completed successfully");

        session.setAttribute("sortByer", sortByer);
        entry.setWord(entryLabel);

        if (entryLabel.length() < 0) {
            logger.info("SendVoteRequest: The 'entryLabel' attribute is set to " + entry.getWord() + ", which is null or blank");
        } else {
            lists.sendVoteRequest(entry, sortByer);
        }
        logger.info("SendVoteRequest: lists.sendVoteRequest(entry) sent: " + entry.getWord());

        ArrayList entries = sortByer.getSortedResults();
        session.setAttribute("entries", entries);
        logger.info("SendVoteRequest: " + sortByer.getSortedResults() + " was set as 'entries' attribute");

        String url = "/lists.jsp";
        response.sendRedirect(url);
        logger.info("SendVoteRequest: response.sendRedirect() to url '" + url + "' completed successfully");
    }
}


