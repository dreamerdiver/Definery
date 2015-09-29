/**
 * Project: Definery
 * Class: Definery
 * Created by Meesh
 * 9/28/15
 */

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Date;

public class Definery {
    private ArrayList<Entry> entries;
    public ArrayList<User> users;

    public void run() {
        populateDefineryDatabase();
        populateUserDatabase();
        outputEntryReport();
        outputUserReport();
    }

    public void populateDefineryDatabase() {
        entries = new ArrayList<>();

        Entry entry = new Entry();
            entry.setWord("assetious");
            entry.setDefinition("valuable");
            entry.setPartOfSpeech("adjective");
            entry.setVoteCount(0);
            entry.setSubmitter("dreamerdiver");
        Entry entry1 = new Entry();
            entry1.setWord("lumiphilic");
            entry1.setDefinition("having an attraction to light");
            entry1.setPartOfSpeech("adjective");
            entry1.setSubmitter("dreamerdiver");
        Entry entry2 = new Entry();
            entry2.setWord("begrin");
            entry2.setDefinition("to make someone smile");
            entry2.setPartOfSpeech("verb");
            entry2.setSubmitter("dreamerdiver");

            entries.add(entry);
            entries.add(entry1);
            entries.add(entry2);
    }

    public void populateUserDatabase() {
        users = new ArrayList<>();
        ArrayList<Entry> userEntries = new ArrayList<>();
        Entry entry;

        User user = new User();
            user.setUsername("dreamerdiver");
            user.setPassword("password");
            //user.setAccountDate();
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

    public void outputUserReport() {
        User user;

        for (Object user1 : users) {
            user = (User) user1;
            System.out.println(user.createTestUserOutput());
        }
    }
}
