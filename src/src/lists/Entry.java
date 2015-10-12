package src.lists;

/**
 * Project: Definery
 * Class: Entry
 * Created by Meesh
 * 9/21/15
 */

import java.util.*;

public class Entry {
    private String word;
    private String partOfSpeech;
    private String pronunciation;
    private String pocketDefinition;
    private String completeDefinition;
    private String exampleUsage;
    private String variations;
    private String etymologyRoots;
    private String submitter;
    private Date submittedDate;
    private int voteCount;

    public Entry() {
    }

    public Entry(Properties properties) {
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getPronunciation() {
        return pronunciation;
    }
    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getPocketDefinition() {
        return pocketDefinition;
    }
    public void setPocketDefinition(String pocketDefinition) {
        this.pocketDefinition = pocketDefinition;
    }

    public String getCompleteDefinition() {
        return completeDefinition;
    }
    public void setCompleteDefinition(String completeDefinition) {
        this.completeDefinition = completeDefinition;
    }

    public String getExampleUsage() {
        return exampleUsage;
    }
    public void setExampleUsage(String exampleUsage) {
        this.exampleUsage = exampleUsage;
    }

    public String getVariations() {
        return variations;
    }
    public void setVariations(String variations) {
        this.variations = variations;
    }

    public String getEtymologyRoots() {
        return etymologyRoots;
    }
    public void setEtymologyRoots(String etymologyRoots) {
        this.etymologyRoots = etymologyRoots;
    }

    public String getSubmitter() {
        return submitter;
    }
    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String createTestEntryOutput(){
        return "Word: " + getWord() +
                "<br />Part of Speech: " + getPartOfSpeech() +
                "<br />Pronunciation: " + getPronunciation() +
                "<br />Pocket Definition: " + getPocketDefinition() +
                "<br />Complete Definition: " + getCompleteDefinition() +
                "<br />Usage: " + getExampleUsage() +
                "<br />Variations: " + getVariations() +
                "<br />Etymology: " + getEtymologyRoots() +
                "<br />Submitter: " + getSubmitter() +
                "<br />Submit Date: " + getSubmittedDate() +
                "<br />Vote Count: " + getVoteCount() +
                "<br />";
    }
}
