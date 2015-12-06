package src.login;

import org.apache.log4j.Logger;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 12/1/15
 */
public class LoginValidation {
    private final Logger logger = Logger.getLogger(this.getClass());

    public LoginValidation(String username, String password) {
        logger.info("LoginValidation got '" + username + "' and '" + password);
    }

    public boolean sendConfirmation() {
        return true;
    }
}
