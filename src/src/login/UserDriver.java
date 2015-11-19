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
        User user = new User(0, "test0", "test");
        dao.addUserRole(user);
    }
}
