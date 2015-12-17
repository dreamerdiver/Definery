package src.lists;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 12/14/15
 */

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class SortByerTest extends TestCase {

    @Test
    public void testGetSortType() throws Exception {
        SortByer sortByer = new SortByer();
        sortByer.setSortType("test");

        assertNotNull("sortByer.getSortType is null", sortByer.getSortType());
    }

    @Test
    public void testSetSortType() throws Exception {
        SortByer sortByer = new SortByer();
        sortByer.setSortType("test");

        assertNotNull("sortByer.setSortType is null", sortByer.getSortType());
    }

    @Test
    public void testGetSortedResults() throws Exception {
        SortByer sortByer = new SortByer();
        ArrayList<Entry> arrayListTest = new ArrayList<>();
        sortByer.setSortedResults(arrayListTest);

        assertNotNull("sortByer.getSortedResults is null", sortByer.getSortedResults());
    }

    @Test
    public void testSetSortedResults() throws Exception {
        SortByer sortByer = new SortByer();
        ArrayList<Entry> arrayListTest = new ArrayList<>();
        sortByer.setSortedResults(arrayListTest);

        assertNotNull("sortByer.setSortedResults is null", sortByer.getSortedResults());
    }

    @Test
    public void testGetThisEntry() throws Exception {
        SortByer sortByer = new SortByer();
        boolean foundEmployee = true;
        sortByer.setThisEntry(foundEmployee);

        assertTrue("sortByer.getThisEntry is null", sortByer.getThisEntry());
    }

    @Test
    public void testSetThisEntry() throws Exception {
        SortByer sortByer = new SortByer();
        boolean foundEmployee = true;
        sortByer.setThisEntry(foundEmployee);

        assertTrue("sortByer.setThisEntry is null", sortByer.getThisEntry());
    }

    @Test
    public void testAddFoundEntry() throws Exception {
        Entry entry = new Entry();
        SortByer sortByer = new SortByer();
        sortByer.addFoundEntry(entry);

        assertNotNull("sortByer.addFoundEntry is null", sortByer.getSortedResults());
    }

    @Test
    public void testReturnSortReport() throws Exception {
        SortByer sortByer = new SortByer();
        sortByer.setSortType("test");

        assertNotNull("sortByer.returnSortReport is null", sortByer.returnSortReport());
    }
}