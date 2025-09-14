import org.junit.*;
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
}
