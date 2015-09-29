/**
 * Project: Definery
 * Class: User
 * Created by Meesh
 * 9/29/15
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private Date accountDate;
    private ArrayList<Entry> submittedEntries;
    private List<String> votedEntries;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAccountDate() {
        return accountDate;
    }
    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public ArrayList<Entry> getSubmittedEntries() {
        return submittedEntries;
    }
    public void setSubmittedEntries(ArrayList<Entry> submittedEntries) {
        this.submittedEntries = submittedEntries;
    }

    public List<String> getVotedEntries() {
        return votedEntries;
    }
    public void setVotedEntries(List<String> votedEntries) {
        this.votedEntries = votedEntries;
    }

    public String createTestUserOutput(){
        Entry entry;
        String userSubmissionList = "";

        for (Object entry0 : submittedEntries) {
            entry = (Entry) entry0;
            userSubmissionList += entry;
        }

        return  "Username: " + getUsername() +
                "\nPassword: " + getPassword() +
                "\nAccount Date: " + getAccountDate() +
                "\nSubmitted Entries: " + userSubmissionList +
                "\nVoted Entries: " + getVotedEntries() +
                "\n";
    }
}
