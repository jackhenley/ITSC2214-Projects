import org.junit.*;
import static org.junit.Assert.*;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Unit tests for PixelatedImage - project 4
 * 
 * @author Jack Henley
 */
public class PixelatedImageTest {
   private PixelatedImage runner;

   /**
    * setup() method, runs before each of your test methods.
    * Use this method to recreate the objects needed for
    * testing your class.
    */
   @Before
   public void setup() {
      runner = new PixelatedImage(5);
   }

   /**
    * testDefaults() method, tests the default constructor.
    */
   @Test
   public void testDefaults() {
      assertEquals(5, runner.getWidth());
      assertEquals(5, runner.getHeight());
      for (int r = 0; r < runner.getHeight(); r++)
         for (int c = 0; c < runner.getWidth(); c++)
            assertEquals(0, runner.getPixel(r, c));
   }

   /**
    * testFromFile() method, tests constructor when loading from file.
    */
   @Test
   public void testFromFile() {
      String fileName = "testFile.txt";
      String content = "20\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n" + //
            "0,0,0,0,6,6,0,0,0,0,0,0,0,0,6,6,0,0,0,0\n" + //
            "0,0,0,0,6,6,0,0,0,0,0,0,0,0,6,6,0,0,0,0\n" + //
            "0,0,0,0,0,0,6,6,0,0,0,0,6,6,0,0,0,0,0,0\n" + //
            "0,0,0,0,6,6,6,6,6,6,6,6,6,6,6,6,0,0,0,0\n" + //
            "0,0,0,6,6,6,0,0,6,6,6,6,0,0,6,6,6,0,0,0\n" + //
            "0,0,0,6,6,6,0,0,6,6,6,6,0,0,6,6,6,0,0,0\n" + //
            "0,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,0\n" + //
            "0,6,6,0,6,6,6,6,6,6,6,6,6,6,6,6,0,6,6,0\n" + //
            "0,6,6,0,6,6,0,0,0,0,0,0,0,0,6,6,0,6,6,0\n" + //
            "0,6,6,0,6,6,0,0,0,0,0,0,0,0,6,6,0,6,6,0\n" + //
            "0,0,0,0,0,0,6,6,6,0,0,6,6,6,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,6,6,6,0,0,6,6,6,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0\n" + //
            "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0";
      try {
         FileWriter writer = new FileWriter(fileName);
         writer.write(content);
         writer.close();
      } catch (IOException ioe) {
      }
      runner = new PixelatedImage(fileName);
      assertEquals(20, runner.getHeight());
      assertEquals(20, runner.getWidth());
      // TODO: add more tests for files
   }

   /**
    * testNoFile method, tests the loadFrom file method when file DNE.
    */
   @Test
   public void testNoFile() {
      runner = new PixelatedImage("fakeFile.txt");
      assertEquals(5, runner.getHeight());
      assertEquals(5, runner.getWidth());
   }

   /**
    * testLoadRandomly(), test initializing grid using loadRandomly().
    */
   @Test
   public void testLoadRandomly() {

      runner.loadRandomly();

      for (int i = 0; i < runner.getWidth(); i++) {
         for (int j = 0; j < runner.getHeight(); j++) {
            assertTrue(runner.getPixel(i, j) < 16 && runner.getPixel(i, j) > 0);
         }
      }
   }

   /**
    * testSetPixel(), method to test setPixel() method.
    */
   @Test
   public void testSetPixel() {
      runner = new PixelatedImage(4);
      runner.loadRandomly();

      // set (2,2) to valid value
      runner.setPixel(2, 2, 8);
      assertEquals(8, runner.getPixel(2, 2));

      // set (2,2) to negative value
      runner.setPixel(2, 2, -3);
      assertEquals(8, runner.getPixel(2, 2));

      // set (2,2) to too high of a value
      runner.setPixel(2, 2, 20);
      assertEquals(8, runner.getPixel(2, 2));

   }

   /**
    * testFloodFill, method that tests the floodFill method.
    */
   @Test
   public void testFloodFill() {
      runner.floodFill(0, 0, 7);

      for (int i = 0; i < runner.getWidth(); i++) {
         for (int j = 0; j < runner.getHeight(); j++) {
            assertEquals(runner.getPixel(i, j), 7);
         }
      }

   }

}
