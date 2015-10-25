/**
 * Project:Definery
 * Class: Servlet Test
 * Created by Meesh
 * 10/3/15
 */


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Welcome '" + request.getRemoteUser() + "'");
        out.println("<br/><hr/>");

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.print("Header Name: <em>" + headerName);
            String headerValue = request.getHeader(headerName);
            out.print("</em>, Header Value: <em>" + headerValue);
            out.println("</em><br/>");
        }

        out.println("<br/><hr/>");
        out.println("<a href=\"logout.jsp\">Click here to log out</a>");
    }
}