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
     * Constructor for the class. Takes the name of a file containing
     * words and reads them in and stores them in an internal instance variable of 
     * type BinarySearchTree<String>.
     */
    public AutoComplete(String filename)
    {
        // call the superclass constructor
        // load the contents of the file
        // catch a FileNotFound exception and don't fail
        // keep track of number of words loaded



        //TODO: should we use super()?

        AVLTree<String> tree = new AVLTree<String>();

        try {
            Scanner scanIn = new Scanner(filename);
            while(scanIn.hasNextLine()) {
                String word = scanIn.next(" "); //should it be split by spaces or by \n's?
                tree.add(word);
            }
            scanIn.close();
        }catch(FileNotFoundException fne) {
            System.out.println("");
        }
        


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
     * Method that checks the internal binary search tree for the given word.
     * @return true if the word exists in the tree, false otherwise.
     */
    public boolean validSpelling(String w)
    {
        // TODO check if w exists in the tree
        return false;
    }

    /**
     * Given a list of words, all with a common prefix, return a list
     * of letters that is the set of possible "next" lettersfrom the list of words
     * passed as argument.
     * @return HashMap containing character/integer pairs, where 
     * the character is the next character and the int is the number of occurences.
     * 
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