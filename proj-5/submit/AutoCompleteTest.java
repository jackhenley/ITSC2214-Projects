import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Unit test for the auto-complete project.
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
    }

    /**
     * Basic test
     */
    @Test
    public void testSomething()
    {
        fail("You have to provide test cases");
    }
}
