package src.servlets;

import src.lists.Entry;
import src.lists.Lists;
import src.lists.SortByer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

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
            context.setAttribute("definery.properties", properties);
        Lists lists = new Lists();
            context.setAttribute("lists", lists);
        Entry entry = new Entry(properties);
            context.setAttribute("entry", entry);
        SortByer sortByer = new SortByer();
            context.setAttribute("sortByer", sortByer);
    }
}
