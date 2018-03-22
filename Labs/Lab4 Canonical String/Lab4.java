import java.io.*;
import java.util.*;
public class Lab4 {
	public static void main( String args[] ) throws Exception {
		if (args.length < 1 ) {
			System.out.println("ERROR: Must provide a file to begin\n");
			System.exit(0);
		}
        BufferedReader inFile = new BufferedReader( new FileReader(args[0]) );
        ArrayList<String> wordList =new ArrayList<String>();
		while (inFile.ready()) {
			String wordIn = inFile.readLine();
            wordList.add(wordIn + " " + toCanonical(wordIn));
        }
        Collections.sort(wordList);
        for (String w : wordList )
	 	    System.out.println(w + "");
    }
    static String toCanonical(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}