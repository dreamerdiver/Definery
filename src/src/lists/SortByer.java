package src.lists;

import java.util.*;

/**
 * Project: Definery
 * Class: SortByer Bean
 * Created by Meesh
 * 10/11/15
 */

public class SortByer {
    private String sortType = "";
    private List<Entry> sortedResults;
    private boolean foundEmployee;

    public SortByer() {
        sortedResults = new ArrayList<>();
    }

    public String getSortType() {
        return sortType;
    }
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }


    public List<Entry> getSortedResults() {
        return sortedResults;
    }
    public void setSortedResults(List<Entry> sortedResults) {
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


