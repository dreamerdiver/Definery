package src.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Project: Definery
 * Class: LoggerUtil
 * Created by Meesh
 * 11/18/15
 */

public class LoggerUtil {

    public static void error(String message, String classname) {
        Logger logger = LogManager.getLogger(classname);
        logger.error(message);
    }
}
