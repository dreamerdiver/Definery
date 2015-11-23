package src.lists;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;

/**
 * Project: Definery
 * Class: SortByer
 * Created by Meesh
 * 10/11/15
 */

public class SortByer {
    private String sortType = "";
    private ArrayList<Entry> sortedResults;
    private boolean foundEmployee;
    private final Logger logger = Logger.getLogger(this.getClass());

    public SortByer() {
        sortedResults = new ArrayList<>();
        logger.info("SortByer: Created 'SortByer' instance");
    }

    public String getSortType() {
        return sortType;
    }
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public ArrayList<Entry> getSortedResults() {
        return sortedResults;
    }
    public void setSortedResults(ArrayList<Entry> sortedResults) {
        this.sortedResults = sortedResults;
    }

    public boolean getThisEntry() {
        return foundEmployee;
    }
    public void setThisEntry(boolean foundEmployee) {
        this.foundEmployee = foundEmployee;
    }
    public void addFoundEntry(Entry entry) {
        sortedResults.add(entry);
    }

    public String returnSortReport() {
        return "Sort Type: " + getSortType() +
                "<br />Results Returned: " + getSortedResults().size() +
                "<br />" + new Date();
    }
}


