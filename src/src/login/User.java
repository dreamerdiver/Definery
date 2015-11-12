package src.login;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/10/15
 */
public class User {
    private int userID;
    private String username;
    private String password;
    private UserRole userRole;
    private UserData userData;

    public User() {
    }

    public User(int userID, String username, String password, UserRole userRole, UserData userData) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userData = userData;
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

    public UserRole getUserRole() {
        return userRole;
    }
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserData getUserData() {
        return userData;
    }
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String createTestUserOutput(){
        return  "UserID: " + getUserID() +
                "\nUsername: " + getUsername() +
                "\nPassword: " + getPassword() +
                "\nUser Role: " + getUserRole().createTestUserRoleOutput() +
                "\nUser Data: " + getUserData().createTestUserDataOutput() + "\n";
    }
}

