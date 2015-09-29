/**
 * Project: Definery
 * Class: Definery
 * Created by Meesh
 * 9/28/15
 */

import java.util.ArrayList;

public class Definery {
    public ArrayList<Entry> entries;

    public void run() {
        populateDefineryDatabase();
        outputReport();
    }

    public void populateDefineryDatabase() {
        entries = new ArrayList<>();

        Entry entry = new Entry();
            entry.setWord("assetious");
            entry.setDefinition("valuable");
            entry.setPartOfSpeech("adjective");
            entry.setVoteCount(0);
        Entry entry1 = new Entry();
            entry1.setWord("lumiphilic");
            entry1.setDefinition("having an attraction to light");
            entry1.setPartOfSpeech("adjective");
        Entry entry2 = new Entry();
            entry2.setWord("begrin");
            entry2.setDefinition("to make someone smile");
            entry2.setPartOfSpeech("verb");

            entries.add(entry);
            entries.add(entry1);
            entries.add(entry2);
    }

    public void outputReport() {
        Entry entry;

        for (Object entry1 : entries) {
            entry = (Entry) entry1;
            System.out.println(entry.createTestOutput());
        }
    }
}
