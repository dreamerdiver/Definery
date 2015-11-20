package src.login;

import org.apache.log4j.Logger;

import java.time.LocalDate;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/11/15
 */
public class UserData {
    private final Logger logger = Logger.getLogger(this.getClass());
    private int userID;
    private int accountAge;
    private LocalDate accountStartDate;
    //private List<String> votedEntries;
    //private ArrayList<Entry> submittedEntries;

    public UserData() {
        logger.info("UserData: Created 'UserData' instance");
    }

    public UserData(int userID) {
        this.userID = userID;
        setAccountAge();
        //this.votedEntries = votedEntries;
        //this.submittedEntries = submittedEntries;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAccountAge() {
        return accountAge;
    }
    public void setAccountAge() {
        /*
        if (accountStartDate == null) {
            accountStartDate =  new LocalDate.now();
        }
        LocalDate presentDate = new LocalDate();
        Years accountAgeInYears = Years.yearsBetween(accountStartDate, presentDate);
           */

        this.accountAge = 11122015;
    }
/*
    public List<String> getVotedEntries() {
        return votedEntries;
    }
    public void setVotedEntries(List<String> votedEntries) {
        this.votedEntries = votedEntries;
    }
*/
/*
    public ArrayList<Entry> getSubmittedEntries() {
        return submittedEntries;
    }
    public void setSubmittedEntries(ArrayList<Entry> submittedEntries) {
        this.submittedEntries = submittedEntries;
    }
*/
    public String createUserDataReport(){
        //Entry entry;
        String userSubmissionList = "";
        /*
        for (Object entry0 : getSubmittedEntries()) {
            entry = (Entry) entry0;
            userSubmissionList += entry;
        }
        */
        return  "UserID: " + getUserID() +
                "\nAccount Age: " + getAccountAge() +
               // "\nVoted Entries: " + getVotedEntries() +
                "\nSubmitted Entries: " + userSubmissionList + "\n";
    }
}
