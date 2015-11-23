package src.login;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/11/15
 */

public class UserRole {
    private final Logger logger = Logger.getLogger(this.getClass());
    private int userID;
    private String userRole;
    private Properties properties;

    public UserRole() {
    }

    public UserRole(int userID) {
        logger.info("UserRole: Created 'UserRole' instance");
        loadProperties();
        setUserID(userID);
        setUserRole(properties.getProperty("default.role"));
    }

    public void loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/definery.properties"));
        } catch (IOException ioe) {
            System.err.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Problem: " + e);
            e.printStackTrace();
        }
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String createUserRoleReport() {
        return  "UserID: " + getUserID() +
                "\nUser Role: " + getUserRole() + "\n";
    }

}
