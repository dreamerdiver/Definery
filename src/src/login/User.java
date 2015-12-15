package src.login;

/**
 * Project: Definery
 * Class: User
 * Created by Meesh
 * 11/10/15
 */

import org.apache.log4j.Logger;

public class User {
    private final Logger logger = Logger.getLogger(this.getClass());
    private int userID;
    private String user_name;
    private String user_pass;
    private String userRole;
    private String userData;

    public User() {
    }

    public User(int userID, String username, String password) {
        logger.info("User: Created 'User' instance");
        this.userID = userID;
        this.user_name = username;
        this.user_pass = password;
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
        return user_name;
    }
    public void setUsername(String username) {
        this.user_name = username;
    }

    public String getPassword() {
        return user_pass;
    }
    public void setPassword(String password) {
        this.user_pass = password;
    }

    public String getUserRole() {
        return userRole;
    }
    private void setUserRole() {
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

    public String createUserReport(){
        return  "UserID: " + getUserID() +
                "\nUsername: " + getUsername() +
                "\nPassword: " + getPassword() +
                "\nUser Role: " + getUserRole() +
                "\nUser Data: " + getUserData() + "\n";
    }
}

