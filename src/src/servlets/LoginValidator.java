package src.servlets;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 12/1/15
 */

import org.apache.log4j.Logger;
import src.login.LoginValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginValidator extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //User user = new User();
        String url = "/validLogin.jsp";
        String url2Test = "/failedLogin.jsp";
        HttpSession session = request.getSession();
        String username = request.getParameter("j_username");
        String passwordAttempt = request.getParameter("j_password");
        RequestDispatcher dispatcher = new RequestDispatcher() {
            @Override
            public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            }

            @Override
            public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            }
        };

        LoginValidation loginAttempt = new LoginValidation(username, passwordAttempt);
            logger.info("LoginValidator: Login Attempt: U: '" + username + "' P: '" + passwordAttempt);

        if (loginAttempt.sendConfirmation()) {
            dispatcher = getServletContext().getRequestDispatcher(url);
        } else if (!loginAttempt.sendConfirmation()) {
            dispatcher = getServletContext().getRequestDispatcher(url2Test);

        }

        dispatcher.forward(request, response);
            logger.info("LoginValidator: dispatcher.forward() to url '" + url + "' completed successfully");
    }
}
