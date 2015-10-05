/**
 * Project:
 * Class:
 * Created by Meesh
 * 10/4/15
 */


//import src.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.annotation.*;

/*
@WebServlet(
        name = "AddEntry",
        urlPatterns = { "/addEntry" }
)*/

public class AddEntry extends HttpServlet{

    //private Properties properties;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        Entry entry = (Entry)context.getAttribute("entry");
            entry.setWord(word);
            entry.setPartOfSpeech(pos);
            entry.setPronunciation(pronunciation);
            entry.setPocketDefinition(pocketDefinition);
            entry.setCompleteDefinition(completeDefinition);
            entry.setUsage(usage);
            entry.setVariations(variations);
            entry.setEtymology(etymology);
            entry.setSubmitter(request.getRemoteUser());
            entry.setSubmitDate(new java.util.Date());

        System.out.println(entry);

        Lists list = new Lists();
            list.addEntryToLists(entry);

        /*
        EmployeeDirectory directory = (EmployeeDirectory)context.getAttribute("employeeDirectory");
        directory.addEmployee(firstName, lastName, ssn, department, roomNumber, phoneNumber);
        */

        session.setAttribute("submissionMessage", entry.createTestEntryOutput());

        String url = "/submit.jsp";
        response.sendRedirect(url);
    }
}
