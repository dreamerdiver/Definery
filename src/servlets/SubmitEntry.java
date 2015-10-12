package servlets;

import src.lists.*;
import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project: Definery
 * Class: Submit Entry Servlet
 * Created by Meesh
 * 10/11/15
 */

public class SubmitEntry extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        String word = request.getParameter("word");
        String pos = request.getParameter("pos");
        String pronunciation = request.getParameter("pronunciation");
        String pocketDefinition = request.getParameter("pocket_definition");
        String completeDefinition = request.getParameter("complete_definition");
        String usage = request.getParameter("usage");
        String variations = request.getParameter("variations");
        String etymology = request.getParameter("etymology_roots");
        String submitter = request.getRemoteUser();
        Date submittedDate = new Date();

        Entry entry = (Entry)context.getAttribute("entry");
        entry.setWord(word);
        entry.setPartOfSpeech(pos);
        entry.setPronunciation(pronunciation);
        entry.setPocketDefinition(pocketDefinition);
        entry.setCompleteDefinition(completeDefinition);
        entry.setExampleUsage(usage);
        entry.setVariations(variations);
        entry.setEtymologyRoots(etymology);
        entry.setSubmitter(request.getRemoteUser());
        entry.setSubmittedDate(new java.util.Date());

        System.out.println(entry);

        Lists lists = (Lists)context.getAttribute("list");
        lists.addEntry();

        session.setAttribute("submissionMessage", entry.createTestEntryOutput());

        String url = "/submit.jsp";
        response.sendRedirect(url);
    }
}
