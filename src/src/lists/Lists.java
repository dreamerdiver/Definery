package src.lists;

import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * Project: Definery
 * Class: Lists Object
 * Created by Meesh
 * 10/4/15
 */
public class Lists {
    private Properties properties;
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
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/definery", "meesh", "DreamandDive406");

            /*
            Class.forName(properties.getProperty("mysql.driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("mysql.username"),
                    properties.getProperty("mysql.password"));
            */

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

            String addConfirmation = "select * from entries where word="+entry.getWord()+"";
            resultSet = statement.executeQuery(addConfirmation);
            System.out.println("Added new Entry: " + addConfirmation);

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
            String IDQueryString ="select * from entries ORDER BY submitted_date DESC";
            resultSet = statement.executeQuery(IDQueryString);
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
            String IDQueryString ="select * from entries ORDER BY submitted_date ASC";
            resultSet = statement.executeQuery(IDQueryString);
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
            String IDQueryString ="select * from entries ORDER BY vote_count DESC";
            resultSet = statement.executeQuery(IDQueryString);
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
            resultSet = statement.executeQuery(IDQueryString);

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