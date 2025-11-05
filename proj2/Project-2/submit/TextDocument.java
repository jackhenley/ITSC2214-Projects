
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import itsc2214.*;

/**
 * Project 2 - text analysis.
 * 
 * @author jhenley8@charlotte.edu
 */

public class TextDocument implements Document {

    private String fileName;
    private HashMap<String, Integer> hashTable;
    private int numUniqueWords;
    private int numTotalWords;

    /**
     * Default constructor for the class, creates the intial HashMap.
     * Then initializes everything as if it had an empty document by calling
     * loadFromString("");
     */
    public TextDocument() {
        hashTable = new HashMap<>();
        loadFromString("");
    }

    /**
     * Constructor for the class, creates initial HashMap, reads the content
     * of a file and calls loadFromFile(fileName).
     * 
     * @param fileName - name of the file to load TextDocument from.
     */

    public TextDocument(String fileName) {
        this.fileName = fileName;
        hashTable = new HashMap<>();
        loadFromFile(fileName);
    }

    /**
     * Defnied in the document interface.
     * Returns the fileName of the TextDocument as passed in the first argument
     * of the constructor. If there is no file name, it just return an empty string.
     */
    @Override
    public String getFilename() {
        if (this.fileName != null) {
            return this.fileName;
        } else {
            String result = "";
            return result;
        }
    }

    /**
     * Defined in the Document interface.
     * This routine should open the file name in the argument, load the
     * full conent into a string and then call the loadFromString() method to
     * process
     * the string. This routing captures a FileNotFoundException and simply calls
     * loadFromString("") with an empty string. This should initialize the
     * HashMap to have no words. In effect, a file not found should behave
     * identically to an empty file.
     * 
     * @return - returns true if it was able to load the file, or false if an
     *         error occurred.
     */
    @Override
    public boolean loadFromFile(String fileName) {
        try {
            // this.fileName = fileName;
            java.util.List<String> lines = Files.readAllLines(Paths.get(fileName));
            StringBuilder k = new StringBuilder();
            for (String line : lines) {
                k.append(line).append(" ");
            }
            return loadFromString(k.toString().trim());
        } catch (IOException e) {
            return loadFromString("");
        }
    }

    /**
     * Defined in Document class.
     * 
     * This method breaks a string into tokens separated by whitespace
     * and by punctuations. The non-alphanumeric characters are used as
     * separator and ignored. The reamaining tokens should be stored into a
     * HashMap by calling addWord(word).
     * 
     * @return true if we successfully add all words from string to hashmap; false
     *         otherwise
     */
    @Override
    public boolean loadFromString(String data) {

        if (data.isEmpty()) {
            return false;
        } else {
            // convert string to array of chars
            char[] dataArray = data.toCharArray();

            // string builder to get words from chars in array
            StringBuilder word = new StringBuilder();

            for (char element : dataArray) {

                // check if current char is a letter
                if (Character.isLetter(element)) {
                    word.append(element);

                    // char is not a letter/digit -> end word
                } else {
                    // add new word to hashmap
                    addWord(word.toString());
                    System.out.println(word);
                    // clear string builder
                    word.setLength(0);
                }

            }
            if (word.length() > 0) {
                addWord(word.toString());
            }
            return true;
        }

    }

    /**
     * Returns the word frequency count for w if it exists in the HashMap,
     * returns 0 otherwise.
     * 
     * @param w - word whose frequency we are checking.
     * @return - an int representing the instances of w in the HashMap; 0 if none.
     */
    public int frequencyCount(String w) {
        int frequency = 0;
        if (hashTable.containsKey(w)) {
            frequency = hashTable.get(w);
        }
        return frequency;
    }

    /**
     * This method implements the algorithm to add the word to the HashMap.
     * (See instructions for algorithm steps)
     * 
     * @param w - word to be added to HashMap
     */
    public void addWord(String w) {
        if (w != null) {
            w = w.trim();
            w = w.toLowerCase();

            if (!w.isEmpty() && w.length() > 2) {
                if (hashTable.containsKey(w)) {
                    int currentVal = hashTable.get(w);
                    hashTable.put(w, currentVal + 1);
                } else { // w is not already in the hashmap
                    hashTable.put(w, 1);
                }
            }
        }
    }

    /**
     * Method to determine if the document contains a given word.
     * 
     * @param w - word to search for in the document.
     * @return - true if w is contained in the document, false otherwise.
     */
    public boolean contains(String w) {
        return hashTable.containsKey(w);
    }

    /**
     * Return the number of unique words stored in the hash table. You could keep
     * track of this number internally, rather than compute it when requested.
     * Or simply use a method available in HashMap that tells you how many
     * elements are stored in the table
     * 
     * @return - number of unique words stored in the hash table.
     */
    public int numUniqueWordsInTable() {
        return hashTable.size();
    }

    /**
     * Method that returns the total nymber of words in the hash table,
     * regardless of their uniqueness.
     * 
     * @return - total number of words in the hash table.
     */
    public int totalNumOfWords() {
        int total = 0;
        for (int count : hashTable.values()) {
            total += count;
        }
        return total;
    }

}
