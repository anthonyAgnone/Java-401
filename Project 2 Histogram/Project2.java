import java.io.*;
import java.util.*;

public class Project2
{
	static final int INITIAL_CAPACITY = 10;
	public static void main (String[] args) throws Exception
	{
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Project2 <input filename>\n\n"); 
			System.exit(0);
		}
		int[] histogram = new int[0]; 
		String[] wordList = new String[INITIAL_CAPACITY];
		int wordCount = 0;
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
		while ( infile.ready() )
		{
			String word = infile.readLine();
            if(wordCount>=wordList.length)
                wordList=upSizeArr(wordList);

            wordList[wordCount]=word;
            wordCount++;

            if(histogram.length<=word.length())
                histogram = upSizeHisto(histogram,word.length()+1);

            ++histogram[word.length()];		
		} 
		infile.close();
		wordList = trimArr( wordList, wordCount );
		System.out.println( "After final trim: wordList length: " + wordList.length + " wordCount: " + wordCount );
		for ( int i = 0; i < histogram.length ; i++ )
			System.out.format("words of length %2d  %d\n", i,histogram[i] );
	} 
	static String[] upSizeArr( String[] fullArr ){	
		String[] newArr = new String[fullArr.length * 2];
        for(int i=0;i<fullArr.length;i++) {
              newArr[i]=fullArr[i];
        }
		return newArr;
	}
	static String[] trimArr( String[] oldArr, int count ){
        String newArr[] = new String[count];
        for(int i=0;i<count;i++) {
              newArr[i]=oldArr[i];
        }
		return newArr; 
	}

	static int[] upSizeHisto( int[] oldArr, int newLength ){
		int newArr[] = new int[newLength];
        for(int i=0;i<oldArr.length;i++) {
              newArr[i]=oldArr[i];
        }
        return newArr;
	}
} 