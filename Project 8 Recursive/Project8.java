import java.io.*;
public class Project8
{
	public static void main( String[] args )
	{
		int rows = 5;
		System.out.format("%d row triangle tree contains %d stars\n", rows, triStars(rows) );
		int number = 12345;
		System.out.format("sum of digits in %d = %d\n", number, sumDigits( number ) );
		number = 713274772;
		System.out.format("%d occurances of digit 7 in %d\n", count7s(number), number );
		number = 82338828;
		System.out.format("%d occurances** of digit 8 in %d\n", count8s(number), number );
		int base=2,exponent=8;
		System.out.format("%d to the power %d = %d\n", base, exponent, powerN(base,exponent) );	
		int[] array = { 7, 8, 12, 20, 21, 22, 37, 41, 55, 60, 65, 74, 83, 84, 87 };
		int startingAt=0;
		boolean isSorted = isSorted( array, startingAt, array.length );
		System.out.print( "array: ");
		for ( int i=0 ; i<array.length ; ++i ) System.out.print( array[i] + " " );
		if (isSorted)
			System.out.println(" is SORTED" );	
		else
			System.out.println(" is NOT SORTED" );	
		String s = "stanleyyelnats";	
		if ( isPalindrome( s, 0, s.length()-1 ) )
			System.out.format("%s IS a palindrome\n", s );	
		else
			System.out.format("\n%s NOT a palindrome\n", s ); 	
	}
	static int triStars(int rows)  
	{
		int stars = 0;
		if (rows == 0) {
            return stars;
        }
	    stars = rows  +  triStars(rows - 1);
	    return stars;
	}
	static int sumDigits(int n) 
	{
        int sum = 0;
        if(n==0) {
            return sum;
        }
        sum = n % 10 + sumDigits(n / 10);
        return sum;
	}
	static int count7s(int n) 
	{	
        int sevens = 0;
        if (n == 0) {
            sevens = 0;
        } else if (n % 10 == 7) {
            sevens ++;
            sevens = sevens + count7s(n / 10);
        } else {
            sevens = sevens + count7s(n / 10);
        }
        return sevens;
	}
	static int count8s(int n) 
	{	
        int eights = 0;
        if (n == 0) {
            eights = 0;
        } else if (n % 100 == 88) {
            eights++;
            eights++;
            eights = eights + count8s(n / 10);
        } else if(n % 10 == 8) {
            eights++;
            eights = eights + count8s(n / 10);
        } else {
            eights = eights + count8s(n / 10);
        }
        return eights;
	}
	static int powerN(int base, int n) 
	{
        if (n == 0) {
            return 1;
        }
        return base * powerN(base, n-1);
	}
	static boolean isSorted(int array[], int i, int count ) 
	{	
        if (i == array.length - 1) {
            return true;
        }
        if (array[i] < array[i + 1]) {
            i++;
            return isSorted(array, i, count);
        }
        return false;
	}
	static boolean isPalindrome(String s, int lo, int hi ) 
	{	
        if(lo >= hi) {
            return true;
        } if(s.charAt(lo) == s.charAt(hi)) {
            return isPalindrome(s, lo + 1, hi - 1);
        } else if (s.charAt(lo) != s.charAt(hi)) {
            return false;
        }
        return false;
	}
}