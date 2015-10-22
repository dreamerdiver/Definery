package src.lists;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Project: Definery
 * Class: Lists Object
 * Created by Meesh
 * 10/4/15
 */

public class Lists {
    private Properties properties;
    private List<Entry> entries = new ArrayList<>();

    public Lists() {
    }
    public Lists(Properties properties) {
        this.properties = properties;
    }

    /**
     * @return Connection to mysql Database
     */
    protected Connection makeConnection() {
        Connection connection;

        try {
            Class.forName(properties.getProperty("mysql.driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"),
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

    public void addEntry() {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = makeConnection();

        try {
            statement = connection.createStatement();
            System.out.println(statement);

            String addQueryString = "insert into entries values (word, pos, pronunciation, pocketDefinition, completeDefinition, example_usage, variations, etymology, submitter, submittedDate, 0)";
            System.out.println("addQueryString: " + addQueryString);
            statement.executeUpdate(addQueryString);

            String rtrvQueryString = "select * from entries";
            System.out.println("rtrvQueryString: " + rtrvQueryString);
            resultSet = statement.executeQuery(rtrvQueryString);

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
                        + "<br /> " + pos
                        + "<br /> " + pronunciation
                        + "<br /> " + pocketDefinition
                        + "<br /> " + completeDefinition
                        + "<br /> " + example_usage
                        + "<br /> " + variations
                        + "<br /> " + etymology
                        + "<br /> " + submitter
                        + "<br /> " + submittedDate
                        + "<br /> " + voteCount);
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
        System.out.println("Sorted By: " + sortByer.getSortType());

        try {
            statement = connection.createStatement();

            String IDQueryString ="select * from entries GROUP BY submittedDate DESC";
                System.out.println("IDQueryString: " + IDQueryString);
            resultSet = statement.executeQuery(IDQueryString);
                System.out.println(resultSet);

            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    String word = resultSet.getString("word");
                    String pos = resultSet.getString("part_of_speech");
                    String pronunciation = resultSet.getString("pronunciation");
                    String pocketDefinition = resultSet.getString("pocket_definition");
                    String completeDefinition = resultSet.getString("complete_definition");
                    String exampleUsage = resultSet.getString("example_usage");
                    String variations = resultSet.getString("variations");
                    String etymologyRoots = resultSet.getString("etymology_roots");
                    String submitter = resultSet.getString("submitter");
                    Date submittedDate = resultSet.getDate("submitted_date");
                    int voteCount = resultSet.getInt("vote_count");

                    Entry entry = new Entry();
                    entry.setWord(word);
                    entry.setPartOfSpeech(pos);
                    entry.setPronunciation(pronunciation);
                    entry.setPocketDefinition(pocketDefinition);
                    entry.setCompleteDefinition(completeDefinition);
                    entry.setExampleUsage(exampleUsage);
                    entry.setVariations(variations);
                    entry.setEtymologyRoots(etymologyRoots);
                    entry.setSubmitter(submitter);
                    entry.setSubmittedDate(submittedDate);
                    entry.setVoteCount(voteCount);

                    sortByer.addFoundEntry(entry);
                }
            }
            entries = sortByer.getSortedResults();
                for (Entry entry : entries) {
                    System.out.println(entry.toString());
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
        System.out.println("Sorted By: " + sortByer.getSortType());

        try {
            statement = connection.createStatement();

            String IDQueryString ="select * from entries GROUP BY submitted_date ASC";
            System.out.println("IDQueryString: " + IDQueryString);
            resultSet = statement.executeQuery(IDQueryString);
            System.out.println(resultSet);

            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    String word = resultSet.getString("word");
                    String pos = resultSet.getString("part_of_speech");
                    String pronunciation = resultSet.getString("pronunciation");
                    String pocketDefinition = resultSet.getString("pocket_definition");
                    String completeDefinition = resultSet.getString("complete_definition");
                    String exampleUsage = resultSet.getString("example_usage");
                    String variations = resultSet.getString("variations");
                    String etymologyRoots = resultSet.getString("etymology_roots");
                    String submitter = resultSet.getString("submitter");
                    Date submittedDate = resultSet.getDate("submitted_date");
                    int voteCount = resultSet.getInt("vote_count");

                    Entry entry = new Entry();
                    entry.setWord(word);
                    entry.setPartOfSpeech(pos);
                    entry.setPronunciation(pronunciation);
                    entry.setPocketDefinition(pocketDefinition);
                    entry.setCompleteDefinition(completeDefinition);
                    entry.setExampleUsage(exampleUsage);
                    entry.setVariations(variations);
                    entry.setEtymologyRoots(etymologyRoots);
                    entry.setSubmitter(submitter);
                    entry.setSubmittedDate(submittedDate);
                    entry.setVoteCount(voteCount);

                    sortByer.addFoundEntry(entry);
                }
            }
            entries = sortByer.getSortedResults();
            for (Entry entry : entries) {
                System.out.println(entry.toString());
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
        System.out.println("Sorted By: " + sortByer.getSortType());

        try {
            statement = connection.createStatement();

            String IDQueryString ="select * from entries GROUP BY vote_count DESC";
            System.out.println("IDQueryString: " + IDQueryString);
            resultSet = statement.executeQuery(IDQueryString);
            System.out.println(resultSet);

            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    String word = resultSet.getString("word");
                    String pos = resultSet.getString("part_of_speech");
                    String pronunciation = resultSet.getString("pronunciation");
                    String pocketDefinition = resultSet.getString("pocket_definition");
                    String completeDefinition = resultSet.getString("complete_definition");
                    String exampleUsage = resultSet.getString("example_usage");
                    String variations = resultSet.getString("variations");
                    String etymologyRoots = resultSet.getString("etymology_roots");
                    String submitter = resultSet.getString("submitter");
                    Date submittedDate = resultSet.getDate("submitted_date");
                    int voteCount = resultSet.getInt("vote_count");

                    Entry entry = new Entry();
                    entry.setWord(word);
                    entry.setPartOfSpeech(pos);
                    entry.setPronunciation(pronunciation);
                    entry.setPocketDefinition(pocketDefinition);
                    entry.setCompleteDefinition(completeDefinition);
                    entry.setExampleUsage(exampleUsage);
                    entry.setVariations(variations);
                    entry.setEtymologyRoots(etymologyRoots);
                    entry.setSubmitter(submitter);
                    entry.setSubmittedDate(submittedDate);
                    entry.setVoteCount(voteCount);

                    sortByer.addFoundEntry(entry);
                }
            }
            entries = sortByer.getSortedResults();
            for (Entry entry : entries) {
                System.out.println(entry.toString());
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
        System.out.println("Sorted By: " + sortByer.getSortType());

        try {
            statement = connection.createStatement();

            String IDQueryString ="select * from entries ORDER BY word";
            System.out.println("IDQueryString: " + IDQueryString);
            resultSet = statement.executeQuery(IDQueryString);
            System.out.println(resultSet);

            if (!resultSet.next()) {
                sortByer.setThisEntry(false);
            } else {
                sortByer.setThisEntry(true);
                resultSet.previous();
                while (resultSet.next()) {
                    String word = resultSet.getString("word");
                    String pos = resultSet.getString("part_of_speech");
                    String pronunciation = resultSet.getString("pronunciation");
                    String pocketDefinition = resultSet.getString("pocket_definition");
                    String completeDefinition = resultSet.getString("complete_definition");
                    String exampleUsage = resultSet.getString("example_usage");
                    String variations = resultSet.getString("variations");
                    String etymologyRoots = resultSet.getString("etymology_roots");
                    String submitter = resultSet.getString("submitter");
                    Date submittedDate = resultSet.getDate("submitted_date");
                    int voteCount = resultSet.getInt("vote_count");

                    Entry entry = new Entry();
                    entry.setWord(word);
                    entry.setPartOfSpeech(pos);
                    entry.setPronunciation(pronunciation);
                    entry.setPocketDefinition(pocketDefinition);
                    entry.setCompleteDefinition(completeDefinition);
                    entry.setExampleUsage(exampleUsage);
                    entry.setVariations(variations);
                    entry.setEtymologyRoots(etymologyRoots);
                    entry.setSubmitter(submitter);
                    entry.setSubmittedDate(submittedDate);
                    entry.setVoteCount(voteCount);

                    sortByer.addFoundEntry(entry);
                }
            }
            entries = sortByer.getSortedResults();
            for (Entry entry : entries) {
                System.out.println(entry.toString());
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
