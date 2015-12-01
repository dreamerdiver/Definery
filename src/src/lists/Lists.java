package src.lists;

/**
 * Project: Definery
 * Class: Lists
 * Created by Meesh
 * 10/4/15
 */

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class Lists {
    private final Logger logger = Logger.getLogger(this.getClass());
    private Properties properties;

    public Lists() {
        logger.info("Lists: Created empty 'Lists' instance");
        loadProperties();
    }

    public void loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/definery.properties"));
        } catch (IOException ioe) {
            System.err.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Problem: " + e);
            e.printStackTrace();
        }
    }

    protected Connection makeConnection() {
        Connection connection;
        try {
            Class.forName(properties.getProperty("mysql.driver"));
            connection = DriverManager.getConnection(properties.getProperty("definery.url"),
                                                     properties.getProperty("mysql.username"),
                                                     properties.getProperty("mysql.password"));
        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
            return null;
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database " + sqlException);
            sqlException.printStackTrace();
            return null;
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
            return null;
        }
        return connection;
    }

    public void addEntry(Entry entry) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();
        try {
            String addQueryString = "insert into entries (word, part_of_speech, pronunciation, pocket_definition, complete_definition, example_usage, variations, etymology_roots, submitter, submitted_date, vote_count)" +
                                    "values ("+entry.getWord()+", "+entry.getPartOfSpeech()+", "+entry.getPronunciation()+", "+entry.getPocketDefinition()+", "+entry.getCompleteDefinition()+", "+entry.getExampleUsage()+", "+entry.getVariations()+", "+entry.getEtymologyRoots()+", "+entry.getSubmitter()+", null, 1);";

            statement = connection.prepareStatement(addQueryString);
            statement.executeUpdate(addQueryString);
            logger.info("Lists: lists.addEntry: statement.executeUpdate(addQueryString) completed successfully");

            String addConfirmation = "select * from entries where word="+entry.getWord()+"";
            resultSet = statement.executeQuery(addConfirmation);
            logger.info("Lists: lists.addEntry: statement.executeQuery(addConfirmation) {" + addConfirmation + "} completed successfully");
            while (resultSet.next()) {
                String word = resultSet.getString("word");
                String pos = resultSet.getString("part_of_speech");
                String pronunciation = resultSet.getString("pronunciation");
                String pocketDefinition = resultSet.getString("pocket_definition");
                String completeDefinition = resultSet.getString("complete_definition");
                String example_usage = resultSet.getString("example_usage");
                String variations = resultSet.getString("variations");
                String etymology = resultSet.getString("etymology_roots");
                String submitter = resultSet.getString("submitter");
                Date submittedDate = resultSet.getDate("submitted_date");
                int voteCount = resultSet.getInt("vote_count");

                System.out.println("Instance: " + word
                        + ", " + pos
                        + ", " + pronunciation
                        + ", " + pocketDefinition
                        + ", " + completeDefinition
                        + ", " + example_usage
                        + ", " + variations
                        + ", " + etymology
                        + ", " + submitter
                        + ", " + submittedDate
                        + ", " + voteCount);
            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database" + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    logger.info("Lists: lists.addEntry: connection.close() completed successfully");
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }

    public void sortListsByNewest(SortByer sortByer) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();
        logger.info("Lists: lists.sortListsByNewest: Sorted By: " + sortByer.getSortType());
        try {
            statement = connection.createStatement();
            String IDQueryString ="select * from entries ORDER BY submitted_date DESC";
            resultSet = statement.executeQuery(IDQueryString);
            logger.info("Lists: lists.sortListsByNewest: statement.executeQuery(IDQueryString) completed successfully");
            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    Entry entry = new Entry();
                    entry.setWord(resultSet.getString("word"));
                    entry.setPartOfSpeech(resultSet.getString("part_of_speech"));
                    entry.setPronunciation(resultSet.getString("pronunciation"));
                    entry.setPocketDefinition(resultSet.getString("pocket_definition"));
                    entry.setCompleteDefinition(resultSet.getString("complete_definition"));
                    entry.setExampleUsage(resultSet.getString("example_usage"));
                    entry.setVariations(resultSet.getString("variations"));
                    entry.setEtymologyRoots(resultSet.getString("etymology_roots"));
                    entry.setSubmitter(resultSet.getString("submitter"));
                    entry.setSubmittedDate(resultSet.getDate("submitted_date"));
                    entry.setVoteCount(resultSet.getInt("vote_count"));

                    sortByer.addFoundEntry(entry);
                }
                logger.info("Lists: lists.sortListsByNewest: resultSet.next() completed successfully");
            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database" + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    logger.info("Lists: lists.sortListsByNewest: connection.close() completed successfully");
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }

    public void sortListsByOldest(SortByer sortByer) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();
        logger.info("Lists: lists.sortListsByOldest: Sorted By: " + sortByer.getSortType());
        try {
            statement = connection.createStatement();
            String IDQueryString ="select * from entries ORDER BY submitted_date ASC";
            resultSet = statement.executeQuery(IDQueryString);
            logger.info("Lists: lists.sortListsByOldest: statement.executeQuery(IDQueryString) completed successfully");
            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    Entry entry = new Entry();
                    entry.setWord(resultSet.getString("word"));
                    entry.setPartOfSpeech(resultSet.getString("part_of_speech"));
                    entry.setPronunciation(resultSet.getString("pronunciation"));
                    entry.setPocketDefinition(resultSet.getString("pocket_definition"));
                    entry.setCompleteDefinition(resultSet.getString("complete_definition"));
                    entry.setExampleUsage(resultSet.getString("example_usage"));
                    entry.setVariations(resultSet.getString("variations"));
                    entry.setEtymologyRoots(resultSet.getString("etymology_roots"));
                    entry.setSubmitter(resultSet.getString("submitter"));
                    entry.setSubmittedDate(resultSet.getDate("submitted_date"));
                    entry.setVoteCount(resultSet.getInt("vote_count"));

                    sortByer.addFoundEntry(entry);
                }
                logger.info("Lists: lists.sortListsByOldest: resultSet.next() completed successfully");
            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database" + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    logger.info("Lists: lists.sortListsByOldest: connection.close() completed successfully");
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }

    public void sortListsByVoteCount(SortByer sortByer) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();
        logger.info("Lists: lists.sortListsByVoteCount: Sorted By: " + sortByer.getSortType());
        try {
            statement = connection.createStatement();
            String IDQueryString ="select * from entries ORDER BY vote_count DESC";
            resultSet = statement.executeQuery(IDQueryString);
            logger.info("Lists: lists.sortListsByVoteCount: statement.executeQuery(IDQueryString) completed successfully");
            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    Entry entry = new Entry();
                    entry.setWord(resultSet.getString("word"));
                    entry.setPartOfSpeech(resultSet.getString("part_of_speech"));
                    entry.setPronunciation(resultSet.getString("pronunciation"));
                    entry.setPocketDefinition(resultSet.getString("pocket_definition"));
                    entry.setCompleteDefinition(resultSet.getString("complete_definition"));
                    entry.setExampleUsage(resultSet.getString("example_usage"));
                    entry.setVariations(resultSet.getString("variations"));
                    entry.setEtymologyRoots(resultSet.getString("etymology_roots"));
                    entry.setSubmitter(resultSet.getString("submitter"));
                    entry.setSubmittedDate(resultSet.getDate("submitted_date"));
                    entry.setVoteCount(resultSet.getInt("vote_count"));

                    sortByer.addFoundEntry(entry);
                }
                logger.info("Lists: lists.sortListsByVoteCount: resultSet.next() completed successfully");
            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database" + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    logger.info("Lists: lists.sortListsByVoteCount: connection.close() completed successfully");
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }

    public void sortListsByAlphabetical(SortByer sortByer) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();
        logger.info("Lists: lists.sortListsByAlphabetical: Sorted By: " + sortByer.getSortType());
        try {
            statement = connection.createStatement();
            String IDQueryString ="select * from entries ORDER BY word";
            resultSet = statement.executeQuery(IDQueryString);
            logger.info("Lists: lists.sortListsByAlphabetical: statement.executeQuery(IDQueryString) completed successfully");
            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    Entry entry = new Entry();
                    entry.setWord(resultSet.getString("word"));
                    entry.setPartOfSpeech(resultSet.getString("part_of_speech"));
                    entry.setPronunciation(resultSet.getString("pronunciation"));
                    entry.setPocketDefinition(resultSet.getString("pocket_definition"));
                    entry.setCompleteDefinition(resultSet.getString("complete_definition"));
                    entry.setExampleUsage(resultSet.getString("example_usage"));
                    entry.setVariations(resultSet.getString("variations"));
                    entry.setEtymologyRoots(resultSet.getString("etymology_roots"));
                    entry.setSubmitter(resultSet.getString("submitter"));
                    entry.setSubmittedDate(resultSet.getDate("submitted_date"));
                    entry.setVoteCount(resultSet.getInt("vote_count"));

                    sortByer.addFoundEntry(entry);
                }
                logger.info("Lists: lists.sortListsByAlphabetical: resultSet.next() completed successfully");
            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database" + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    logger.info("Lists: lists.sortListsByAlphabetical: connection.close() completed successfully");
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }

    public void displayEntryTable(Entry entry, SortByer sortByer) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();
            logger.info("Lists: lists.displayEntryTable: for: " + entry.getWord());
        try {
            statement = connection.createStatement();
            String requestString = entry.getWord();
            String IDQueryString = "select * from entries where word = "+requestString+"";
            resultSet = statement.executeQuery(IDQueryString);
                logger.info("Lists: lists.displayEntryTable: statement.executeQuery(" + IDQueryString + ")");
            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    //Entry entry = new Entry();
                    entry.setWord(resultSet.getString("word"));
                    entry.setPartOfSpeech(resultSet.getString("part_of_speech"));
                    entry.setPronunciation(resultSet.getString("pronunciation"));
                    entry.setPocketDefinition(resultSet.getString("pocket_definition"));
                    entry.setCompleteDefinition(resultSet.getString("complete_definition"));
                    entry.setExampleUsage(resultSet.getString("example_usage"));
                    entry.setVariations(resultSet.getString("variations"));
                    entry.setEtymologyRoots(resultSet.getString("etymology_roots"));
                    entry.setSubmitter(resultSet.getString("submitter"));
                    entry.setSubmittedDate(resultSet.getDate("submitted_date"));
                    entry.setVoteCount(resultSet.getInt("vote_count"));

                    sortByer.addFoundEntry(entry);
                }
                logger.info("Lists: lists.displayEntryTable: resultSet.next() completed successfully");
            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database" + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    logger.info("Lists: lists.displayEntryTable: connection.close() completed successfully");
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }

    public void displayPersonaData(Entry entry, SortByer sortByer) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();
        logger.info("Lists: lists.displayPersonaData: for: " + entry.getSubmitter());
        try {
            statement = connection.createStatement();
            String requestString = entry.getSubmitter();
            String IDQueryString = "select * from entries where submitter = " + requestString + "";
            resultSet = statement.executeQuery(IDQueryString);
            logger.info("Lists: lists.displayPersonaData: statement.executeQuery(" + IDQueryString + ")");
            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    //Entry entry = new Entry();
                    entry.setWord(resultSet.getString("word"));
                    entry.setPartOfSpeech(resultSet.getString("part_of_speech"));
                    entry.setPronunciation(resultSet.getString("pronunciation"));
                    entry.setPocketDefinition(resultSet.getString("pocket_definition"));
                    entry.setCompleteDefinition(resultSet.getString("complete_definition"));
                    entry.setExampleUsage(resultSet.getString("example_usage"));
                    entry.setVariations(resultSet.getString("variations"));
                    entry.setEtymologyRoots(resultSet.getString("etymology_roots"));
                    entry.setSubmitter(resultSet.getString("submitter"));
                    entry.setSubmittedDate(resultSet.getDate("submitted_date"));
                    entry.setVoteCount(resultSet.getInt("vote_count"));

                    sortByer.addFoundEntry(entry);
                }
                logger.info("Lists: lists.displayPersonaData: resultSet.next() completed successfully");
            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connecting to database" + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    logger.info("Lists: lists.displayPersonaData: connection.close() completed successfully");
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connecting to database " + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }
}