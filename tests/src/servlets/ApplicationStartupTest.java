package src.servlets;

import junit.framework.TestCase;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 10/24/15
 */
public class ApplicationStartupTest extends TestCase {

    @Test
    public void testInit() throws Exception {
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doGet(req, resp);
            }
        };
        ServletContext context = servlet.getServletContext();
        assertNotNull("Context is null", context);
    }
}