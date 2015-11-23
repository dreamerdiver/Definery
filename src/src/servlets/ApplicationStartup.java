package src.servlets;

/**
 * Project: Definery
 * Class: ApplicationStartup
 * Created by Meesh
 * 10/11/15
 */

import org.apache.log4j.Logger;
import src.lists.Entry;
import src.lists.Lists;
import src.lists.SortByer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

public class ApplicationStartup extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init() {
        ServletContext context = getServletContext();
        logger.info("ApplicationStartup: getServletContext() '" + context + "' completed successfully");

        Properties properties = new Properties();
            try {
                properties.load(this.getClass().getResourceAsStream("/definery.properties"));
            } catch(IOException ioe) {
                System.err.println("Can't load the properties file");
                ioe.printStackTrace();
            }catch(Exception e) {
                System.err.println("Problem: " + e);
                e.printStackTrace();
            }
            context.setAttribute("properties", properties);
            if (properties.size() > 0) {
                logger.info("ApplicationStartup: Properties Set: YES");
            } else {
                logger.info("ApplicationStartup: Properties Not Set");
            }
        Lists lists = new Lists();
            context.setAttribute("lists", lists);
        Entry entry = new Entry();
            context.setAttribute("entry", entry);
        SortByer sortByer = new SortByer();
            context.setAttribute("sortByer", sortByer);
    }
}
