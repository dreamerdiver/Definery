package src.login;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/11/15
 */
public class UserRole {
    private int userID;
    private String username;
    private String userRole;

    public UserRole() {
    }

    public UserRole(int userID, String username, String userRole) {
        this.userID = userID;
        this.username = username;
        this.userRole = userRole;
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

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String createTestUserRoleOutput() {
        return  "UserID: " + getUserID() +
                "\nUsername: "+ getUsername() +
                "\nUser Role: " + getUserRole() + "\n";
    }
}
