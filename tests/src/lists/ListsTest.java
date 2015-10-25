package src.lists;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 10/24/15
 */
public class ListsTest {
    Properties properties;

    @Test
    public void testMakeConnection() throws Exception {
        Connection connection = null;

        try {
            Class.forName(properties.getProperty("mysql.driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("mysql.username"),
                    properties.getProperty("mysql.password"));

        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database " + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        assertNotNull("The connection is null", connection);
    }

    @Test
    public void testAddEntry() throws Exception {

    }

    @Test
    public void testSortListsByNewest() throws Exception {

    }

    @Test
    public void testSortListsByOldest() throws Exception {

    }

    @Test
    public void testSortListsByVoteCount() throws Exception {

    }

    @Test
    public void testSortListsByAlphabetical() throws Exception {

    }
}