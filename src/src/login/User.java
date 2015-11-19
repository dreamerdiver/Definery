package src.login;

import org.apache.log4j.Logger;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/10/15
 */
public class User {
    private final Logger logger = Logger.getLogger(this.getClass());
    private int userID;
    private String username;
    private String password;
    private String userRole;
    private String userData;

    public User() {
    }

    public User(int userID, String username, String password) {
        logger.info("User: Created 'User' instance");
        this.userID = userID;
        this.username = username;
        this.password = password;
        setUserRole();
        setUserData();
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }
    public void setUserRole() {
        UserRole insertUserRole = new UserRole(userID);
        this.userRole = insertUserRole.createUserRoleReport();
    }

    public String getUserData() {
        return userData;
    }
    public void setUserData() {
        UserData insertUserData = new UserData(userID);
        userData = insertUserData.createUserDataReport();
    }

    public String getUserReport(){
        return  "UserID: " + getUserID() +
                "\nUsername: " + getUsername() +
                "\nPassword: " + getPassword() +
                "\nUser Role: " + getUserRole() +
                "\nUser Data: " + getUserData() + "\n";
    }
}

