package src.login;

import org.apache.log4j.Logger;

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

    public UserRole() {
    }

    public UserRole(int userID) {
        logger.info("UserRole: Created 'UserRole' instance");
        setUserID(userID);
        setUserRole("defineryUser");
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
