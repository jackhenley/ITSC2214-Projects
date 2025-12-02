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
            File file = new File(filename);
            Scanner scanIn = new Scanner(file);
            while(scanIn.hasNextLine()) {
                String word = scanIn.nextLine();
                this.add(word);
                this.size += 1;
            }
            scanIn.close();
        }catch(FileNotFoundException fne) {
            //what should we do here
            System.err.println("Invalid file name "+fne);
            
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
     * 
     * @param list - list of words
     * @param prefix - prefix for words to have in common
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
     * Does a tree traversal to find all words in the tree that start with pre.
     * This is achieved by calling the private, recursive autocomplete method. 
     * Once the recursive method returns an array list containing all words that start
     * with pre, this method sorts those words based on their length.
     *  
     * @param pre - prefix to check for 
     * @param limit - number of words to limit arrayList to  
     * @return the ArrayList<String> with the words found.
     */
    public ArrayList<String> autocomplete(String pre, int limit)
    {
        // TODO call the recursive version below
        // sort the results in increasing order of word length
        // return only the first 'limit' results


        AVLNode<String> root = this.getRoot();

        ArrayList<String> list = new ArrayList<>();
        autocomplete(root, pre, list);

        //list should be populated & unsorted now

        
        //TODO: might need to add comparator as 2nd arg
        Collections.sort(list);

        //only want to return 'limit' amount of entries        
        ArrayList<String> finalList = new ArrayList<>(); 
        for(int i = 0; i < limit; i++) {
            finalList.add(list.get(i));
        }

        return finalList;
    }

    /**
     * Private, recursive autocomplete method that populates the unsorted array list.
     * 
     * @param node - root node of AVLTree 
     * @param pre - prefix to compare against
     */
    private void autocomplete(AVLNode<String> node, String pre,
        ArrayList<String> lst)
    {

        // TODO recursive traversal of the tree looking
        // for words that start with pre, accumulating them
        // in lst

        if(node == null) {
            return;
        }

        String word = node.getValue();

        if(word.compareTo(pre) >= 0) {
            autocomplete(node.getLeft(), pre, lst);
        }

        if(word.startsWith(pre)) {
            lst.add(word);
        }

        if(word.startsWith(pre) || word.compareTo(pre) < 0) {
            autocomplete(node.getRight(), pre, lst);
        }

    }
}