import java.io.*;
import java.util.*;
public class Project4test {
	public static void main( String args[] ) throws Exception {
		if (args.length < 2 ) {
			System.out.println("ERROR: Must provide dictionary and jumbled word list to continue\n");
			System.exit(0);
		}
        BufferedReader dictIn = new BufferedReader( new FileReader(args[0]));
        BufferedReader jumbIn = new BufferedReader( new FileReader(args[1]));   
        ArrayList<String> dictList =new ArrayList<String>();
        ArrayList<String> jumbList =new ArrayList<String>();
		while (dictIn.ready()) {
			String dictStrings = dictIn.readLine();
            dictList.add(toCanonical(dictStrings) + " " + dictStrings);
        }
        while (jumbIn.ready()) {
            jumbList.add(jumbIn.readLine());
        }
        Collections.sort(dictList);
        Collections.sort(jumbList);
        ArrayList<String> dCan = new ArrayList<String>();
        ArrayList<String> dList = new ArrayList<String>();
        ArrayList<String>permu = new ArrayList<String>();
        for (int i = 0; i < dictList.size(); i++) {
            String line = dictList.get(i);
            String pair[] = line.split(" ");
            String dTempCan = pair[0];
            String dTemp = pair[1];
            dCan.add(dTempCan);
            dList.add(dTemp);
        }
        for(int i = 0; i < jumbList.size(); i++) {
            String key = toCanonical(jumbList.get(i));
            int j = Collections.binarySearch(dCan, key);
            System.out.print(jumbList.get(i));
            if(j<0){
                System.out.println("");
            } else {
                int k = 0;
                for(int h = j; ((h>=0) && dCan.get(h).equals(key)); h--)
                    k = h;
               
                for(int h = k; (h<dCan.size() && dCan.get(h).equals(key)); h++)
                    System.out.print(" " + dList.get(h));
                
                System.out.println("");
            } 
        }
System.out.println("Total execution time: " + (endTime - startTime) );
    }
    static String toCanonical(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }

}