package src.login;

import src.lists.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 11/11/15
 */
public class UserData {
    private int userID;
    private int accountAge;
    private String username;
    private List<String> votedEntries;
    private ArrayList<Entry> submittedEntries;

    public UserData() {
    }

    public UserData(int userID, int accountAge, String username, List votedEntries, ArrayList submittedEntries) {
        this.userID = userID;
        this.accountAge = accountAge;
        this.username = username;
        this.votedEntries = votedEntries;
        this.submittedEntries = submittedEntries;
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
    public void setAccountAge(int accountAge) {
        this.accountAge = accountAge;
    }

    public List<String> getVotedEntries() {
        return votedEntries;
    }
    public void setVotedEntries(List<String> votedEntries) {
        this.votedEntries = votedEntries;
    }

    public ArrayList<Entry> getSubmittedEntries() {
        return submittedEntries;
    }
    public void setSubmittedEntries(ArrayList<Entry> submittedEntries) {
        this.submittedEntries = submittedEntries;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String createTestUserDataOutput(){
        Entry entry;
        String userSubmissionList = "";
        for (Object entry0 : getSubmittedEntries()) {
            entry = (Entry) entry0;
            userSubmissionList += entry;
        }
        return  "UserID: " + getUserID() +
                "\nUsername: " + getUsername() +
                "\nAccount Age: " + getAccountAge() +
                "\nVoted Entries: " + getVotedEntries() +
                "\nSubmitted Entries: " + userSubmissionList + "\n";
    }
}
