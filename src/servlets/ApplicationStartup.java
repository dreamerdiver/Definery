package servlets;

import src.lists.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Project:
 * Class:
 * Created by Meesh
 * 10/11/15
 */
public class ApplicationStartup extends HttpServlet {

    public void init() {
        ServletContext context = getServletContext();
        System.out.println(context);

        Properties properties = new Properties();
            try {
                properties.load(this.getClass().getResourceAsStream("definery.properties"));
            } catch(IOException ioe) {
                System.out.println("Can't load the properties file");
                ioe.printStackTrace();
            }catch(Exception e) {
                System.out.println("Problem: " + e);
                e.printStackTrace();
            }
            context.setAttribute("defineryProperties", properties);
        Lists lists = new Lists(properties);
            context.setAttribute("list", lists);
        Entry entry = new Entry(properties);
            context.setAttribute("entry", entry);
    }
}
