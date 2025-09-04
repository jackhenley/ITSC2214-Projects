import itsc2214.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
/**
 * @author Jack Henley
 * @version 1.0
 * What else do we need here?
 * 
 */


/**
 * Implements Conway's Game of Life using a 2D array.
 */
public class Project1 implements GameOfLife {

    //what fields do we need??
    //probably also need Project1 currentGen and project1 previousGen

    int rows;
    int cols;
    boolean[][] currentGen;
    boolean[][] prevGen;
    


    // TODO Implement 2 constructors

    /**
     * Constructor that constructs a GameOfLife object with an empty board
     */
    public Project1() {
        this(0,0);
        
        //todo: when should this be thrown?
       throw new UnsupportedOperationException("Unimplemented default constructor");        
    }

    /**
     * Constructs a GameOfLife object with the specified grid dimensions.
     * @param row - rows in the grid
     * @param col - columns in the grid
     */
    public Project1(int row, int col) {
        if(row == 0 || col == 0) {
            throw new UnsupportedOperationException("Unimplemented constructor with args"); 
        }
        this.cols = col;
        this.rows = row;
        

               
    }

    // TODO Implement all the methods fron the GameOfLife

    /**
     * randomInitialize - method that randomly initializes the grid 
     * with live cells based on given probability. Number is generated
     *  for each cell using Random class, and calling nextDouble() method. 
     * If value returned is < alive probability, 
     * cell is set to false (dead). Otherwise, cell is set to alive.
     * 
     * @param aliveProbability - double between (0.0-1.0) representing 
     * probability of cell being initially alive.
     */
    public void randomInitialize(double aliveProbability) {
       
        Random ran = new Random();

        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {

                double actualVal = ran.nextDouble();

                if(actualVal < aliveProbability) {
                    currentGen[i][j] = false;
                }else {
                    currentGen[i][j] = true;
                }
            }
        }
    }


     /**
      * loadFromString - method that loads the initial grid
      * config. from a string. String should contain the number  
      * of rows and cols on the first line, followed by lines of 
      * "." and 'O' characters representing the grid. 
      *
      * (Use scanner) 
      *
      * @param data - string containing grid data to be processed
      */
    public void loadFromString(String data) {
        Scanner scanIn = new Scanner(data);
        
        int row = scanIn.nextInt();
        int col = scanIn.nextInt();
        
        scanIn.nextLine();
        for(int i = 0; i < row; i++) {
            String line = scanIn.nextLine();
            for(int j = 0; j < col; j++) {
                if(line.charAt(col) == '.') {
                    currentGen[row][col] = false;
                }else {
                    currentGen[row][col] = true;
                }

            }
            scanIn.close();
        }
    }


    /**
     * Load from file- Loads the initial grid config from a file. 
     * Reads all data from file -> converts to string
     * Once converted, this method calls the loadFromString 
     * method to process the string.
     * 
     * @param fileName - name of file to be processed 
     */
    public void loadFromFile(String filename) throws FileNotFoundException {
        

    }


    /**
     * countLiveNeighbors - method used to count the number of live 
     * neighbors surrounding the cell at (r,c)
     * 
     * @param r - row index of the cell
     * @param c - column index of the cell
     * @return the number of neighbors nearby that are alive.
     */
    public int countLiveNeighbors(int r, int c) {
        return 0;
    }

    /**
     * nextGeneration - method used to determine the next generation
     * of the grid based on Conway's rules. Traverses the internal
     * 2-dimension boolean arayi, counting the number of neighbors for each cell
     * by calling countLiveNeighbors, and sets the next generation grid
     * position accordingly. 
     */
    public void nextGeneration() {

    }

    /**
     * isAlive - method used to check if the cell at (r,c) is alive. Acts as helper method
     * for nextGeneration() and countLiveNeighbors(). 
     * 
     * @param r - row index of the cell
     * @param c - column index of the cell
     * @return true if cell at (r,c) is alive; false otherwise
     */
    public boolean isAlive(int r, int c) {
        return true;

    }


    /**
     * numRows - method to determine the number of rows in the given simulation
     * 
     * @return the number of rows in the grid for this simulation
     */
    public int numRows() {
        return 0;

    }


     /**
     * numCols - method to determine the number of cols in the given simulation
     * 
     * @return the number of cols in the grid for this simulation
     */
    public int numCols() {
        return 0;

    }

    /**
     * Method used to determine whether or not the current generation is a 
     * still life (Stable pattern between multiple generations)
     * ^Marks the end of a simulation
     * 
     * @return true if current simulation is a still life; false otherwise 
     */
    public boolean isStillLife() {
        return true;

    }


}