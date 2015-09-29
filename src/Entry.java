/**
 * Project: Definery
 * Class: Entry
 * Created by Meesh
 * 9/21/15
 */
//package Definery.src;

import java.util.Date;

public class Entry {
    private String word;
    private String definition;
    private String partOfSpeech;
    private String pronunciation;
    private String submitter;
    private String usageAndVariations;
    private Date submitDate;
    private int voteCount;


    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSubmitter() {
        return submitter;
    }
    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Date getSubmitDate() {
        return submitDate;
    }
    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getPronunciation() {
        return pronunciation;
    }
    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getUsageAndVariations() {
        return usageAndVariations;
    }
    public void setUsageAndVariations(String usageAndVariations) {
        this.usageAndVariations = usageAndVariations;
    }

    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String createTestEntryOutput(){
        return  "Word: " + getWord() +
                "\nDefinition: " + getDefinition() +
                "\nPart of Speech: " + getPartOfSpeech() +
                "\nVote Count: " + getVoteCount() +
                "\n";
    }
}
