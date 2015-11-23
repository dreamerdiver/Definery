package src.servlets;

/**
 * Project: Definery
 * Class: SubmitEntry
 * Created by Meesh
 * 10/11/15
 */

import org.apache.log4j.Logger;
import src.lists.Entry;
import src.lists.Lists;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class SubmitEntry extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Lists lists = new Lists();
        Entry entry = new Entry();
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        logger.info("SubmitEntry: session.getSession() completed successfully");

        String word = request.getParameter("word");
        String pos = request.getParameter("pos");
        String pronunciation = request.getParameter("pronunciation");
        String pocketDefinition = request.getParameter("pocket_definition");
        String completeDefinition = request.getParameter("complete_definition");
        String usage = request.getParameter("exampleUsage");
        String variations = request.getParameter("variations");
        String etymology = request.getParameter("etymology_roots");
        String submitter = request.getRemoteUser();

        entry.setWord(word);
        entry.setPartOfSpeech(pos);
        entry.setPronunciation(pronunciation);
        entry.setPocketDefinition(pocketDefinition);
        entry.setCompleteDefinition(completeDefinition);
        entry.setExampleUsage(usage);
        entry.setVariations(variations);
        entry.setEtymologyRoots(etymology);
        entry.setSubmitter(submitter);
        entry.setSubmittedDate(new Date());
        entry.setVoteCount(1);

        lists.addEntry(entry);
        session.setAttribute("submissionMessage", "Successfully added entry: " + entry.getWord());
        logger.info("SubmitEntry: '" + entry.getWord() + "' was set as 'submissionMessage' attribute");

        String url = "/submit.jsp";
        response.sendRedirect(url);
        logger.info("SubmitEntry: response.sendRedirect() to url '" + url + "' completed successfully");
    }
}
