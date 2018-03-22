public class MyString {
	private char[] letters;
	static final int NOT_FOUND = -1;
	public MyString(String other) 
	{ 
		letters=other.toCharArray();
	}
	public MyString(MyString other) 
	{
		letters = new char[other.length()];
		for(int i = 0; i < letters.length; i++) {
			letters[i] = other.charAt(i);
		}
	}
	public int length() 
	{
		return letters.length;
	}
	public char charAt(int index) 
	{
		return letters[index];
	}
	int compareTo(MyString other) 
	{
		int i = 0;
		int j = 0;
		while (i < this.length() && j < other.length()) {
			if(letters[i] != other.charAt(j)) {
				if((letters[i] - other.charAt(j)) < 0)
					return -1;
				else
					return 1;
			}
			++i;
			++j;
		}
		if(i<letters.length)
			return 1;
		else if(j<other.length())
			return -1;
		return 0;
	}
	public boolean equals(MyString other) 
	{
		if (this.compareTo(other) != 0)
			return false;
		return true;
	}
	public int indexOf(int startIndex, char ch) 
	{
		for (int i = startIndex; i < this.length(); i++) {
			if (ch == letters[i])
				return i;
		}
		return -1;			
	}
	private MyString wordSearch(int n, int a)
	{
		char[] cArr = new char[a-n];
		for(int i =0; i<cArr.length;i++){
			cArr[i]=this.letters[n+i];
		}
		String str = new String(cArr);
		MyString myStr = new MyString(str);
		return(myStr);
	}
	public int indexOf(MyString other) 
	{
		int indexFirst = indexOf(0, other.charAt(0) );
		int isFound =-1;
		MyString nailTemp;
		if(indexFirst == NOT_FOUND || other.length()>this.length())
			return NOT_FOUND;
		while (indexFirst != NOT_FOUND) {
			nailTemp=this.wordSearch(indexFirst,indexFirst+other.length());
			isFound=nailTemp.compareTo(other);
			if(isFound==0){
				return(indexFirst);
			}
			indexFirst=indexOf(indexFirst+1,other.charAt(0));
		}
		return NOT_FOUND;
	}
	public String toString() 
	{
		String result = "";
		for (int i = 0; i < length(); i++) {
			result += letters[i];
		}
		return result;
	}
} 