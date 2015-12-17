package src.lists;

/**
 * Project: Definery
 * Class:
 * Created by Meesh
 * 12/14/15
 */

import junit.framework.TestCase;
import org.junit.Test;

public class EntryTest extends TestCase {
    @Test
    public void testGetWord() throws Exception {
        Entry entry = new Entry();
            entry.setWord("test");

        assertNotNull("entry.getWord is null", entry.getWord());
    }

    @Test
    public void testSetWord() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");

        assertNotNull("entry.setWord is null", entry.getWord());
    }

    @Test
    public void testGetPartOfSpeech() throws Exception {
        Entry entry = new Entry();
            entry.setWord("test");
            entry.setPartOfSpeech("noun");

        assertNotNull("entry.getPartOfSpeech is null", entry.getPartOfSpeech());
    }

    @Test
    public void testSetPartOfSpeech() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setPartOfSpeech("noun");

        assertNotNull("entry.setPartOfSpeech is null", entry.getPartOfSpeech());
    }

    @Test
    public void testGetPronunciation() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setPronunciation("test");

        assertNotNull("entry.getPronunciation is null", entry.getPronunciation());
    }

    @Test
    public void testSetPronunciation() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setPronunciation("test");

        assertNotNull("entry.setPronunciation is null", entry.getPronunciation());
    }

    @Test
    public void testGetPocketDefinition() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setPocketDefinition("test");

        assertNotNull("entry.getPocketDefinition is null", entry.getPocketDefinition());
    }

    @Test
    public void testSetPocketDefinition() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setPocketDefinition("test");

        assertNotNull("entry.setPocketDefinition is null", entry.getPocketDefinition());
    }

    @Test
    public void testGetCompleteDefinition() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setCompleteDefinition("test");

        assertNotNull("entry.getCompleteDefinition is null", entry.getCompleteDefinition());
    }

    @Test
    public void testSetCompleteDefinition() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setCompleteDefinition("test");

        assertNotNull("entry.setCompleteDefinition is null", entry.getCompleteDefinition());
    }

    @Test
    public void testGetExampleUsage() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setExampleUsage("test");

        assertNotNull("entry.getExampleUsage is null", entry.getExampleUsage());
    }

    @Test
    public void testSetExampleUsage() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setExampleUsage("test");

        assertNotNull("entry.setExampleUsage is null", entry.getExampleUsage());
    }

    @Test
    public void testGetVariations() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setVariations("test");

        assertNotNull("entry.getVariations is null", entry.getVariations());
    }

    @Test
    public void testSetVariations() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setVariations("test");

        assertNotNull("entry.setVariations is null", entry.getVariations());
    }

    @Test
    public void testGetEtymologyRoots() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setEtymologyRoots("test");

        assertNotNull("entry.getEtymologyRoots is null", entry.getEtymologyRoots());
    }

    @Test
    public void testSetEtymologyRoots() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setEtymologyRoots("test");

        assertNotNull("entry.setEtymologyRoots is null", entry.getEtymologyRoots());
    }

    @Test
    public void testGetSubmitter() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setSubmitter("test");

        assertNotNull("entry.getSubmitter is null", entry.getSubmitter());
    }

    @Test
    public void testSetSubmitter() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setSubmitter("test");

        assertNotNull("entry.setSubmitter is null", entry.getSubmitter());
    }

    @Test
    public void testGetSubmittedDate() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setSubmittedDate("test");

        assertNotNull("entry.getSubmittedDate is null", entry.getSubmittedDate());
    }

    @Test
    public void testSetSubmittedDate() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setSubmittedDate("test");

        assertNotNull("entry.setSubmittedDate is null", entry.getSubmittedDate());
    }

    @Test
    public void testGetVoteCount() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setVoteCount(1);

        assertNotNull("entry.getVoteCount is null", entry.getVoteCount());
    }

    @Test
    public void testSetVoteCount() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");
        entry.setVoteCount(1);

        assertNotNull("entry.setVoteCount is null", entry.getVoteCount());
    }

    @Test
    public void testCreateTestEntryOutput() throws Exception {
        Entry entry = new Entry();
        entry.setWord("test");

        assertNotNull("entry.createTestEntryOutput is null", entry.createTestEntryOutput());
    }
}