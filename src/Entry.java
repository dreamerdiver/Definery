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
    private String Submitter;
    private Date submitDate;
    private String pronunciation;
    private String partOfSpeech;
    private int voteCount;
    //Usage Examples
    //Variations


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
        return Submitter;
    }
    public void setSubmitter(String submitter) {
        Submitter = submitter;
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

    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String createTestOutput(){
        return  "Word: " + getWord() +
                "\nDefinition: " + getDefinition() +
                "\nPart of Speech: " + getPartOfSpeech() +
                "\nVote Count: " + getVoteCount() +
                "\n";
    }
}
