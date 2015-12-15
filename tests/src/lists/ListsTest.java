package src.lists;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertNotNull;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 10/24/15
 */
public class ListsTest {
    Properties properties;

    @Test
    public void testMakeConnection() throws Exception {
        Lists lists = new Lists();

        assertNotNull("lists.makeConnection() is null", lists.makeConnection());
    }

    @Test
    public void testAddEntry() throws Exception {
        Lists lists = new Lists();
        Entry entry = new Entry();
            entry.setWord("test");

        lists.addEntry(entry);
        assertNotNull("lists.addEntry() is null", lists);
    }

    @Test
    public void testSortListsByNewest() throws Exception {
        SortByer sortByer = new SortByer();
        sortByer.setSortType("newest");
    }

    @Test
    public void testSortListsByOldest() throws Exception {

    }

    @Test
    public void testSortListsByVoteCount() throws Exception {

    }

    @Test
    public void testSortListsByAlphabetical() throws Exception {

    }
}