
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import itsc2214.*;
/**
 * Project 2 - text analysis.
 * 
 * @author  jhenley8@charlotte.edu
 */

public class TextDocument implements Document {

    private String fileName;
    private HashMap<String, Integer> hashTable;
    private int numUniqueWords;
    private int numTotalWords;

    public TextDocument()
    {
    }
    public TextDocument(String fileName)
    {
    }

    @Override
    public String getFilename() {
    }

    @Override
    public boolean loadFromFile(String fileName)
    {
        try {
            this.fileName = fileName;
            java.util.List<String> lines = Files.readAllLines (Paths.get(fileName));
            StringBuilder k = new StringBuilder();
            for (String line : lines) {
                k.append(line).append(" ");
            }
            return loadFromString(k.toString().trim());
        } catch (IOException e) {
            return loadFromString("");
        }
    }

    @Override
    public boolean loadFromString(String data)
    {
    }

    public int frequency(String w) {
    }

    public void addWord(String w)
    {
    }

    public boolean contains(String w) {
    }

    public int numUniqueWordsInTable() {
    }

    public int totalNumOfWords() {
    }

}
