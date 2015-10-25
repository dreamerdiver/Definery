package src.servlets;

import java.io.*;

import src.lists.Entry;
import src.lists.Lists;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

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
        entry.setSubmitter(submitter);
        entry.setSubmittedDate(submittedDate);

        System.out.println(entry);

        Lists lists = (Lists)context.getAttribute("list");
        lists.addEntry();

        session.setAttribute("submissionMessage", entry.createTestEntryOutput());

        String url = "/submit.jsp";
        response.sendRedirect(url);
    }
}
