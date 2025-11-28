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

    private int size = 0;

    /**
     * This is the constructor for the class. It takes the name of a file containing
     * words and reads them in an internal intance variable of type BinarySearchTree<String>
     */
    public AutoComplete(String filename)
    {
        super();
        // call the superclass constructor
        // load the contents of the file
        // catch a FileNotFound exception and don't fail
        // keep track of number of words loaded
        try {
            File file = new File("filename");
            Scanner scanIn = new Scanner(file);
            while(scanIn.hasNextLine()) {
                String word = scanIn.nextLine();
                this.add(word);
                this.size += 1;
            }
            scanIn.close();
        }catch(FileNotFoundException fne) {
            //what should we do here
            System.exit(0);
        }
    }

    /**
     * Method that returns the number of words in the file.
     * @return number of words in the file.
     */
    public int numWords()
    {
        //TODO: return the number of words
        return this.size;      
    }


    /**
     * Checks the internal bst for the given word.
     * @return true if word exists in the tree, false otherwise.
     */
    public boolean validSpelling(String w)
    {
        // TODO check if w exists in the tree
        return this.contains(w);
    }

    /**
     * Given a list of words, all with a common prefix, find the set of next letters from word passed as args.
     * @return hashmap containing int, char pair, where the char is the next letter
     * and the int is the number of occurences.
     */
    public HashMap<Character, Integer> possibleNextLetter(
            ArrayList<String> list, String prefix)
    {
        // TODO build a hashmap of the "next" letter and a count
        // count all the words that have the next letter
        // return a hashmap
        HashMap<Character, Integer> prefixes = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if(word.startsWith(prefix)) {
                String newWord = word.substring(prefix.length());
                Character nextChar = newWord.charAt(0);
                if(prefixes.containsKey(nextChar)) {
                    prefixes.put(nextChar, prefixes.get(nextChar) + 1);
                }else {
                    prefixes.put(nextChar, 1);
                }
            }
        }
        return prefixes;
    }
    /**
     * Does a tree traversal of the internal tree looking for
     * all the words in the tree that start with the prefix. 
     * @return an ArrayList<String> with the words found.
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