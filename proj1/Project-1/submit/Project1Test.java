import itsc2214.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Tester for Project1 class.
 * 
 * @version 2.0
 */
public class Project1Test {

    private Project1 runner;

    /**
     * setup() method, creates a game of life with 3x3 grid.
     */
    @Before
    public void setup() {
        runner = new Project1(3, 3);
    }

    /**
     * Checks basic setup of 3x3.
     */
    @Test
    public void testOne() {
        assertEquals(3, runner.numRows());
        assertEquals(3, runner.numCols());
    }

    /**
     * Checks a basic initial grid.
     */
    @Test
    public void testSmallGrid() {
        String inputData = "3 3\n" +
                "O..\n" +
                "...\n" +
                "...\n";
        runner.loadFromString(inputData);
        // check position 0,0
        assertTrue("Position 0,0 should be alive",
                runner.isAlive(0, 0));
        // run generation
        runner.nextGeneration();
        // check position 0,0
        assertFalse("Position 0,0 should NOT be alive",
                runner.isAlive(0, 0));
        assertFalse(runner.isStillLife());
    }

    /**
     * Test all condition paths found in nextGeneration method.
     */
    @Test
    public void testNextGenConditions() {
        String inputData = "3 3\n" +
                "0.0\n" +
                ".0.\n" +
                "0..\n";
        runner.loadFromString(inputData);
        runner.nextGeneration();

    }

    /**
     * Tests a grid initialized with randomInitialize method.
     */
    @Test
    public void testRandomSmallGrid() {

        // test when runner is initialized randomly
        runner.randomInitialize(0.5);
        // go to next gen until runner is still life
        while (!runner.isStillLife()) {
            runner.nextGeneration();
        }
        assertTrue(runner.isStillLife());
    }

    /**
     * Tests a grid initialized from loadFromFile method.
     * 
     * @throws Exception
     */
    @Test
    public void testFromFile() throws Exception {

        // initialize runner from file
        File fileGrid = File.createTempFile("grid", ".txt");
        try (PrintWriter out = new PrintWriter(fileGrid)) {
            out.println("3 3");
            out.println("O.O");
            out.println("...");
            out.println(".O.");
        }
        // load grid from file just created
        runner.loadFromFile(fileGrid.getAbsolutePath());
        // check num rows/cols
        assertTrue(runner.numRows() == 3);
        assertTrue(runner.numCols() == 3);

        // check that is alive is functional for grid loaded from file
        assertTrue(runner.isAlive(0, 2));

        // run until runner isStillLife
        while (!runner.isStillLife()) {
            runner.nextGeneration();
        }
        // make sure runner isStillLife
        assertTrue(runner.isStillLife());

    }

    /**
     * Tests whether an exception is thrown from an empty constructor.
     */
    @Test
    public void testEmptyConstructorException() {
        try {
            new Project1();
        } catch (UnsupportedOperationException e) {
            assertEquals("Unimplemented default constructor", e.getMessage());
        }
    }

    /**
     * Test if an exception is thrown if we try to initialize a grid with no rows.
     */
    @Test
    public void testZeroRowConstructor() {
        try {
            new Project1(0, 3);
        } catch (UnsupportedOperationException e) {
            assertEquals("Unimplemented constructor with args", e.getMessage());
        }
    }

    /**
     * Tests if an exception is thrown if we try to initialize a grid with no.
     * columns
     */
    @Test
    public void testZeroColConstructor() {
        try {
            new Project1(3, 0);
        } catch (UnsupportedOperationException e) {
            assertEquals("Unimplemented constructor with args", e.getMessage());
        }
    }
}
