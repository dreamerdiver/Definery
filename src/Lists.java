import java.io.*;
import java.util.*;
import java.sql.*;

/**
 * Project:
 * Class:
 * Created by Meesh
 * 10/4/15
 */
public class Lists {

    private Properties properties;
    private Entry entry = new Entry();
    private List<Entry> entries = new ArrayList<>();

    public Lists() {
    }

    public void addEntryToLists(Entry entry){
        this.entry = entry;
        entries.add(entry);
    }



    /*
        public Lists(Properties properties) {
            this.properties = properties;
        }

        private Connection makeConnection() {
            Connection connection = null;

            try {
                Class.forName(properties.getProperty("driver"));
                connection = DriverManager.getConnection(properties.getProperty("url"),
                        properties.getProperty("mysql.username"),
                        properties.getProperty("mysql.password"));

            } catch (ClassNotFoundException classNotFound) {
                System.err.println("Cannot find database driver ");
                classNotFound.printStackTrace();
                return null;
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database " + sqlException);
                sqlException.printStackTrace();
                return null;
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
                return null;
            }
            return connection;
        }

        public void addEmployee(String firstName,String lastName,String SSN,String department,String roomNumber,String phoneNumber) {
            Statement statement = null;
            ResultSet resultSet = null;
            Connection connection = makeConnection();

            try {
                statement = connection.createStatement();

                String addQueryString = "insert into employees values ('1001', '" + firstName +  "', '"
                        + lastName +  "', '"
                        + SSN +  "', '"
                        + department +  "', '"
                        + roomNumber +  "', '"
                        + phoneNumber + "');";
                System.out.println("addQueryString: " + addQueryString);
                statement.executeUpdate(addQueryString);

                String rtrvQueryString = "select * from employees where emp_id = (select max(emp_id) from employees);";
                System.out.println("rtrvQueryString: " + rtrvQueryString);
                resultSet = statement.executeQuery(rtrvQueryString);

                while (resultSet.next()) {
                    firstName = resultSet.getString("first_name");
                    lastName = resultSet.getString("last_name");
                    SSN = resultSet.getString("ssn");
                    department = resultSet.getString("dept");
                    roomNumber = resultSet.getString("room");
                    phoneNumber = resultSet.getString("phone");

                    System.out.println("Instance: " + firstName + " "
                            + lastName + " "
                            + SSN + " "
                            + department + " "
                            + roomNumber + " "
                            + phoneNumber);
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

        public void searchEmployeeID(Search search) {
            Statement statement = null;
            ResultSet resultSet = null;
            Connection connection = makeConnection();
            System.out.println("Searched: " + search.getSearchTerm());

            try {
                statement = connection.createStatement();

                String IDQueryString ="select * from employees where emp_id = " + search.getSearchTerm() + ";";
                System.out.println("IDQueryString: " + IDQueryString);
                resultSet = statement.executeQuery(IDQueryString);

                if (!resultSet.next()) {
                    search.setFoundEmployee(false);
                } else {
                    search.setFoundEmployee(true);
                    resultSet.previous();
                    while (resultSet.next()) {
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String SSN = resultSet.getString("ssn");
                        String department = resultSet.getString("dept");
                        String roomNumber = resultSet.getString("room");
                        String phoneNumber = resultSet.getString("phone");

                        Employee employee = new Employee();
                        employee.setFirstName(firstName);
                        employee.setLastName(lastName);
                        employee.setSSN(SSN);
                        employee.setDepartment(department);
                        employee.setRoomNumber(roomNumber);
                        employee.setPhoneNumber(phoneNumber);

                        search.addFoundEmployee(employee);
                    }
                }
                employees = search.getResultsArray();
                for (Employee employee : employees) {
                    System.out.println(employee.toString());
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

        public void searchEmployeeName(Search search) {
            Statement statement = null;
            ResultSet resultSet = null;
            Connection connection = makeConnection();
            System.out.println("Searched: " + search.getSearchTerm());

            try {
                statement = connection.createStatement();

                String LNQueryString ="select * from employees where last_name = '" + search.getSearchTerm() + "';";
                System.out.println("LNQueryString: " + LNQueryString);
                resultSet = statement.executeQuery(LNQueryString);

                if (!resultSet.next()) {
                    search.setFoundEmployee(false);
                } else {
                    search.setFoundEmployee(true);
                    resultSet.previous();
                    while (resultSet.next()) {
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String SSN = resultSet.getString("ssn");
                        String department = resultSet.getString("dept");
                        String roomNumber = resultSet.getString("room");
                        String phoneNumber = resultSet.getString("phone");

                        Employee employee = new Employee();
                        employee.setFirstName(firstName);
                        employee.setLastName(lastName);
                        employee.setSSN(SSN);
                        employee.setDepartment(department);
                        employee.setRoomNumber(roomNumber);
                        employee.setPhoneNumber(phoneNumber);

                        search.addFoundEmployee(employee);
                    }
                }
                employees = search.getResultsArray();
                for (Employee employee : employees) {
                    System.out.println(employee.toString());
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
    */
}
