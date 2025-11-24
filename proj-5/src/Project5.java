import java.util.*;

public class Project5 {

    // Main to test
    public static void main(String[] args)  {

        AutoComplete tree = new AutoComplete("words.txt");

        // System.out.print("In-order traversal: ");
        // tree.inorder(word -> System.out.println(word));

        String prefix;
        if (args.length == 0)
            prefix = "pre";
        else
            prefix = args[0].toLowerCase();


        System.out.println("Num of words: "+tree.numWords());

        // Spelling
        if (tree.validSpelling("captain"))
            System.out.println("captain is properly spelled.");
        if (!tree.validSpelling("captian"))
            System.out.println("captian is a typo.");


        ArrayList<String> list = tree.autocomplete(prefix, -1);
        for (String w : list)
            System.out.println(w);
        HashMap<Character, Integer> map = tree.possibleNextLetter(list, prefix);

        System.out.println("Auto complete: "+prefix);
        System.out.println("# Matches : "+list.size());
        System.out.println(String.join(", ", list));
        map.forEach( (k, v) -> { System.out.println(k + " -> " + v); } );
    }
}