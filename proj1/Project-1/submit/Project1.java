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

    private int rows;
    private int cols;
    private boolean[][] currentGen;
    private boolean[][] prevGen;
    



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

        //make scanner
        Scanner scanIn = new Scanner(data);
        
        //get rows and cols 
            int row = scanIn.nextInt();
            int col = scanIn.nextInt();
        
        //initialize current grid with given size
        currentGen = new boolean[row][col];
        prevGen = new boolean[row][col];

        scanIn.nextLine();
        for(int i = 0; i < row; i++) {
            String line = scanIn.nextLine();
            for(int j = 0; j < col; j++) {
                if(line.charAt(j) == '.') {
                    currentGen[i][j] = false;
                }else {
                    currentGen[i][j] = true;
                }
            }
        }
        scanIn.close();
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
        
        File filePath = new File(filename);
        StringBuilder newGrid = new StringBuilder();
        Scanner scanIn = new Scanner(filePath);

        while(scanIn.hasNextLine()) {
            //store file contents in stringBuilder
            newGrid.append(scanIn.nextLine()).append("\n");
        }

        scanIn.close();
        //convert stringBuilder grid to String so we can call loadFromFile() method
        String stringGrid = newGrid.toString();

        loadFromFile(stringGrid);
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

        int liveNeighbors = 0;

        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) {
                    //skip cell we're checking
                    continue;
                }
                
                //find values to check
                int newRow = r + i;
                int newCol = c + j;


                if(newRow >= 0 && newRow < rows &&
                newCol >= 0 && newCol < cols) {
                    if(currentGen[newRow][newCol]) {
                        liveNeighbors += 1;
                    }
                }
            }
        }
        
        
        return liveNeighbors;
        
    }

    /**
     * nextGeneration - method used to determine the next generation
     * of the grid based on Conway's rules. Traverses the internal
     * 2-dimension boolean arayi, counting the number of neighbors for each cell
     * by calling countLiveNeighbors, and sets the next generation grid
     * position accordingly. 
     */
    public void nextGeneration() {

        //iterate over entire current grid
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < rows; j++) {
                
                //store this cell's properties
                boolean currentCell = isAlive(i, j);
                int liveCount = countLiveNeighbors(i, j);

                //store this cell in previous grid
                prevGen[i][j] = currentCell;
                
                //determine this cell's next status 
                if(currentCell && liveCount == 2) {
                    currentCell = true;
                }else if(currentCell && liveCount == 3) {
                    currentCell = true;
                }else if(!currentCell && liveCount == 3) {
                    currentCell = true;
                }else {
                    currentCell = false;
                }
            }
        }
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

        boolean result;
        if(currentGen[r][c]) {
             result = true;
        }else {
            result = false;
        }
        return result;
    }


    /**
     * numRows - method to determine the number of rows in the given simulation
     * 
     * @return the number of rows in the grid for this simulation
     */
    public int numRows() {
        return this.rows;

    }


     /**
     * numCols - method to determine the number of cols in the given simulation
     * 
     * @return the number of cols in the grid for this simulation
     */
    public int numCols() {
        return this.cols;

    }

    /**
     * Method used to determine whether or not the current generation is a 
     * still life (Stable pattern between multiple generations)
     * ^Marks the end of a simulation
     * 
     * @return true if current simulation is a still life; false otherwise 
     */
    public boolean isStillLife() {

        boolean result = false;
        int sameCount = 0;

        //deterimne number of cells in grid
        int totalCells = rows*cols;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(currentGen[i][j] == prevGen[i][j]) {
                    sameCount += 1;
                }
            }
        }
        if(sameCount == totalCells) {
            result = true;
        }
        return result;
    }


}