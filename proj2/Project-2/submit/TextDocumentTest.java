import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.*;
import org.junit.runner.Runner;
import org.w3c.dom.Text;
import static org.junit.Assert.*;

/**
 * Unit test for the TextDocument class.
 */
public class TextDocumentTest {

    /**
     * testEmptyDoc() testing adding words by hand.
     */
    @Test
    public void testEmptyDoc() {
        TextDocument runner = new TextDocument();
        runner.addWord("Hello");
        runner.addWord("Hello");
        runner.addWord("World");

        int n = runner.numUniqueWordsInTable();
        assertEquals("Empty: numUniqueWordsInTable() is wrong", 2, n);

        n = runner.totalNumOfWords();
        assertEquals("Empty: totalNumOfWords() is wrong", 3, n);
    }

    // TODO add your own test cases here

    /**
     * Test a small file with no punctuation or capital letters.
     */
    @Test
    public void testSmallFileNoPuncNoCaps() {

        String fileName = "smallFileNoPuncNoCaps.txt";
        String content = "apple banana apple orange banana apple grape orange \n" + //
                "apple banana kiwi mango grape orange lemon lemon lemon \n" + //
                "kiwi pear banana mango grape pear apple orange mango \n" + //
                "lemon kiwi banana";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            return;
        }
        TextDocument runner = new TextDocument("smallFileNoPuncNoCaps.txt");

        assertEquals(runner.getFilename(), "smallFileNoPuncNoCaps.txt");

        assertEquals(runner.frequencyCount("apple"), 5);
        assertEquals(runner.frequencyCount("kiwi"), 3);

        runner.addWord("apple");
        assertEquals(runner.frequencyCount("apple"), 6);

        assertTrue(runner.contains("pear"));
        assertFalse(runner.contains("blueberry"));

        assertEquals(runner.totalNumOfWords(), 30);

        assertEquals(runner.numUniqueWordsInTable(), 8);

    }

    /**
     * Test a small file with capital letters but no punctuation.
     */
    @Test
    public void testSmallFileWithCapsNoPunc() {

        String fileName = "smallTestWithCapsNoPunc.txt";
        String content = "Apple banana apple orange banana apple grape\n" + //
                "orange Apple banana kiwi mango \n" + //
                "grape orange lemon Lemon lemon kiwi pear banana\n" + //
                "mango grape pear apple Orange mango lemon kiwi banana";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            return;
        }

        TextDocument runner = new TextDocument("smallTestWithCapsNoPunc.txt");

        assertEquals(runner.frequencyCount("apple"), 5);
        assertEquals(runner.frequencyCount("kiwi"), 3);

        runner.addWord("apple");
        assertEquals(runner.frequencyCount("apple"), 6);

        assertTrue(runner.contains("pear"));
        assertFalse(runner.contains("blueberry"));

        assertEquals(runner.totalNumOfWords(), 30);

        assertEquals(runner.numUniqueWordsInTable(), 8);
    }

    /**
     * Test a small file with punctuation but no capital letters.
     */
    @Test
    public void testSmallFileWithPuncNoCaps() {

        String fileName = "smallTestWithPuncNoCaps.txt";
        String content = "apple, banana apple orange banana! apple\n" + //
                "grape orange apple banana kiwi? mango \n" + //
                "grape orange lemon lemon. lemon... kiwi pear banana mango \n" + //
                "grape pear apple orange mango lemon? kiwi banana!";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            return;
        }

        TextDocument runner = new TextDocument("smallTestWithPuncNoCaps.txt");

        assertEquals(runner.frequencyCount("apple"), 5);
        assertEquals(runner.frequencyCount("kiwi"), 3);

        runner.addWord("apple");
        assertEquals(runner.frequencyCount("apple"), 6);

        assertTrue(runner.contains("pear"));
        assertFalse(runner.contains("blueberry"));

        assertEquals(runner.totalNumOfWords(), 30);

        assertEquals(runner.numUniqueWordsInTable(), 8);
    }

    /**
     * Test a small file with no punctuation or capital letters.
     */
    @Test
    public void testSmallFileWithPuncAndCaps() {

        String fileName = "smallTestWithPuncAndCaps.txt";
        String content = "Apple banana apple orange, banana apple grape.\n" + //
                "orange Apple, banana kiwi mango \n" + //
                "grape orange! lemon Lemon lemon kiwi pear banana\n" + //
                "mango grape pear, apple Orange: mango lemon kiwi banana?";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            return;
        }

        TextDocument runner = new TextDocument("smallTestWithPuncAndCaps.txt");

        assertEquals(runner.frequencyCount("apple"), 5);
        assertEquals(runner.frequencyCount("kiwi"), 3);

        runner.addWord("apple");
        assertEquals(runner.frequencyCount("apple"), 6);

        assertTrue(runner.contains("pear"));
        assertFalse(runner.contains("blueberry"));

        assertEquals(runner.totalNumOfWords(), 30);

        assertEquals(runner.numUniqueWordsInTable(), 8);
    }

    /**
     * Test methods when we make a TextDocument from an empty file.
     */
    @Test
    public void testEmptyFile() {

        String fileName = "emptyFile.txt";
        String content = "";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            return;
        }

        TextDocument runner = new TextDocument("emptyFile.txt");
        assertEquals(runner.totalNumOfWords(), 0);
        runner.addWord("apple");
        runner.totalNumOfWords();
    }

    /**
     * Test constructor on non-existent file.
     */
    @Test
    public void testNonExistentFile() {
        TextDocument runner = new TextDocument("nonExistentFile.txt");
        assertEquals(runner.totalNumOfWords(), 0);
    }

    /**
     * Test constructor when passed empty filename.
     */
    @Test
    public void testEmptyFileName() {
        String filename = null;
        TextDocument runner = new TextDocument(filename);
        assertEquals(runner.getFilename(), "");
    }

    /**
     * Test frequencyCount() method when passed a word not stored in the hashmap.
     */
    @Test
    public void testTableNotContainSearch() {
        TextDocument runner = new TextDocument();
        runner.addWord("Hello");
        runner.addWord("goodbye");
        assertEquals(runner.frequencyCount("world"), 0);
    }

    /**
     * Test addWord() with null string and with a string whose length is < 2.
     */
    @Test
    public void testAddWordBranches() {
        TextDocument runner = new TextDocument();

        String emptyWord = null;
        String smallWord = "hi";

        runner.addWord(emptyWord);
        assertEquals(runner.totalNumOfWords(), 0);

        runner.addWord(smallWord);
        assertEquals(runner.totalNumOfWords(), 0);
    }

}
