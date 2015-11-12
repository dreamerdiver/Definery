package src.login;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/11/15
 */

public class UserDriver {
    public static void main(String[] args) {
        User_DAO dao = new User_DAO();

        UserRole userRole = new UserRole(0, "test0", "test");
        UserData userData = new UserData(0, 465, "test", null, null);
        User user = new User(0, "test0", "test", userRole, userData);
        dao.addUserRole(user);
    }
}
