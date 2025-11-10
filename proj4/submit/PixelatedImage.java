import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Pixelated Image class.
 * Class representing a grid of "colors" with built-in methods to
 * manipulate/interact with those colors.
 * 
 * @author Jack Henley
 */
public class PixelatedImage {

    private int size;
    private int grid[][];
    private boolean visited[][];

    /**
     * Constructor that creates a size x size integer array
     * and initializes it to 0 values.
     * 
     * @param s - size of the array
     */
    public PixelatedImage(int s) {
        size = s;
        grid = new int[size][size];

    }

    /**
     * Constructor, tries to load the contents of filename by calling loadFromFile().
     * If loadFromFile throws an exception, this method (the constructor),
     * should catch it, and create a 5x5 integer array and initialize it to 0
     * values.
     * 
     * @param filename - name of file to load grid from
     */
    public PixelatedImage(String filename) {
        try {
            loadFromFile(filename);
        } catch (FileNotFoundException fne) {
            grid = new int[5][5];
        }
    }

    /**
     * Method that fills all positions in the grid with random values between 1 and
     * 16.
     */
    public void loadRandomly() {
        Random rand = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int value = rand.nextInt(16);
                if (value == 0) {
                    value += 1;
                }
                grid[i][j] = value;
            }
        }
    }

    /**
     * Load the content of a csv file (comma separated values) into internal grid
     * represntation.
     * 
     * @param inFile - csv file to load from
     * @throws FileNotFoundException - exception thrown if the given file does not
     *                               exist.
     */
    public void loadFromFile(String inFile) throws FileNotFoundException {
        File myObj = new File(inFile);
        Scanner scan = new Scanner(myObj);

        String line = scan.nextLine();
        size = Integer.parseInt(line);
        grid = new int[size][size];
        for (int i = 0; scan.hasNext() && i < getHeight(); i++) {
            line = scan.nextLine();
            String[] tokens = line.split(",");
            for (int j = 0; j < Math.min(tokens.length, size); j++) {
                grid[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        scan.close();
    }

    /**
     * Method that returns the width of this grid.
     * 
     * @return width of this grid.
     */
    public int getWidth() {
        return grid.length;
    }

    /**
     * Method that returns the height of this grid.
     * 
     * @return height of this grid.
     */
    public int getHeight() {
        return grid[0].length;
    }

    /**
     * Returns the color value stored at location - (row,col).
     * 
     * @param row - row of pixel
     * @param col - col of pixel
     * @return - color value
     */
    public int getPixel(int row, int col) {
        return grid[row][col];
    }

    /**
     * Sets color value at row and col. Color is expected to be between 0-15.
     * If it isn't, do nothing (fail silently).
     * 
     * @param row   - row to fill
     * @param col   - col to fill
     * @param color - color (expect 0 <= color <= 15)
     */
    public void setPixel(int row, int col, int color) {
        if (color > 15 || color < 0) {
            return;
        } else {
            grid[row][col] = color;
        }

    }

    /**
     * Routine that starts the recursion by finding
     * the color at row,col and passing it to the recursive
     * version as origColor. Creates the visited array to
     * tag cells as they are visited.
     * 
     * @param row - row of the grid to visit
     * @param col - col of the grid to visit
     * @param fillColor - color to use for replacing
     */
    public void floodFill(int row, int col, int fillColor) {
        int origColor = grid[row][col];
        visited = new boolean[getHeight()][getWidth()];
        floodFill(row, col, origColor, fillColor);
    }

    /**
     * Recusive routine that starts at row,col and if the color stored there
     * is origColor, replaces it and recursively calls it with the four adjacent
     * neighbors (left, right, top bottom).
     * 
     * @param row - row to start at
     * @param col - column to start at
     * @param origColor - color to be replaced
     * @param fillColor - new fill color
     */
    protected void floodFill(int row, int col, int origColor, int fillColor) {

        if(row < 0|| row >= this.size || col < 0 || col >= this.size) {
            return;
        }

        if (grid[row][col] != origColor || origColor == fillColor) {
            return;

        } else {

            grid[row][col] = fillColor;
            visited[row][col] = true;

            floodFill(row, col + 1, origColor, fillColor);
            floodFill(row, col - 1, origColor, fillColor);
            floodFill(row + 1, col, origColor, fillColor);
            floodFill(row - 1, col, origColor, fillColor);
        }
    }
}
