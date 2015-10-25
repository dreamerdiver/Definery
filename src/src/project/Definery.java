package src.project;

/**
 * Project: Definery
 * Class: Definery
 * Created by Meesh
 * 9/28/15
 */


import src.lists.Entry;
import java.util.*;

public class Definery {
    private ArrayList<Entry> entries;
    public ArrayList<src.project.User> users;
    public ArrayList<Entry> userEntries;

    String word;
    String definition;
    String submitter;

    public void run() {
        populateDefineryDatabase("word", "def", "user");
        populateUserDatabase();
        outputEntryReport();
        outputUserReport();
    }

    public void populateDefineryDatabase(String word, String definition,
                                         String submitter) {
        entries = new ArrayList<>();
        this.word = word;
        this.definition = definition;
        this.submitter = submitter;

        Entry entry = new Entry();
            entry.setWord("assetious");
            entry.setPocketDefinition("valuable");
            entry.setPartOfSpeech("adjective");
            entry.setVoteCount(0);
            //entry.setSubmitter("dreamerdiver");
        Entry entry1 = new Entry();
            entry1.setWord("lumiphilic");
            entry1.setPocketDefinition("having an attraction to light");
            entry1.setPartOfSpeech("adjective");
            entry1.setSubmitter("dreamerdiver");
        Entry entry2 = new Entry();
            entry2.setWord("begrin");
            entry2.setPocketDefinition("to make someone smile");
            entry2.setPartOfSpeech("verb");
            entry2.setSubmitter("dreamerdiver");
        Entry entry3 = new Entry();
            entry3.setWord(word);
            entry3.setPocketDefinition(definition);
            entry3.setSubmitter(submitter);

            entries.add(entry);
            entries.add(entry1);
            entries.add(entry2);
            entries.add(entry3);
    }

    public void populateUserDatabase() {
        users = new ArrayList<>();
        userEntries = new ArrayList<>();
        Entry entry;

        User user = new User();
            user.setUsername("dreamerdiver");
            user.setPassword("password");
            user.setAccountDate(new Date());
                for (Object entry0 : entries) {
                    entry = (Entry) entry0;
                    if (Objects.equals(entry.getSubmitter(), user.getUsername())){
                        userEntries.add(entry);
                    }
                }
            user.setSubmittedEntries(userEntries);
            users.add(user);
    }

    public void outputEntryReport() {
        Entry entry;

        for (Object entry1 : entries) {
            entry = (Entry) entry1;
            System.out.println(entry.createTestEntryOutput());
        }
    }

    public ArrayList outputUserReport() {
        User user;

        for (Object user1 : users) {
            user = (User) user1;
            System.out.println(user.createTestUserOutput());
        }
        System.out.println(userEntries);
        return users;
    }
}
