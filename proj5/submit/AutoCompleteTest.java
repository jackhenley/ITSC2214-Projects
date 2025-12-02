import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
/**
 * Unit test for the auto-complete project.
 * @author Jack Henley
 */
public class AutoCompleteTest
{
    private AutoComplete runner;

    /**
     * setup() method, runs before each of your test methods.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new AutoComplete("words.txt");
        ArrayList<String> nextList = runner.autocomplete("cho", 11);
        HashMap<Character, Integer> map = runner.possibleNextLetter(nextList, "cho");
    }

    /**
     * Basic test format
    
    @Test
    public void testSomething()
    {
        fail("You have to provide test cases");
    }
    */


    /**
     * Tests the constructor with an invalid filename. 
     * 
     */
    @Test
    public void testInvalidFileName() {
        AutoComplete fakeRunner = new AutoComplete("invalid.txt");
        assertEquals(fakeRunner.numWords(),0);
    }

    /**
     * TODO: probably don't need to test this case
     * Tests the constructor with a null filename
     * 
     *
    @Test
    public void testNullFileName () {
        try {
            AutoComplete nullRunner = new AutoComplete(null);
            fail("Should throw null pointer exception");
        }catch (NullPointerException npe) {
            
        }
    }
    */


    /**
     * Tests that the num words in the AVLTree is equal to the num words in the file.
     */
    @Test
    public void testNumWords() {
        assertEquals(5544, runner.numWords());
    }


    /**
     * Tests that the valid spelling method works with a properly spelled word.
     */
    @Test 
    public void testValidSpellingProper () {
        assertTrue(runner.validSpelling("chocolate"));
    }

    /**
     * Tests that the valid spelling method works with an incorrectly spelled word.
     */
    @Test
    public void testValidSpellingIncorrect () {
        //TODO: assertFalse?
        assertTrue(!runner.validSpelling("choocolate"));

    }

    /**
     * Tests possible next letters and checks their frequencies.
     */
    @Test 
    public void testPossibleNextLetterValid () {
        assertTrue(map.containsKey("r"));
    }


    /**
     * Test that verifies a word that shouldn't be in the hashmap isn't in the hashmap.
     * 
     */
    @Test
    public void testPossibleNextLetterInvalid () {

    }


    /**
     * Tests the autocomplete method when the prefix is valid. 
     * 
     */
    @Test 
    public void testAutocompleteValidPre () {

    }


    /**
     * Tests the autocomplete method when the prefix is invalid. 
     * 
     */
    @Test
    public void testAutocompleteInvalidPre () {

    }


    /**
     * Test that ensures arraylist returned from autocomplete is sorted.
     * 
     */
    @Test
    public void ensureSorted () {

    }

}
