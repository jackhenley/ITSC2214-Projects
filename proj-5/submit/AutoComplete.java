import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import itsc2214.*;

/**
 * Uses an AVL tree to store words from file "words.txt"
 * The tree will implement a binary search tree that is
 * balanced. 
 */
public class AutoComplete extends AVLTree<String> {

    /**
     * Constructor
     */
    public AutoComplete(String filename)
    {
        // call the superclass constructor
        // load the contents of the file
        // catch a FileNotFound exception and don't fail
        // keep track of number of words loaded
    }

    /**
     * numWords
     */
    public int numWords()
    {
        // TODO return number of words
        return 0;
    }

    /**
     * validSpelling
     */
    public boolean validSpelling(String w)
    {
        // TODO check if w exists in the tree
        return false;
    }

    /**
     * possibleNextLetter
     */
    public HashMap<Character, Integer> possibleNextLetter(
            ArrayList<String> list, String prefix)
    {
        // TODO build a hashmap of the "next" letter and a count
        // count all the words that have the next letter
        // return a hashmap
        return null;
    }
    /**
     * autocomplete 
     */
    public ArrayList<String> autocomplete(String pre, int limit)
    {
        // TODO call the recursive version below
        // sort the results in increasing order of word length
        // return only the first 'limit' results
        return null;
    }

    /**
     * autocomplete 
     */
    private void autocomplete(AVLNode<String> node, String pre,
        ArrayList<String> lst)
    {
        // TODO recursive traversal of the tree looking
        // for words that start with pre, accumulating them
        // in lst
    }
}