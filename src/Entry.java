/**
 * Project: Definery
 * Class: Entry
 * Created by Meesh
 * 9/21/15
 */
//package Definery.src;

import java.io.*;
import java.util.Date;

public class Entry {
    private String word;
    private String pocketDefinition;
    private String completeDefinition;
    private String partOfSpeech;
    private String pronunciation;
    private String submitter;
    private String usage;
    private String variations;
    private String etymology;
    private Date submitDate;
    private int voteCount;

    public Entry(){

    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
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

    public String getPocketDefinition() {
        return pocketDefinition;
    }
    public void setPocketDefinition(String definition) {
        this.pocketDefinition = pocketDefinition;
    }

    public String getCompleteDefinition() {
        return completeDefinition;
    }
    public void setCompleteDefinition(String completeDefinition) {
        this.completeDefinition = completeDefinition;
    }

    public String getUsage() {
        return usage;
    }
    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getVariations() {
        return variations;
    }
    public void setVariations(String variations) {
        this.variations = variations;
    }

    public String getEtymology() {
        return etymology;
    }
    public void setEtymology(String etymology) {
        this.etymology = etymology;
    }

    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
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


    public String createTestEntryOutput(){
        return "Word: " + getWord() +
                "\nPart of Speech: " + getPartOfSpeech() +
                "\nPronunciation: " + getPronunciation() +
                "\nPocket Definition: " + getPocketDefinition() +
                "\nComplete Definition: " + getCompleteDefinition() +
                "\nUsage: " + getUsage() +
                "\nVariations: " + getVariations() +
                "\nEtymology: " + getEtymology() +
                "\nSubmitter: " + getSubmitter() +
                "\nSubmit Date: " + getSubmitDate() +
                "\nVote Count: " + getVoteCount() +
                "\n";
    }
}
