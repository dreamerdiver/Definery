package src.project;

/**
 * Project: Definery
 * Class: DefineryTests
 * Created by Meesh
 * 10/3/15
 */

import junit.framework.TestCase;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import src.project.*;
import java.io.*;


public class DefineryTests extends TestCase{

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        temporaryFolder.create();
    }

    @Test
    public void testInstantiateDefinery(){
        Definery definery = new Definery();
        assertNotNull(definery);
    }

    /*
    @Test
    public void testCreatePrintWriter() throws IOException {
        File output = temporaryFolder.newFile("testOutput.txt");
        FindAndReplace findAndReplace = new FindAndReplace(null, output.getAbsolutePath(), null);
        PrintWriter printWriter = findAndReplace.createOutputFile();
        assertNotNull(printWriter);
    }

    @Test
    public void TestCreatePrintWriterWithoutPermissions() throws IOException {
        File temp = temporaryFolder.newFolder("tempNoPermissions");
        File output = new File(temp, "testOutput.txt");
        temp.setReadOnly();
        FindAndReplace findAndReplace = new FindAndReplace(null, output.getAbsolutePath(), null);
        PrintWriter printWriter = findAndReplace.createOutputFile();
        assertNull(printWriter);
    }

    //@Ignore
    public void testCreateMapOfFindAndReplaceValues() throws IOException{
        File findReplaceValues = temporaryFolder.newFile("findReplace.txt");
        PrintWriter printWriter = new PrintWriter(findReplaceValues);
        printWriter.println("ABC:abc,DEF:def");
        printWriter.println("key:value");
        printWriter.close();
        FindAndReplace findAndReplace = new FindAndReplace(null, null, findReplaceValues.getAbsolutePath());
        findAndReplace.createMapOfFindReplaceValues();
        assertEquals(3, findAndReplace.findReplaceValues.size());
    }
*/
}